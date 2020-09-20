package domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType. FIELD )
public class QuestionContainer {
	private Question question;
	private Event event;
	public QuestionContainer(Question q) {
		this.question = q;
		this.event = q.getEvent();
	}
	public QuestionContainer() {
		question = null;
		event = null;
	}
	public Question getQuestion() {
		return question;
	}
	public Event getEvent() {
		return event;
	}
	public String toString() {
		return question+"/"+event;
	}
}