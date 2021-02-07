package org.glsid.entite;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity 

public class Monument implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	
	@Column(name = "codeM",length = 25)
	private String codeM;
	@Column(name = "nomM",length = 40)
	private String nomM ;
	@Column(length = 10)
	private String proprietaire ;
	@Column(name = "typeMonument",length = 40)
	private String typeMonument;
	private double longitude;
	private double latitude;
	
	@ManyToMany
	@JoinTable(name="associe",joinColumns=@JoinColumn(name="codeM"),
	inverseJoinColumns =@JoinColumn(name="numC"))
	
	private Collection<Celebrite> celebriteS;
	
	@ManyToOne
	@JoinColumn(name="codeInsee")
	private Lieu localisation;
	
	
	
	public Monument() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Monument(String codeM, String nomM, String proprietaire, String typeMonument, double longitude,
			double latitude, Collection<Celebrite> celebriteSet, Lieu localisation) {
		super();
		this.codeM = codeM;
		this.nomM = nomM;
		this.proprietaire = proprietaire;
		this.typeMonument = typeMonument;
		this.longitude = longitude;
		this.latitude = latitude;
		
		this.localisation = localisation;
	}

	public String getCodeM() {
		return codeM;
	}

	public void setCodeM(String codeM) {
		this.codeM = codeM;
	}

	public String getNomM() {
		return nomM;
	}

	public void setNomM(String nomM) {
		this.nomM = nomM;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public String getTypeMonument() {
		return typeMonument;
	}

	public void setTypeMonument(String typeMonument) {
		this.typeMonument = typeMonument;
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



	public Lieu getLocalisation() {
		return localisation;
	}

	public void setLocalisation(Lieu localisation) {
		this.localisation = localisation;
	}

	public Collection<Celebrite> getCelebriteS() {
		return celebriteS;
	}

	public void setCelebriteS(Collection<Celebrite> celebriteS) {
		this.celebriteS = celebriteS;
	}

	
	
	
	
}
