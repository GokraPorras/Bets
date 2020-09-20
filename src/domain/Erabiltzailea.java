package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Erabiltzailea extends User implements Serializable{

	private float diruzorroa;

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, orphanRemoval=true)
	private Vector<Mugimendua> mugi=new Vector<Mugimendua>();

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, orphanRemoval=true)
	private Vector<Bet> ebets=new Vector<Bet>();

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, orphanRemoval=true)
	private Vector<SuperBet> supereBets=new Vector<SuperBet>();


	public Erabiltzailea() {
		super();
		this.diruzorroa = 0;
	}

	public Erabiltzailea(String iz,String ab1,String ab2,String erabiz,String pass,String NAN, String jd,String email,String tlf, String helb, String pstkod,String hrld, String prob,String herria) {
		super(iz,ab1, ab2,erabiz,pass,NAN, jd,email,tlf, helb, pstkod,hrld, prob,herria);
		this.diruzorroa = 0;
	}

	public float getDiruzorroa() {
		return diruzorroa;
	}
	public void setDiruzorroa(float diruzorroa) {
		this.diruzorroa = diruzorroa;
	}
	public Vector<Mugimendua> getMugi() {
		return mugi;
	}
	public void setMugi(Vector<Mugimendua> mugi) {
		this.mugi = mugi;
	}
	public Vector<Bet> getEbets() {
		return ebets;
	}
	public void setEbets(Vector<Bet> ebets) {
		this.ebets = ebets;
	}
	public Vector<SuperBet> getSuperBets() {
		return supereBets;
	}
	public void setSuperBets(Vector<SuperBet> superBets) {
		this.supereBets = superBets;
	}

	public Mugimendua addMugimendua(float hasierakoDirua,float diruHeina,float bukaerakoDirua,String mota,Date data) {
		Mugimendua m = new Mugimendua(this,hasierakoDirua,diruHeina,bukaerakoDirua,mota,data);
		mugi.add(m);
		return m;
	}

	public Bet addEBets(float prezioa,Result res)  {
		Bet bet = new Bet(prezioa,res,this);
		ebets.add(bet);
		return bet;
	}
	public boolean removeBet(Bet b) {
		if(ebets.contains(b)) {
			diruzorroa += b.getPrice();
			addMugimendua(diruzorroa-b.getPrice(),b.getPrice(),diruzorroa, "ITZULKETA",new Date());
			ebets.remove(b);
			return true;
		}
		return false;
	}
	public boolean removeSuperBet(SuperBet sb) {
		if(supereBets.contains(sb)) {
			diruzorroa += sb.getPrice();
			addMugimendua(diruzorroa-sb.getPrice(),sb.getPrice(),diruzorroa, "ITZULKETA",new Date());
			supereBets.remove(sb);
			return true;
		}
		return false;
	}

	public boolean amIwinner(Result re) {
		Vector<Bet> bets = new Vector<Bet>();
		Vector<SuperBet> superBets = new Vector<SuperBet>();

		boolean iwin = false;
		if(ebets==null && supereBets==null) return iwin;
		else {
			for(Bet b: ebets) {
				if(b.getResult().equals(re)) {
					diruzorroa += re.getFee()*b.getPrice();
					addMugimendua(diruzorroa-(re.getFee()*b.getPrice()),re.getFee()*b.getPrice(),diruzorroa,"IRABAZIA",new Date());
					bets.add(b);
					iwin=true;
					break;
				}
				else {
					addMugimendua(diruzorroa,0,diruzorroa,"GALDU",new Date());
					bets.add(b);
					break;
				}
			}
			int cap = 0;
			int irabazia = 0;
			boolean aurkitua = false;
			for(SuperBet sb: supereBets) {
				for(Result res: sb.getResults()) {
					for(Result resq: sb.getResults()) {
						if(resq.getQuestionFinalResult() != null) {
							if(resq.getResult().compareTo(re.getQuestionFinalResult())!=0 && resq.getResult().compareTo(resq.getQuestionFinalResult())!=0 ) {
								addMugimendua(diruzorroa,0,diruzorroa,"GALDU",new Date());
								superBets.add(sb);
								aurkitua = true;
								break;
							}
						}
					}
					if(res.getQuestionFinalResult() == null || aurkitua) {
						cap=0;
						break;
					}
					else {
						if((res.getResult().compareTo(re.getQuestionFinalResult())==0) || res.getResult().compareTo(res.getQuestionFinalResult())==0) {
							cap++;
							irabazia+=res.getFee()*sb.getPrice();
							if(cap == sb.getResults().size()) {
								irabazia+=irabazia*sb.getResults().size();
								diruzorroa += irabazia;
								addMugimendua(diruzorroa-irabazia,irabazia,diruzorroa,"IRABAZIA",new Date());
								superBets.add(sb);
								iwin=true;
								cap=0;
								irabazia=0;
								break;
							}
						}
						else {
							addMugimendua(diruzorroa,0,diruzorroa,"GALDU",new Date());
							superBets.add(sb);
							break;
						}
					}
				}
			}
			for (Bet b : bets) {
				ebets.remove(b);
				BetContainer bc = new BetContainer(b);
				bc.getResult().getBets().remove(b);
			}
			for (SuperBet sb : superBets) {
				supereBets.remove(sb);
				for (Result r : sb.getResults())
					r.getSuperBets().remove(sb);
			}
			return iwin;
		}
	}

	public Vector<SuperBet> removeSuperBetMatchResult(Result re) {
		Vector<SuperBet> sebets=new Vector<SuperBet>();
		if(supereBets.isEmpty())
			return null;
		else {
			Vector<SuperBet> reSbets = re.getSuperBets();	
			for(SuperBet b:reSbets) {
				if(b.getResults().contains(re))
					sebets.add(b);
				removeSuperBet(b);
			}
			return sebets;
		}
	}

	public boolean removeBetMatchResult(Result re) {
		if(ebets==null)
			return false;
		else {
			for(Bet b:re.getBets()) {
				BetContainer bc = new BetContainer(b);
				if(bc.getResult() == re)
					removeBet(b);
			}
			return true;
		}
	}

	public SuperBet addSuperBets(float prezioa,Vector<Result> results)  {
		SuperBet SBet = new SuperBet(prezioa,this);
		SBet.setResults(results);
		supereBets.add(SBet);
		return SBet;
	}

}
