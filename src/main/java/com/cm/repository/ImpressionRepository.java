package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.entity.Impression;
import com.cm.entity.Subvention;

@Repository
public interface ImpressionRepository extends JpaRepository<Impression, Long> {

	public List<Impression> findByOrderByIdDesc();

	public List<Impression> findBySubventionOrderByIdDesc(Subvention sub);
}
