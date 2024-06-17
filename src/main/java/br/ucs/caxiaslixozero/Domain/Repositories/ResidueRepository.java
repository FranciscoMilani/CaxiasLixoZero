package br.ucs.caxiaslixozero.Domain.Repositories;

import br.ucs.caxiaslixozero.Domain.Entities.Residue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ResidueRepository extends JpaRepository<Residue, Long> {
    public List<Residue> findByIdIn(Collection<Long> ids);
    
    @Query(value = "DELETE FROM ecopoint_residue WHERE residues_id = :residueId", nativeQuery = true)
    void deleteEcopointResidue(@Param("residueId") Long residueId);
    
    @Query(value = "DELETE FROM Residue e WHERE e.id = :id")
    void deleteResidue(@Param("id") Long residueId);
}
