package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.entity.Restauration;
import com.cm.entity.TypePlat;

@Repository
public interface TypePlatRepository extends JpaRepository<TypePlat, Long> {

	public List<TypePlat> findByOrderByIdDesc();

	public List<TypePlat> findByRestaurationOrderByIdDesc(Restauration restauration);
}
