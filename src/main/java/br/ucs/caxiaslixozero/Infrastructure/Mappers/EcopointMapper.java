package br.ucs.caxiaslixozero.Infrastructure.Mappers;

import br.ucs.caxiaslixozero.Domain.Dtos.EcopointMapDto;
import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EcopointMapper {
    public static final EcopointMapper INSTANCE = Mappers.getMapper(EcopointMapper.class);

    EcopointMapDto toEcopointMapDto(Ecopoint ecopoint);
}
