package br.ucs.caxiaslixozero.Domain.Repositories;

import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface EcopointRepository extends JpaRepository<Ecopoint, Long> {
    List<Ecopoint> findFirst10ByResidueTypeIn(Collection<String> residueType);
}
