package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Bet implements Serializable{

	@XmlID
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@Id @GeneratedValue
	private Integer betNumber;
	private float price;

	@XmlIDREF
	private Result result;
	@XmlIDREF
	private Erabiltzailea erabiltzailea;

	public Bet() {
		super();
	}

	public Bet(float price, Result res, Erabiltzailea erab) {
		this.price = price;
		this.result = res;
		this.erabiltzailea = erab;
	}

	public int getBetNumber() {
		return betNumber;
	}
	public void setBetNumber(int betNumber) {
		this.betNumber = betNumber;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public Erabiltzailea getErabiltzailea() {
		return erabiltzailea;
	}
	public void setErabiltzailea(Erabiltzailea erab) {
		this.erabiltzailea = erab;
	}

}
