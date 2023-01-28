package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.entity.Hebergement;
import com.cm.entity.TypeChambre;

@Repository
public interface TypeChambreRepository extends JpaRepository<TypeChambre, Long> {

	public List<TypeChambre> findByOrderByIdDesc();

	public List<TypeChambre> findByHebergementOrderByIdDesc(Hebergement heb);
}
