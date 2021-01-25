package org.glsid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.glsid.entite.Celebrite;
import org.glsid.entite.Departement;
import org.glsid.entite.Lieu;
import org.glsid.entite.Monument;
import org.glsid.metier.DepartementMetierImpl;
import org.glsid.metier.LieuMetier;
import org.glsid.metier.LieuMetierImpl;
import org.glsid.metier.MonumentMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonumentsApplication implements CommandLineRunner{
@Autowired
private LieuMetierImpl lieu;
@Autowired
private DepartementMetierImpl departement;
@Autowired
private MonumentMetierImpl monument;
	public static void main(String[] args) {
		SpringApplication.run(MonumentsApplication.class, args);
	}	
	
		
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		//monument.distance(codeM1, codeM2);
		
		
		//Departement d1 = departement.saveDepartement(new Departement("34","HERAULT","1053",null,null));
		//Lieu l1= lieu.saveLieu(new Lieu("34172",d1,"MONTPELLIER",3.876716,43.610769,null));
		//Lieu l2= lieu.saveLieu(new Lieu("34198",d1,"PEROLS",3.954211,43.563782,null));
		//Lieu l3= lieu.saveLieu(new Lieu("34199",d1,"PEZENAS",3.423193,43.461531,null));
		//Lieu l4= lieu.saveLieu(new Lieu("34142",d1,"LODEVE",3.313975,43.73366,null));
		//Lieu l5= lieu.saveLieu(new Lieu("34032",d1,"BEZIERS",3.215795,43.344233,null));
		//Lieu l6= lieu.saveLieu(new Lieu("34129",d1,"LATTES",3.896473,43.567296,null));
		//Lieu l7= lieu.saveLieu(new Lieu("30334",d1,"UZES",4.419946,44.01211,null));
		//Lieu l8= lieu.saveLieu(new Lieu("30189",d1,"NIMES",4.360054,43.836699,null));
		//List<Lieu> ListLieu= new ArrayList<Lieu>() ;
		//ListLieu.add(l1);
		//d1.setDep("30");
		
		
		
		//public Departement(String dep, String nomDep, String numReg,Lieu chefLieu,  Collection<Lieu> lieuS)
		//public Monument(String codeM, String nomM, String proprietaire, String typeMonument, double longitude,
				//double latitude, Collection<Celebrite> celebriteSet, Lieu localisation) 
//("spfb05ty554b","HOTEL DUFFAU","PRIVE","HOTEL_PARTICULIER",3.87521667,43.6140222,"34172");
		//Monument m1= monument.saveMonument(new Monument("spfb05ty554b","HOTEL DUFFAU","PRIVE","HOTEL_PARTICULIER",3.87521667,43.6140222,null,l1));
	}
	
}
