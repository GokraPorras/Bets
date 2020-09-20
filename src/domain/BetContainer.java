package domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType. FIELD )
public class BetContainer {
	private Bet bet;
	private Result result;
	private Erabiltzailea erabiltzailea;
	public BetContainer(Bet b) {
		this.bet = b;
		this.result = b.getResult();
		this.erabiltzailea = b.getErabiltzailea();
	}
	public BetContainer() {
		bet = null;
		result = null;
		erabiltzailea = null;
	}
	public Bet getBet() {
		return bet;
	}
	public Result getResult() {
		return result;
	}
	public Erabiltzailea getErabiltzailea() {
		return erabiltzailea;
	}
	public String toString() {
		return bet+"/"+result+"/"+erabiltzailea;
	}
}