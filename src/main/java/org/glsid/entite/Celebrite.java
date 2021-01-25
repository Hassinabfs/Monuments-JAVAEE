package org.glsid.entite;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity 
public class Celebrite implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	
	@Column(name="numCelebrite")
	private  String numC;
	@Column(length = 16)
	private String nom;
	@Column(length = 16)
	private String prenom;
	@Column(length = 10)
	private String nationalite;
	@Column(length = 06)
	private String epoque;
	
	@ManyToMany(mappedBy="celebriteS",fetch=FetchType.LAZY)
	private Collection<Monument> oeuvreDe;

	public Celebrite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Celebrite( String numC, String nom, String prenom, String nationalite, String epoque,
			Collection<Monument> oeuvreDe) {
		super();
		this.numC = numC;
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.epoque = epoque;
		this.oeuvreDe = oeuvreDe;
	}

	public  String getNumC() {
		return numC;
	}

	public void setNumC( String numC) {
		this.numC = numC;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getEpoque() {
		return epoque;
	}

	public void setEpoque(String epoque) {
		this.epoque = epoque;
	}

	public Collection<Monument> getOeuvreDe() {
		return oeuvreDe;
	}

	public void setOeuvreDe(Collection<Monument> oeuvreDe) {
		this.oeuvreDe = oeuvreDe;
	}
	
	

}
