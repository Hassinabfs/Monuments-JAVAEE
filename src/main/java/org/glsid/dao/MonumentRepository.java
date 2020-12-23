package org.glsid.dao;

import org.glsid.entite.Monument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentRepository extends JpaRepository<Monument, String> {

}
