package Jugo.backend.mapper;

import Jugo.backend.dto.UserDTO;
import Jugo.backend.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User entity);
    User toEntity(UserDTO dto);
}
