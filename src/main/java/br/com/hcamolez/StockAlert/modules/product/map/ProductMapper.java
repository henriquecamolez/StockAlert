package br.com.hcamolez.StockAlert.modules.product.map;

import br.com.hcamolez.StockAlert.modules.product.dto.ProductDTO;
import br.com.hcamolez.StockAlert.modules.product.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;




@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ProductDTO productDTO, @MappingTarget ProductEntity productEntity);
    ProductDTO toDto(ProductEntity productEntity);
    ProductEntity toEntity(ProductDTO dto);
}
