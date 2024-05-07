package br.ucs.caxiaslixozero.Services.Ecopoints;

import br.ucs.caxiaslixozero.Domain.Dtos.EcopointMapDto;
import br.ucs.caxiaslixozero.Domain.Repositories.EcopointRepository;
import br.ucs.caxiaslixozero.Infrastructure.Mappers.EcopointMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucs.caxiaslixozero.Domain.Entities.Address;
import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
	public Address saveAddress(Address address) {
		try {
			entityManager.persist(address);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return address;
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
