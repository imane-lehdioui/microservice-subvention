package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.entity.Hebergement;
import com.cm.entity.Subvention;

@Repository
public interface HebergementRepository extends JpaRepository<Hebergement, Long> {

	public List<Hebergement> findByOrderByIdDesc();

	public List<Hebergement> findBySubventionOrderByIdDesc(Subvention sub);

}
