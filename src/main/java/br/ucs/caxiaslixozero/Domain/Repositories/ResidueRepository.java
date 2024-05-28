package br.ucs.caxiaslixozero.Domain.Repositories;

import br.ucs.caxiaslixozero.Domain.Entities.Residue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ResidueRepository extends JpaRepository<Residue, Long> {
    public List<Residue> findByIdIn(Collection<Long> ids);
}
