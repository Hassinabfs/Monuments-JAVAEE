package org.glsid.dao;

import java.util.Optional;

import org.glsid.entite.Lieu;
import org.glsid.entite.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LieuRepository extends JpaRepository<Lieu, String>{


}
