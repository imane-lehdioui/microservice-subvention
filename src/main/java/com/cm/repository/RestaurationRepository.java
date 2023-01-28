package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.entity.Restauration;
import com.cm.entity.Subvention;

@Repository
public interface RestaurationRepository extends JpaRepository<Restauration, Long> {

	public List<Restauration> findByOrderByIdDesc();

	public List<Restauration> findBySubventionOrderByIdDesc(Subvention sub);
}
