package domain;

import java.io.*;
import java.util.Vector;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Question implements Serializable {

	@XmlID
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@Id @GeneratedValue
	private Integer questionNumber;
	private String emaitzaFinala;
	private String question; 
	private float betMinimum;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, orphanRemoval=true)
	private Vector<Result> results = new Vector<Result>();

	@XmlIDREF
	private Event event;


	public Question(){
		super();
	}

	public Question(Integer queryNumber, String query, float betMinimum, Event event) {
		this.questionNumber = queryNumber;
		this.question = query;
		this.betMinimum=betMinimum;
		this.event = event;
	}

	public Question(String query, float betMinimum,  Event event) {
		this.question = query;
		this.betMinimum=betMinimum;
		this.event = event;
	}

	/**
	 * Get the  number of the question
	 * 
	 * @return the question number
	 */
	public Integer getQuestionNumber() {
		return questionNumber;
	}

	/**
	 * Set the bet number to a question
	 * 
	 * @param questionNumber to be setted
	 */
	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}

	/**
	 * Get the question description of the bet
	 * 
	 * @return the bet question
	 */

	public String getQuestion() {
		return question;
	}

	/**
	 * Set the question description of the bet
	 * 
	 * @param question to be setted
	 */	
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * Get the minimun ammount of the bet
	 * 
	 * @return the minimum bet ammount
	 */
	public float getBetMinimum() {
		return betMinimum;
	}

	/**
	 * Get the minimun ammount of the bet
	 * 
	 * @param  betMinimum minimum bet ammount to be setted
	 */
	public void setBetMinimum(float betMinimum) {
		this.betMinimum = betMinimum;
	}

	public String getEmaitzaFinala() {
		return emaitzaFinala;
	}

	public void setEmaitzaFinala(String result) {
		this.emaitzaFinala = result;
	}

	/**
	 * Get the result of the  query
	 * 
	 * @return the the query result
	 */
	public Vector<Result> getResults() {
		return results;
	}

	/**
	 * Get the result of the  query
	 * 
	 * @param result of the query to be setted
	 */
	public void setResults(Vector<Result> result) {
		this.results = result;
	}

	/**
	 * Get the event associated to the bet
	 * 
	 * @return the associated event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * Set the event associated to the bet
	 * 
	 * @param event to associate to the bet
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	public Result addResult(String result, float fee)  {
		Result r= new Result(result,fee, this);
		results.add(r);
		return r;
	}

	public boolean DoesResultExists(String result)  {	
		for (Result r:this.getResults()){
			if (r.getResult().compareTo(result)==0)
				return true;
		}
		return false;
	}

	public boolean removeResult(Result re) {
		if (results.contains(re)) {
			results.remove(re);
			return true;
		}
		return false;
	}

	public Vector<Erabiltzailea> WhatPeopleParticipate(){
		Vector<Erabiltzailea> erabs = new Vector<Erabiltzailea>();
		for(Result re: results) {
			erabs.addAll(re.WhatPeopleParticipate());
		}
		return erabs;

	}

	public String toString(){
		return questionNumber+";"+question+";"+Float.toString(betMinimum);
	}

}