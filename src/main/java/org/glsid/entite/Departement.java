package org.glsid.entite;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class Departement implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	
	@Column(length = 4)
	private String dep;
	
	@Column(length = 46,name = "chefLieu")
	private String chefLieu;
	
	@Column(length = 30,name = "nomDep")
	private String nomDep;
	
	@Column(length = 5,name = "reg")
	private String numReg;
	
	
	//@OneToMany(mappedBy="dep",fetch=FetchType.LAZY)
	//private Collection<Lieu> lieuS;

	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departement(String dep, String nomDep, String numReg,String chefLieu) {
		super();
		this.dep = dep;
		this.chefLieu = chefLieu;
		this.nomDep = nomDep;
		this.numReg = numReg;
		
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getChefLieu() {
		return chefLieu;
	}

	public void setChefLieu(String chefLieu) {
		this.chefLieu = chefLieu;
	}

	public String getNomDep() {
		return nomDep;
	}

	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}
	public String getNumReg() {
		return numReg;
	}

	public void setNumReg(String numReg) {
		this.numReg = numReg;
	}
	
	

	@Override
	public String toString() {
		return "Departement [dep=" + dep + ", chefLieu=" + chefLieu + ", nomDep=" + nomDep + ", numReg=" + numReg
				+  "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
