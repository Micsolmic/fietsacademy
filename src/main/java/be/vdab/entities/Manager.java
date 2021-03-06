package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// enkele imports
@Entity
@Table(name = "managers")
public class Manager implements Serializable {
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String voornaam;
private String familienaam;
@OneToOne( 
fetch = FetchType.LAZY, 
mappedBy = "manager") 
private Campus campus;
// Je maakt getters voor id, voornaam, familienaam en campus
public static long getSerialversionuid() {
	return serialVersionUID;
}
public long getId() {
	return id;
}
public String getVoornaam() {
	return voornaam;
}
public String getFamilienaam() {
	return familienaam;
}
public Campus getCampus() {
	return campus;
}
public void setId(long id) {
	this.id = id;
}
public void setVoornaam(String voornaam) {
	this.voornaam = voornaam;
}
public void setFamilienaam(String familienaam) {
	this.familienaam = familienaam;
}
public void setCampus(Campus campus) {
	this.campus = campus;
}
}