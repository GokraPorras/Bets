package domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType. FIELD )
public class ResultContainer {
	private Result result;
	private Question question;
	public ResultContainer(Result r) {
		this.result = r;
		this.question = r.getQuestion();
	}
	public ResultContainer() {
		result = null;
		question = null;
	}
	public Result getResult() {
		return result;
	}
	public Question getQuestion() {
		return question;
	}
	public String toString() {
		return result+"/"+question;
	}
}