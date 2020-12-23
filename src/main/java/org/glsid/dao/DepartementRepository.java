package org.glsid.dao;

import org.glsid.entite.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, String> {

}
