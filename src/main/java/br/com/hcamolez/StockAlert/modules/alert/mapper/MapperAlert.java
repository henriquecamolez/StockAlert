package br.com.hcamolez.StockAlert.modules.alert.mapper;

import br.com.hcamolez.StockAlert.modules.alert.dto.AlertDTO;
import br.com.hcamolez.StockAlert.modules.alert.entities.AlertEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperAlert {

    @Mapping(target = "id", ignore = true)
    void targetEntityFromDTO(AlertDTO alertDTO, @MappingTarget AlertEntity alert);
    AlertDTO toDTO(AlertEntity alertEntity);
    AlertEntity toEntity(AlertDTO alertDTO);
}
