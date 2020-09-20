package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Langilea extends User implements Serializable{

	public Langilea() {
		super();
	}

	public Langilea(String iz,String ab1,String ab2,String erabiz,String pass,String NAN, String jd,String email,String tlf, String helb, String pstkod,String hrld, String prob,String herria) {
		super(iz,ab1, ab2,erabiz,pass,NAN, jd,email,tlf, helb, pstkod,hrld, prob, herria);
	}

}
