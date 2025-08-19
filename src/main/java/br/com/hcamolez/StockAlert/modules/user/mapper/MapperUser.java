package br.com.hcamolez.StockAlert.modules.user.mapper;

import br.com.hcamolez.StockAlert.modules.user.dto.UserDTO;
import br.com.hcamolez.StockAlert.modules.user.dto.UserResponseDTO;
import br.com.hcamolez.StockAlert.modules.user.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperUser {
    @Mapping(target ="id", ignore = true)
    void  targetEntityFromDTO(UserDTO userDTO,@MappingTarget UserEntity userEntity);
    UserDTO toDTO(UserEntity userEntity);
    UserEntity toEntity(UserDTO userDTO);
}
