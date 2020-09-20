package domain;

import java.util.Vector;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType. FIELD )
public class SuperBetContainer {
	private SuperBet superBet;
	private Erabiltzailea erabiltzailea;
	private Vector<Result> results;
	public SuperBetContainer(SuperBet sb) {
		this.superBet = sb;
		this.erabiltzailea = sb.getErabiltzailea();
		this.results = sb.getResults();
	}
	public SuperBetContainer() {
		superBet = null;
		erabiltzailea = null;
	}
	public SuperBet getSuperBet() {
		return superBet;
	}
	public Erabiltzailea getErabiltzailea() {
		return erabiltzailea;
	}
	public Vector<Result> getResults() {
		return results;
	}
	public String toString() {
		return superBet+"/"+erabiltzailea+"/"+results;
	}
}