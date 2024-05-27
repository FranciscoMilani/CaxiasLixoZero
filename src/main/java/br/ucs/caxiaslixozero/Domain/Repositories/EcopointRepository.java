package br.ucs.caxiaslixozero.Domain.Repositories;

import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface EcopointRepository extends JpaRepository<Ecopoint, Long> {
	List<Ecopoint> findFirst10ByResidueTypeIn(Collection<String> residueType);

	List<Ecopoint> findFirst10ByResidueType(String residueType);

	@Query("SELECT e FROM Ecopoint e WHERE e.ecopointAddress.neighborhood LIKE %:neighborhood%")
	List<Ecopoint> findByNeighborhoodName(@Param("neighborhood") String neighborhood);

	@Query("SELECT e FROM Ecopoint e WHERE e.companyName LIKE %:company%")
	List<Ecopoint> findByCompanyName(@Param("company") String companyName);

	@Query("SELECT e FROM Ecopoint e WHERE e.responsibleName LIKE %:responsible%")
	List<Ecopoint> findByResponsibleName(@Param("responsible") String responsibleName);

	@Query("SELECT e FROM Ecopoint e WHERE e.socialNetwork LIKE %:social%")
    List<Ecopoint> findBySocialNetwork(@Param("social") String socialNetwork);
	
	@Query("SELECT e FROM Ecopoint e WHERE e.solicitationDate = :date")
    List<Ecopoint> findBySolicitationDate(@Param("date") Date solicitationDate);

    //List<Ecopoint> findFirst10ByResidueId(Long residueId);
}
