package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.entity.TypeSubvention;

@Repository
public interface TypeSubventionRepository extends JpaRepository<TypeSubvention, Long> {
	List<TypeSubvention> findByOrderByIdDesc();
}
