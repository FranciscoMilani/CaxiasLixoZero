package br.ucs.caxiaslixozero.Infrastructure.Mappers;

import br.ucs.caxiaslixozero.Domain.Dtos.EcopointAddressDto;
import br.ucs.caxiaslixozero.Domain.Dtos.EcopointMapDto;
import br.ucs.caxiaslixozero.Domain.Dtos.ResidueDto;
import br.ucs.caxiaslixozero.Domain.Entities.Address;
import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;
import br.ucs.caxiaslixozero.Domain.Entities.Residue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface EcopointMapper {
    public static final EcopointMapper INSTANCE = Mappers.getMapper(EcopointMapper.class);

    @Mapping(target = "title", source = "responsibleName")
    @Mapping(target = "phone", source = "responsiblePhone")
    @Mapping(target = "address", source = "ecopointAddress", qualifiedByName = "EcopointAddressDto")
    @Mapping(target = "residues", source = "residues", qualifiedByName = "ResidueDtos")
    EcopointMapDto toEcopointMapDto(Ecopoint ecopoint);

    // Mapeando DTO de endereço
    @Named("EcopointAddressDto")
    default EcopointAddressDto toEcopointAddressDto(Address address) {
        return AddressMapper.INSTANCE.toEcopointAddressDto(address);
    }

    // Mapeando lista de DTOs de resíduos
    @Named("ResidueDtos")
    default List<ResidueDto> toResidueDtos(List<Residue> residues) {
        return residues.stream()
                .map(ResidueMapper.INSTANCE::toResidueDto)
                .collect(Collectors.toList());
    }
}
