package br.ucs.caxiaslixozero.Infrastructure.Mappers;

import br.ucs.caxiaslixozero.Domain.Dtos.EcopointAddressDto;
import br.ucs.caxiaslixozero.Domain.Dtos.EcopointMapDto;
import br.ucs.caxiaslixozero.Domain.Entities.Address;
import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EcopointMapper {
    public static final EcopointMapper INSTANCE = Mappers.getMapper(EcopointMapper.class);

    @Mapping(target = "title", source = "responsibleName")
    @Mapping(target = "phone", source = "responsiblePhone")
    @Mapping(target = "address", source = "ecopointAddress", qualifiedByName = "EcopointAddressDto")
    EcopointMapDto toEcopointMapDto(Ecopoint ecopoint);

    @Named("EcopointAddressDto")
    default EcopointAddressDto toEcopointAddressDto(Address address) {
        return AddressMapper.INSTANCE.toEcopointAddressDto(address);
    }
}
