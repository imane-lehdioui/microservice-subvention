package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.entity.Impression;
import com.cm.entity.TypeImpression;

@Repository
public interface TypeImpressionRepository extends JpaRepository<TypeImpression, Long> {

	public List<TypeImpression> findByOrderByIdDesc();

	public List<TypeImpression> findByImpressionOrderByIdDesc(Impression impression);
}
