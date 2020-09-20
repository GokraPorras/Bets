package domain;

import java.io.Serializable;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class SuperBet implements Serializable{

	@XmlID
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@Id @GeneratedValue
	private Integer superBetNumber;
	private float price;
	@XmlIDREF
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Vector<Result> results = new Vector<Result>();

	@XmlIDREF
	private Erabiltzailea erabiltzailea;

	
	public SuperBet() {
		super();
	}
	public SuperBet(Integer superBetNumber, float price, Erabiltzailea erab) {
		this.superBetNumber = superBetNumber;
		this.price = price;
		this.erabiltzailea = erab;
	}
	public SuperBet(float price, Erabiltzailea erab) {
		this.price = price;
		this.erabiltzailea = erab;
	}

	public int getSuperBetNumber() {
		return superBetNumber;
	}
	public void setSuperBetNumber(Integer superBetNumber) {
		this.superBetNumber = superBetNumber;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Vector<Result> getResults() {
		return results;
	}
	public void setResults(Vector<Result> results) {
		this.results = results;
	}
	public Erabiltzailea getErabiltzailea() {
		return erabiltzailea;
	}
	public void setErabiltzailea(Erabiltzailea erab) {
		this.erabiltzailea = erab;
	}
	
	public void addResultsBet() {
        for(Result res: results) {
            res.addSuperBet(this);
        }
    }

}
