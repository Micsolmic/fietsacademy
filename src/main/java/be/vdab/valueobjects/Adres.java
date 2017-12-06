package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class Adres implements Serializable{

	private static final long serialVersionUID = 1L;
	private String straat;
	private String huisNr;
	private String postcode;
	private String gemeente;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//getters, geen setters - IMMUTABLE
	
	protected Adres() {
		
	//Default nullary constructor, calls nullary of super and set own var to default
		
	}
	
	public Adres(String straat, String huisnr, String postcode, String gemeente) {
		
		this.straat = straat;
		this.huisNr = huisnr;
		this.postcode = postcode;
		this.gemeente = gemeente;
		
	}
	
	public String getStraat() {
		return straat;
	}
	public String getHuisNr() {
		return huisNr;
	}
	public String getPostcode() {
		return postcode;
	}
	public String getGemeente() {
		return gemeente;
	}
	
}
