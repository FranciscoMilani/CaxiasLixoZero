package br.ucs.caxiaslixozero.Infrastructure.Mappers;

import br.ucs.caxiaslixozero.Domain.Dtos.ResidueDto;
import br.ucs.caxiaslixozero.Domain.Entities.Residue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResidueMapper {
    public static final ResidueMapper INSTANCE = Mappers.getMapper(ResidueMapper.class);

    ResidueDto toResidueDto(Residue residue);
}
