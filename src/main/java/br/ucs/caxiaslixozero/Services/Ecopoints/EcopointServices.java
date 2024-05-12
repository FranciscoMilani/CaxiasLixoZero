package br.ucs.caxiaslixozero.Services.Ecopoints;

import br.ucs.caxiaslixozero.Domain.Dtos.EcopointMapDto;
import br.ucs.caxiaslixozero.Domain.Repositories.EcopointRepository;
import br.ucs.caxiaslixozero.Infrastructure.Mappers.EcopointMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import br.ucs.caxiaslixozero.Domain.Entities.Address;
import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EcopointServices {

	private final EntityManager entityManager; // Removido o autowiring

	private final EcopointRepository repository;

	@Transactional // Anotação movida para o método
	public void saveEcopoint(Ecopoint ecoponto) {
		try {
			entityManager.persist(ecoponto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional // Anotação movida para o método
	public void updateEcopoint(Ecopoint ecoponto) {
		try {
			entityManager.merge(ecoponto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional // Anotação movida para o método
	public Address saveAddress(Address address) {
		try {
			entityManager.persist(address);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return address;
	}
	
	public List<Ecopoint> getAllEcopoints(){
		return repository.findAll();
	}
	
	public Ecopoint findEcopointById(Long id){
		Optional<Ecopoint> ecopointOptional = repository.findById(id);
	    return ecopointOptional.orElse(null);
	}

	public List<EcopointMapDto> getAllToMapEcopoint() {
		return repository.findAll().stream().map(EcopointMapper.INSTANCE::toEcopointMapDto).toList();
	}

	public List<EcopointMapDto> getMapEcopointFilteredByResidue(List<String> residueTypes) {
		return repository.findFirst10ByResidueTypeIn(residueTypes).stream()
				.map(EcopointMapper.INSTANCE::toEcopointMapDto).toList();
	}

//    public List<EcopointMapDto> getMapEcopointFilteredByNeighborhood(String neighborhood) {
//        return _repository
//                .findByNeighborhoodAddressIn(neighborhoods)
//                .stream()
//                .map(EcopointMapper.INSTANCE::toEcopointMapDto)
//                .toList();
//    }
}
