package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.entity.OrganismeAccueil;

@Repository
public interface OrganismeAccueilRepository extends JpaRepository<OrganismeAccueil, Long> {
	public List<OrganismeAccueil> findByOrderByIdDesc();
}
