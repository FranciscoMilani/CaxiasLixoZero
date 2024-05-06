package br.ucs.caxiaslixozero.Services.Ecopoints;

import br.ucs.caxiaslixozero.Domain.Dtos.EcopointMapDto;
import br.ucs.caxiaslixozero.Domain.Repositories.EcopointRepository;
import br.ucs.caxiaslixozero.Infrastructure.Mappers.EcopointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EcopointServices {

	@PersistenceContext
    private EntityManager entityManager;
    private final EcopointRepository repository;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveEcopoint(Ecopoint ecoponto) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(ecoponto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<EcopointMapDto> getAllToMapEcopoint() {
        return repository
                .findAll()
                .stream()
                .map(EcopointMapper.INSTANCE::toEcopointMapDto)
                .toList();
    }

    public List<EcopointMapDto> getMapEcopointFilteredByResidue(List<String> residueTypes) {
        return repository
                .findFirst10ByResidueTypeIn(residueTypes)
                .stream()
                .map(EcopointMapper.INSTANCE::toEcopointMapDto)
                .toList();
    }

//    public List<EcopointMapDto> getMapEcopointFilteredByNeighborhood(String neighborhood) {
//        return _repository
//                .findByNeighborhoodAddressIn(neighborhoods)
//                .stream()
//                .map(EcopointMapper.INSTANCE::toEcopointMapDto)
//                .toList();
//    }
}
