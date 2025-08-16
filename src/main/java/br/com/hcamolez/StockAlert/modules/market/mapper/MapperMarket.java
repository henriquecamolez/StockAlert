package br.com.hcamolez.StockAlert.modules.market.mapper;

import br.com.hcamolez.StockAlert.modules.market.dto.MarketDTO;
import br.com.hcamolez.StockAlert.modules.market.entities.MarketEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface MapperMarket {

    @Mapping(target = "id", ignore = true)
    void targetEntityFromDto(MarketDTO marketDTO, @MappingTarget MarketEntity marketEntity);
    MarketDTO toDTO(MarketEntity marketEntity);
    MarketEntity toEntity(MarketDTO marketDTO);
    List<MarketDTO> toDTOList(Set<MarketEntity> entities);
}
