package br.com.hcamolez.StockAlert.modules.product.mapper;

import br.com.hcamolez.StockAlert.modules.market.mapper.MapperMarket;
import br.com.hcamolez.StockAlert.modules.product.dto.ProductDTO;
import br.com.hcamolez.StockAlert.modules.product.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;




@Mapper(componentModel = "spring", uses = MapperMarket.class)
public interface MapperProduct {
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ProductDTO productDTO, @MappingTarget ProductEntity productEntity);
    ProductDTO toDto(ProductEntity productEntity);
    ProductEntity toEntity(ProductDTO dto);
}
