package domain;

import java.io.Serializable;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Result implements Serializable{

	@XmlID
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@Id @GeneratedValue
	private Integer feeNumber;
	private String result;
	private float fee;

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, orphanRemoval=true)
	private Vector<Bet> bets = new Vector<Bet>();

	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Vector<SuperBet> superBets=new Vector<SuperBet>();

	@XmlIDREF
	private Question question;


	public Result(){
		super();
	}

	public Result(Integer feeNumber, String result, float fee, Question question) {
		this.feeNumber = feeNumber;
		this.result = result;
		this.fee = fee;
		this.question = question;
	}

	public Result(String result, float fee, Question question) {
		this.result = result;
		this.fee = fee;
		this.question = question;
	}

	public Integer getFeeNumber() {
		return feeNumber;
	}
	public void setFeeNumber(Integer feeNumber) {
		this.feeNumber = feeNumber;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public Vector<Bet> getBets() {
		return bets;
	}
	public void setBets(Vector<Bet> bets) {
		this.bets = bets;
	}
	public Vector<SuperBet> getSuperBets() {
		return superBets;
	}
	public void setSuperBets(Vector<SuperBet> superBets) {
		this.superBets = superBets;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getQuestionFinalResult() {
		return question.getEmaitzaFinala();
	}

	public Vector<Erabiltzailea> WhatPeopleParticipate() {
		Vector<Erabiltzailea> erabs = new Vector<Erabiltzailea>();
		for(Bet e: bets) {
			Erabiltzailea erab = e.getErabiltzailea();
			if(!erabs.contains(erab))
				erabs.add(erab);
		}

		for(SuperBet e: superBets) {
			Erabiltzailea erab = e.getErabiltzailea();
			if(!erabs.contains(erab))
				erabs.add(erab);
		}
		return erabs;
	}
	
	public boolean removeBet(Bet b) {
		if (bets.contains(b)) {
			bets.remove(b);
			return true;
		}
		return false;
	}

	public boolean removeSuperBet(SuperBet sb) {
		if (superBets.contains(sb)) {
			superBets.remove(sb);
			return true;
		}
		return false;
	}

	public Bet addBet(Bet sb) {
        bets.add(sb);
        return sb;
    }

	public SuperBet addSuperBet(SuperBet sb) {
        superBets.add(sb);
        return sb;
    }

	public String toString(){
		return feeNumber+";"+result+";"+Double.toString(fee);
	}

}
