package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.TelefoonNr;

@Table(name="campussen")
@Entity
public class Campus implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	@Embedded
	private Adres adres;
	
	@ElementCollection
	@CollectionTable(name="campussentelefoonnrs", joinColumns = @JoinColumn(name="campusid"))
	@OrderBy("fax")	
	private Set<TelefoonNr> telefoonNrs;
	
	
	@OneToMany
	@JoinColumn(name =  "campusid")
	@OrderBy("voornaam, familienaam")
	private Set<Docent> docenten;
	
	public Set<Docent> getDocenten() { return Collections.unmodifiableSet(docenten); } 
	public void add(Docent docent) { docenten.add(docent); }
	public void remove(Docent docent) { docenten.remove(docent); }
	
	
	protected Campus() {}
	
	public Campus(String naam, Adres adres) {
		setNaam(naam);
		setAdres(adres);
		this.telefoonNrs = new LinkedHashSet<>();
		this.docenten = new LinkedHashSet<>(); 
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	
	
	public Set<TelefoonNr> getTelefoonNrs() {  
			return Collections.unmodifiableSet(telefoonNrs); 
			}
	public void add(TelefoonNr telefoonNr) {  
		telefoonNrs.add(telefoonNr); 
		} 
	public void remove(TelefoonNr telefoonNr) { 
		telefoonNrs.remove(telefoonNr); 
		}
	
}
