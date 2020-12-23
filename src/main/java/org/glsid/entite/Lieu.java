package org.glsid.entite;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity 
// c'est pour la partie mapping objet relationel

public class Lieu implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// les anotations qui sont obligatoire 
	@Id

	@Column(name = "codeInsee",length = 5)
	private String codeInsee;
	
	@ManyToOne
	@JoinColumn(name="dep")
	private Departement dep;
	@Column(name = "nomCom",length = 46)
	private String nomCom;
	private double longitude;
	private double latitude;
	
	// on a une association one to many
	@OneToMany(mappedBy="localisation",fetch=FetchType.LAZY)
	//parametre pardefaut fetch de type lazy le framework hibernate va charger un lieu a partir de la base de donnee et il charge que les information qui concerne ce lieu il va pas charger la liste des monuments
	//les lieus ne seront charger qu on veut
	private Collection <Monument> monument;
	
	
	public Lieu() {
		super();
	}


	public Lieu(String codeInsee, Departement dep, String nomCom, double longitude, double latitude,
			Collection<Monument> monument) {
		super();
		this.codeInsee = codeInsee;
		this.dep = dep;
		this.nomCom = nomCom;
		this.longitude = longitude;
		this.latitude = latitude;
		this.monument = monument;
	}
	

	public String getCodeInsee() {
		return codeInsee;
	}


	public void setCodeInsee(String codeInsee) {
		this.codeInsee = codeInsee;
	}


	public Departement getDep() {
		return dep;
	}


	public void setDep(Departement dep) {
		this.dep = dep;
	}


	public String getNomCom() {
		return nomCom;
	}


	public void setNomCom(String nomCom) {
		this.nomCom = nomCom;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public Collection<Monument> getMonument() {
		return monument;
	}


	public void setMonument(Collection<Monument> monument) {
		this.monument = monument;
	}


	
	
	
	
	
	
	
}
