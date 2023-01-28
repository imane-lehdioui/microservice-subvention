package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.entity.SousTypeSubvention;

@Repository
public interface SousTypeSubventionRepository extends JpaRepository<SousTypeSubvention, Long> {
	List<SousTypeSubvention> findByOrderByIdDesc();
}
