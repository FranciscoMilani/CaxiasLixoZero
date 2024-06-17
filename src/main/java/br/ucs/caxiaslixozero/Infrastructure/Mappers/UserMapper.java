package br.ucs.caxiaslixozero.Infrastructure.Mappers;

import br.ucs.caxiaslixozero.Domain.Dtos.LoginDto;
import br.ucs.caxiaslixozero.Domain.Dtos.RegisterDto;
import br.ucs.caxiaslixozero.Domain.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    LoginDto toLoginDto(User user);
    RegisterDto toRegisterDto(User user);
    User toUserFromLoginDto(LoginDto loginDto);
    User toUserFromRegisterDto(RegisterDto registerDto);
}