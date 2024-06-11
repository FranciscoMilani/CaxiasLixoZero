package br.ucs.caxiaslixozero.Services;

import br.ucs.caxiaslixozero.Domain.Dtos.ResidueDto;
import br.ucs.caxiaslixozero.Domain.Entities.Residue;
import br.ucs.caxiaslixozero.Domain.Repositories.ResidueRepository;
import br.ucs.caxiaslixozero.Infrastructure.Mappers.ResidueMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResidueService {

    @PersistenceContext
    private EntityManager entityManager;

    private final ResidueRepository residueRepository;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<ResidueDto> getAllResidues() {
        return residueRepository
                .findAll()
                .stream()
                .map(ResidueMapper.INSTANCE::toResidueDto)
                .toList();
    }

    public List<Residue> getAllResiduesByIdList(List<Long> ids) {
        var res = residueRepository.findByIdIn(ids);
        System.out.println(res.size());
        return res;
    }
    
    public Residue findResidueById(Long id) {
		Optional<Residue> residueOptional = residueRepository.findById(id);
		return residueOptional.orElse(null);
	}
    
    public void deleteResidue(Long id) {
    	try {
        	residueRepository.deleteEcopointResidue(id);
		} catch (Exception e) {
		}
    	residueRepository.deleteById(id);
    }
    
    public List<Residue> findAllResidues(){
    	return residueRepository.findAll();
    }
    
	@Transactional // Anotação movida para o método
	public void saveResidue(Residue residue) {
		try {
			entityManager.persist(residue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
