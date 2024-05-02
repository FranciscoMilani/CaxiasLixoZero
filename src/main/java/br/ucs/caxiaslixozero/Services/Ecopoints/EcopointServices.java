package br.ucs.caxiaslixozero.Services.Ecopoints;

import org.springframework.stereotype.Service;

import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;

@Service
public class EcopointServices {

	@PersistenceContext
    private EntityManager entityManager;
    
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
}
