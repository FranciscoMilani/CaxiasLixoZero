package br.ucs.caxiaslixozero.Infrastructure.Mappers;

import br.ucs.caxiaslixozero.Domain.Dtos.EcopointAddressDto;
import br.ucs.caxiaslixozero.Domain.Entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    public static final AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "street", source = "road")
    EcopointAddressDto toEcopointAddressDto(Address address);
}