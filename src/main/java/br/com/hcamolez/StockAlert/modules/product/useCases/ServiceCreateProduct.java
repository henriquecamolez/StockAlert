package br.com.hcamolez.StockAlert.modules.product.useCases;


import br.com.hcamolez.StockAlert.exceptions.ProductFoundException;
import br.com.hcamolez.StockAlert.modules.product.dto.ProductDTO;
import br.com.hcamolez.StockAlert.modules.product.entities.ProductEntity;
import br.com.hcamolez.StockAlert.modules.product.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceCreateProduct {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<ProductEntity> list = productRepository.findAll();


        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public ProductEntity execute(@Valid ProductEntity productEntity){
        this.productRepository.findByLote(productEntity.getLote())
                .ifPresent(prd -> {
                    throw new ProductFoundException();
                });
        return this.productRepository.save(productEntity);
    }

}
