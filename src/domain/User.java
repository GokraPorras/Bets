package domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class User implements Serializable{

	String izena;
	String abizena1;
	String abizena2;
	@Id @XmlID
	String erabizena;
	String pasahitza;
	String NAN;
	String jaiotzedata;
	String email;
	String TlfZenbakia;
	String herrialdea;
	String probintzia;
	String herria;
	String postakodea;
	String helbidea;

	public User() {
		super();
	}

	public User(String iz,String ab1,String ab2,String erabiz,String pass,String NAN, String jd,String email,String tlf, String helb, String pstkod,String hrld, String prob,String herria) {
		this.izena = iz;
		this.abizena1 = ab1;
		this.abizena2 = ab2;
		this.erabizena = erabiz;
		this.pasahitza = pass;
		this.NAN = NAN;
		this.jaiotzedata = jd;
		this.email = email;
		this.TlfZenbakia = tlf;
		this.herrialdea = hrld;
		this.probintzia = prob;
		this.herria = herria;
		this.postakodea = pstkod;
		this.helbidea = helb;
	}

	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getAbizena1() {
		return abizena1;
	}
	public void setAbizena1(String abizena1) {
		this.abizena1 = abizena1;
	}
	public String getAbizena2() {
		return abizena2;
	}
	public void setAbizena2(String abizena2) {
		this.abizena2 = abizena2;
	}
	public String getErabizena() {
		return erabizena;
	}
	public void setErabizena(String erabizena) {
		this.erabizena = erabizena;
	}
	public String getPasahitza() {
		return pasahitza;
	}
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	public String getNAN() {
		return NAN;
	}
	public void setNAN(String nAN) {
		NAN = nAN;
	}
	public String getJaiotzedata() {
		return jaiotzedata;
	}
	public void setJaiotzedata(String jaiotzedata) {
		this.jaiotzedata = jaiotzedata;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTlfZenbakia() {
		return TlfZenbakia;
	}
	public void setTlfZenbakia(String tlfZenbakia) {
		TlfZenbakia = tlfZenbakia;
	}
	public String getHerrialdea() {
		return herrialdea;
	}
	public void setHerrialdea(String herrialdea) {
		this.herrialdea = herrialdea;
	}
	public String getProbintzia() {
		return probintzia;
	}
	public void setProbintzia(String probintzia) {
		this.probintzia = probintzia;
	}
	public String getHerria() {
		return herria;
	}
	public void setHerria(String herria) {
		this.herria = herria;
	}
	public String getPostakodea() {
		return postakodea;
	}
	public void setPostakodea(String postakodea) {
		this.postakodea = postakodea;
	}
	public String getHelbidea() {
		return helbidea;
	}
	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}

	@Override
	public String toString() {
		return "User [UserID=" + ", izena=" + izena + ", abizena1=" + abizena1 + ", abizena2=" + abizena2
				+ ", erabizena=" + erabizena + ", pasahitza=" + pasahitza + ", NAN=" + NAN + ", jaiotzedata="
				+ jaiotzedata + ", email=" + email + ", TlfZenbakia=" + TlfZenbakia + ", herrialdea=" + herrialdea
				+ ", probintzia=" + probintzia + ", herria=" + herria + ", postakodea=" + postakodea + ", helbidea="
				+ helbidea + ", kalea=" + "]";
	}

}
