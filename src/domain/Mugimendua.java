package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Mugimendua implements Serializable{

	@XmlID
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@Id @GeneratedValue
	private Integer MugiNumber;
	private float hasierakoDirua;
	private float diruHeina;
	private float bukaerakoDirua;
	private String mota;
	private Date data;

	@XmlIDREF
	@OneToOne
	private Erabiltzailea erabiltzailea;

	public Mugimendua() {
		super();
	}

	public Mugimendua(Erabiltzailea erab,float hasierakoDirua,float diruHeina,float bukaerakoDirua,String mota,Date data) {
		this.erabiltzailea=erab;
		this.hasierakoDirua=hasierakoDirua;
		this.diruHeina=diruHeina;
		this.bukaerakoDirua=bukaerakoDirua;
		this.mota=mota;
		this.data=data;
	}

	public Integer getMugiNumber() {
		return MugiNumber;
	}
	public void setMugiNumber(Integer mugiNumber) {
		MugiNumber = mugiNumber;
	}
	public float getHasierakoDirua() {
		return hasierakoDirua;
	}
	public void setHasierakoDirua(float hasierakoDirua) {
		this.hasierakoDirua = hasierakoDirua;
	}
	public float getDiruHeina() {
		return diruHeina;
	}
	public void setDiruHeina(float dirua) {
		this.diruHeina = dirua;
	}
	public float getBukaerakoDirua() {
		return bukaerakoDirua;
	}
	public void setBukaerakoDirua(float bukaerakoDirua) {
		this.bukaerakoDirua = bukaerakoDirua;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Erabiltzailea getErabiltzailea() {
		return erabiltzailea;
	}
	public void setErabiltzailea(Erabiltzailea erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}
	

}
