package br.ucs.caxiaslixozero.Domain.Repositories;

import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface EcopointRepository extends JpaRepository<Ecopoint, Long> {
    List<Ecopoint> findFirst10ByResidueTypeIn(Collection<String> residueType);

    List<Ecopoint> findFirst10ByResidueType(String residueType);

    @Query("SELECT e FROM Ecopoint e WHERE e.ecopointAddress.neighborhood LIKE %:neighborhood%")
    List<Ecopoint> findByNeighborhoodName(@Param("neighborhood") String neighborhood);

    //List<Ecopoint> findFirst10ByResidueId(Long residueId);
}
