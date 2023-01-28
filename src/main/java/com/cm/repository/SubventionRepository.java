package com.cm.repository;

import java.util.Date;
import java.util.List;

import com.cm.beans.subventionStatbean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cm.entity.Subvention;

@Repository
public interface SubventionRepository extends JpaRepository<Subvention, Long> {
	
	public List<Subvention> findByOrderByIdDesc();

	@Query("SELECT c FROM Subvention c where  c.idAssociation=?1")
	public List<Subvention> findByIdAssociationOrderByIdDesc(long idAssociation);
	//@Query(value ="SELECT * FROM sub_subvention s where s.MONTANT_SUBVENTION!=0 and s.ID_ASSOCIATION=?" , nativeQuery=true )
	

	//@Query("SELECT c FROM Subvention c where c.montantSubvention=0 and c.idAssociation=?1")
	@Query(value = "SELECT * FROM sub_subvention s where s.MONTANT_SUBVENTION=0 and s.ID_ASSOCIATION=?", nativeQuery = true)
	public List<Subvention> findByIdAssociationOrderByIdAsc(long idAssociation);

	@Query(value = "SELECT new com.cm.beans.subventionStatbean(count(s.id) , s.statutProjet, s.idAssociation) FROM Subvention  s where s.dateDepotDemande between    :d1  AND :d2  and s.statutProjet  in (:statutProjet) " +
			" group by s.idAssociation,s.statutProjet" )
	public List<subventionStatbean> getStatBydateAndstatutAndArron(@Param("statutProjet")List<Long> statutProjet, @Param("d1") Date d1, @Param("d2") Date   d2);
	@Query(value = "SELECT s FROM Subvention  s where s.idAssociation = :id and s.dateDepotDemande between    :d1  AND :d2 " )
	public List<Subvention> getStatSUbvenstionByAss( @Param("id") long id , @Param("d1") Date d1, @Param("d2") Date   d2);


}
