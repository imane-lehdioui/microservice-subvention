package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.entity.FournisseurRestauration;

@Repository
public interface FournisseurRestaurationRepository extends JpaRepository<FournisseurRestauration, Long> {

	public List<FournisseurRestauration> findByOrderByIdDesc();
}
