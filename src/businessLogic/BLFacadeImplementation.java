package businessLogic;

import java.util.Date;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.jws.WebMethod;
import javax.jws.WebService;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Question;
import domain.Result;
import domain.ResultContainer;
import domain.SuperBet;
import domain.SuperBetContainer;
import domain.User;
import domain.Admin;
import domain.Bet;
import domain.BetContainer;
import domain.Erabiltzailea;
import domain.Event;
import domain.Langilea;
import domain.Mugimendua;
import domain.MugimenduaContainer;
import domain.QuestionContainer;
import exceptions.EndResultAlreadyExists;
import exceptions.EventFinished;
import exceptions.EventInCurrent;
import exceptions.MaximumMoneyInserted;
import exceptions.NotEnoughMoney;
import exceptions.QuestionAlreadyExist;
import exceptions.ResultAlreadyExist;
import exceptions.SuperBetMinimumRes;
import exceptions.betMinimum;

/**
 * It implements the business logic as a web service.
 */
@WebService(endpointInterface = "businessLogic.BLFacade")
public class BLFacadeImplementation  implements BLFacade {

	public BLFacadeImplementation()  {		
		System.out.println("Creating BLFacadeImplementation instance");
		ConfigXML c=ConfigXML.getInstance();

		if (c.getDataBaseOpenMode().equals("initialize")) {
			DataAccess dbManager=new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
			dbManager.initializeDB();
			dbManager.close();
		}
	}

	//	----------------------------------------------------

	/**
	 * This method invokes the data access to initialize the database with some events and questions.
	 * It is invoked only when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
	@WebMethod	
	public void initializeBD(){
		DataAccess dBManager=new DataAccess();
		dBManager.initializeDB();
		dBManager.close();
	}

	//	----------------------------------------------------

	/**
	 * This method insert new user in database; if the user does not exist in DB
	 * 
	 * @param Izena user name
	 * @param Pasahitza user password
	 * @return true <--> user does not exists in database
	 */
	@WebMethod
	public boolean Register(boolean langileaDa, String iz,String ab1,String ab2,String erabiz,String pass,String NAN, String jd,String email,String tlf, String helb, String pstkod,String hrld, String prob,String herria) {
		DataAccess dbManager=new DataAccess();
		boolean b=dbManager.Register(langileaDa, iz,ab1, ab2,erabiz,pass,NAN, jd,email,tlf, helb, pstkod,hrld, prob, herria);
		dbManager.close();
		return b;
	}

	/**
	 * This method check if user exist in Database 
	 * 
	 * @param Izena user name
	 * @param Pasahitza  user password
	 * @return true <--> user exists in database
	 */
	@WebMethod
	public boolean isRegister(String Izena, String Pasahitza) {
		DataAccess dbManager=new DataAccess();
		boolean b = dbManager.isRegister(Izena, Pasahitza);
		dbManager.close();
		return b;
	}

	//	----------------------------------------------------

	@WebMethod
	public QuestionContainer getQuestionContainer(Question question) {
		DataAccess dbManager = new DataAccess();
		QuestionContainer  QuestionContainer = dbManager.getQuestionContainer(question);
		dbManager.close();
		return QuestionContainer;
	}

	@WebMethod
	public ResultContainer getResultContainer(Result result) {
		DataAccess dbManager = new DataAccess();
		ResultContainer  ResultContainer = dbManager.getResultContainer(result);
		dbManager.close();
		return ResultContainer;
	}

	@WebMethod
	public BetContainer getBetContainer(Bet bet) {
		DataAccess dbManager = new DataAccess();
		BetContainer  BetContainer = dbManager.getBetContainer(bet);
		dbManager.close();
		return BetContainer;
	}

	@WebMethod
	public SuperBetContainer getSuperBetContainer(SuperBet superBet) {
		DataAccess dbManager = new DataAccess();
		SuperBetContainer  SuperBetContainer = dbManager.getSuperBetContainer(superBet);
		dbManager.close();
		return SuperBetContainer;
	}

	@WebMethod
	public MugimenduaContainer getMugimenduaContainer(Mugimendua mugimendua) {
		DataAccess dbManager = new DataAccess();
		MugimenduaContainer MugimenduaContainer = dbManager.getMugimenduaContainer(mugimendua);
		dbManager.close();
		return MugimenduaContainer;
	}

	//	----------------------------------------------------

	/**
	 * This method invokes the data access to retrieve the events of a given date 
	 * 
	 * @param date in which events are retrieved
	 * @return collection of events
	 */
	@WebMethod	
	public Vector<Event> getEvents(Date date)  {
		DataAccess dbManager=new DataAccess();
		Vector<Event>  events=dbManager.getEvents(date);
		dbManager.close();
		return events;
	}

	@WebMethod
	public Vector<Question> getQuestions(Event event) {
		DataAccess dbManager=new DataAccess();
		Vector<Question>  qu=dbManager.getQuestions(event);
		dbManager.close();
		return qu;
	}

	@WebMethod
	public Vector<Result> getResults(Question question) {
		DataAccess dbManager=new DataAccess();
		Vector<Result>  qu=dbManager.getResults(question);
		dbManager.close();
		return qu;
	}

	@WebMethod
	public Vector<Mugimendua> getMugimenduak(String izena)  {
		DataAccess dbManager=new DataAccess();
		Vector<Mugimendua>  mugimenduak=dbManager.getMugimenduak(izena);
		dbManager.close();
		return mugimenduak;
	}

	@WebMethod
	public User getUser(String Izena) {
		DataAccess dbManager=new DataAccess();
		User user = dbManager.getUser(Izena);
		dbManager.close();
		return user;
	}

	@WebMethod
	public Erabiltzailea getErabiltzailea(String erab) {
		DataAccess a = new DataAccess();
		Erabiltzailea e = a.getErabiltzailea(erab);
		return e;
	}

	@WebMethod
	public Langilea getLangilea(String erab) {
		DataAccess a = new DataAccess();
		Langilea l = a.getLangilea(erab);
		return l;
	}

	@WebMethod
	public Admin getAdmin(String erab) {
		DataAccess a = new DataAccess();
		Admin ad = a.getAdmin(erab);
		return ad;
	}

	//	----------------------------------------------------

	@WebMethod
	public void gertaeraBatBikoiztu(Event ev, Date data) throws EventFinished{
		DataAccess dbManager=new DataAccess();
		if(new Date().compareTo(data) >= 0)
			throw new EventFinished(ResourceBundle.getBundle("Etiquetas").getString("ErrorEventHasFinished"));
		dbManager.gertaeraBatBikoiztu(ev, data);
		dbManager.close();
	}

	/**
	 * This method creates a question for an event, with a question text and the minimum bet
	 * 
	 * @param event to which question is added
	 * @param question text of the question
	 * @param betMinimum minimum quantity of the bet
	 * @return the created question, or null, or an exception
	 * @throws EventFinished if current data is after data of the event
	 * @throws QuestionAlreadyExist if the same question already exists for the event
	 */
	@WebMethod
	public Question createQuestion(Event event, String question, float betMinimum) throws EventFinished, QuestionAlreadyExist{
		//The minimum bed must be greater than 0
		DataAccess dBManager=new DataAccess();
		Question qry=null;
		if(new Date().compareTo(event.getEventDate())>0)
			throw new EventFinished(ResourceBundle.getBundle("Etiquetas").getString("ErrorEventHasFinished"));
		qry=dBManager.createQuestion(event,question,betMinimum);		
		dBManager.close();
		return qry;
	};

	@WebMethod
	public Result createFee(Question q, String res, float fee) throws ResultAlreadyExist,EventFinished{
		//The minimum bed must be greater than 0
		DataAccess dBManager=new DataAccess();
		if(new Date().compareTo(dBManager.getQuestionContainer(q).getEvent().getEventDate())>0)
			throw new EventFinished(ResourceBundle.getBundle("Etiquetas").getString("ErrorEventHasFinished"));
		Result r=null;	
		r=dBManager.createFee(q,res,fee);		
		dBManager.close();
		return r;
	};

	@WebMethod
	public boolean deleteEvent(Event e) {
		boolean res = true;
		try {
			DataAccess d = new DataAccess();
			d.deleteEvent(e);
		}
		catch(Exception e1) {
			e1.printStackTrace();
			res = false;
		}
		return res;
	}

	@WebMethod
	public boolean deleteQuestion(Question q) {
		boolean res = true;
		try {
			DataAccess d = new DataAccess();
			d.deleteQuestion(q);
		}
		catch(Exception e) {
			e.printStackTrace();
			res = false;
		}
		return res;
	}

	@WebMethod
	public boolean deleteResult(Result r) {
		boolean res = true;
		try {
			DataAccess d = new DataAccess();
			d.deleteResult(r);
		}
		catch(Exception e) {
			e.printStackTrace();
			res = false;
		}
		return res;
	}

	//	----------------------------------------------------

	@WebMethod
	public void addDirua(Erabiltzailea erab,float dirua) throws MaximumMoneyInserted {
		if(dirua>500) throw new MaximumMoneyInserted(ResourceBundle.getBundle("Etiquetas").getString("MaxMoneyInsert"));
		DataAccess d = new DataAccess();
		d.addDirua(erab, dirua);
		d.close();		
	}

	@WebMethod
	public void superApustuaEgin(String erab, float price, Vector<Result> r) throws NotEnoughMoney, betMinimum, EventFinished, SuperBetMinimumRes {
		DataAccess d = new DataAccess();
		Erabiltzailea erabiltzailea = d.getErabiltzailea(erab);
		Vector<Result> results = d.getResults(r);
		float batura = 0;
		
		// bi kontainer erabili beharko dira atzera egiteko
		for (Result re : results) {
			Question q = d.getResultContainer(re).getQuestion();
			Event e = d.getQuestionContainer(q).getEvent();
			if(new Date().compareTo(e.getEventDate())>0)
				throw new EventFinished(ResourceBundle.getBundle("Etiquetas").getString("ErrorEventHasFinished"));
			batura += q.getBetMinimum();
		}
		
		if(results.size()<=1) throw new SuperBetMinimumRes(ResourceBundle.getBundle("Etiquetas").getString("SuperBetMinimumres"));
		if(erabiltzailea.getDiruzorroa()<price) throw new NotEnoughMoney(ResourceBundle.getBundle("Etiquetas").getString("NotEnoughMoney"));
		if(batura>price) throw new betMinimum(ResourceBundle.getBundle("Etiquetas").getString("betMinimum"));
		
		d.superApustuaEgin(erabiltzailea, price, results);
		d.close();
	}

	@WebMethod
	public void apustuaEgin(String erab, float price, Result res) throws NotEnoughMoney, betMinimum, EventFinished {
		DataAccess d = new DataAccess();
		// bi kontainer erabili beharko dira atzera egiteko
		if(new Date().compareTo(d.getQuestionContainer(d.getResultContainer(res).getQuestion()).getEvent().getEventDate())>0)
			throw new EventFinished(ResourceBundle.getBundle("Etiquetas").getString("ErrorEventHasFinished"));
		
		Erabiltzailea erabiltzailea = d.getErabiltzailea(erab);
		Result result = d.getResult(res);

		if(erabiltzailea.getDiruzorroa()<price) throw new NotEnoughMoney(ResourceBundle.getBundle("Etiquetas").getString("NotEnoughMoney"));
		// kontainer bat erabiliz
		if(d.getResultContainer(result).getQuestion().getBetMinimum()>price) throw new betMinimum(ResourceBundle.getBundle("Etiquetas").getString("betMinimum"));
		
		d.apustuaEgin(erabiltzailea, price, result);
		d.close();
	}

	@WebMethod
	public float getDirua(Erabiltzailea erab) {
		DataAccess d = new DataAccess();
		float diru=d.getDirua(erab);
		d.close();
		return diru;
	}

	@WebMethod
	public float getIrabazia() {
		DataAccess a = new DataAccess();
		float irabaziak = a.getIrabazia();
		a.close();
		return irabaziak;
	}

	@WebMethod
	public void emaitzaipini(Result emaitza) throws EventInCurrent, EndResultAlreadyExists {
		DataAccess a = new DataAccess();
		if(new Date().compareTo(a.getResultContainer(emaitza).getQuestion().getEvent().getEventDate())<0)
			throw new EventInCurrent(ResourceBundle.getBundle("Etiquetas").getString("ErrorEventInCurrent"));
		a.emaitzaipini(emaitza);
		a.close();
	}

	//	----------------------------------------------------

	@WebMethod
	public Vector<Erabiltzailea> getErabiltzaileak(){
		System.out.println(">> DataAccess: getUsers");
		DataAccess dbManager = new DataAccess();
		Vector<Erabiltzailea> u = dbManager.getErabiltzaileak();
		dbManager.close();
		return u;
	}

	@WebMethod
	public boolean deleteErabiltzailea(String erabizena) {
		boolean b = true;
		try {
			DataAccess d = new DataAccess();
			d.deleteErabiltzailea(erabizena);
		}
		catch(Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}

	//	----------------------------------------------------

}
