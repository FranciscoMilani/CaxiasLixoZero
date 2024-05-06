package br.ucs.caxiaslixozero.Services;

import br.ucs.caxiaslixozero.Domain.Entities.Residue;
import br.ucs.caxiaslixozero.Domain.Repositories.ResidueRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResidueService {

    @PersistenceContext
    private EntityManager entityManager;

    private final ResidueRepository residueRepository;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Residue> getAllRepositories() {
        return residueRepository.findAll();
    }

}
