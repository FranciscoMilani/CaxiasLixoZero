package br.ucs.caxiaslixozero.Services;

import br.ucs.caxiaslixozero.Domain.Dtos.ResidueDto;
import br.ucs.caxiaslixozero.Domain.Entities.Residue;
import br.ucs.caxiaslixozero.Domain.Repositories.ResidueRepository;
import br.ucs.caxiaslixozero.Infrastructure.Mappers.ResidueMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
}
