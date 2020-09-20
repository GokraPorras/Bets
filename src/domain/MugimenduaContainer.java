package domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType. FIELD )
public class MugimenduaContainer {
	private Mugimendua mugimendua;
	private Erabiltzailea erabiltzailea;
	public MugimenduaContainer(Mugimendua m) {
		this.mugimendua = m;
		this.erabiltzailea = m.getErabiltzailea();
	}
	public MugimenduaContainer() {
		mugimendua = null;
		erabiltzailea = null;
	}
	public Mugimendua getMugimendua() {
		return mugimendua;
	}
	public Erabiltzailea getErabiltzailea() {
		return erabiltzailea;
	}
	public String toString() {
		return mugimendua+"/"+erabiltzailea;
	}
}