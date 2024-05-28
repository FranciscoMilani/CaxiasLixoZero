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

import java.util.Date;
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

	public List<Ecopoint> getAllEcopoints() {
		return repository.findAll();
	}

	public Ecopoint findEcopointById(Long id) {
		Optional<Ecopoint> ecopointOptional = repository.findById(id);
		return ecopointOptional.orElse(null);
	}

	public List<EcopointMapDto> getAllToMapEcopoint() {
		return repository.findAll().stream().map(EcopointMapper.INSTANCE::toEcopointMapDto).toList();
	}

//	public List<EcopointMapDto> getMapEcopointsFilteredByResidue(String residueType) {
//		return repository.findFirst10ByResidueTypeIn(List.of(residueType)).stream()
//				.map(EcopointMapper.INSTANCE::toEcopointMapDto).toList();
//	}

	public List<EcopointMapDto> getMapEcopointFilteredByNeighborhood(String neighborhood) {
		return repository.findByNeighborhoodName(neighborhood).stream().map(EcopointMapper.INSTANCE::toEcopointMapDto)
				.toList();
	}

	public List<Ecopoint> getEcopointsByCompanyName(String companyName, Boolean isApproved) {
		return repository.findByCompanyName(companyName, isApproved);
	}

	public List<Ecopoint> getEcopointsByResponsibleName(String responsibleName,  Boolean isApproved) {
		return repository.findByResponsibleName(responsibleName, isApproved);
	}

	public List<Ecopoint> getEcopointsBySocialNetwork(String socialNetwork,  Boolean isApproved) {
		return repository.findBySocialNetwork(socialNetwork, isApproved);
	}
	
	public List<Ecopoint> getEcopointsBySolicitationDate(Date solicitationDate,  Boolean isApproved) {
		return repository.findBySolicitationDate(solicitationDate, isApproved);
	}
	
	public List<Ecopoint> getEcopointsUnderAnalysis(Boolean isApproved) {
		return repository.findByStatus(isApproved);
	}
}
