package br.com.hcamolez.StockAlert.modules.product.useCases;


import br.com.hcamolez.StockAlert.exceptions.ProductFoundException;
import br.com.hcamolez.StockAlert.modules.product.entities.ProductEntity;
import br.com.hcamolez.StockAlert.modules.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCreateProduct {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> findAll(){
        return productRepository.findAll();
    }

    public ProductEntity execute(ProductEntity productEntity){
        this.productRepository.findByLote(productEntity.getLote())
                .ifPresent(product -> {
                    throw new ProductFoundException();
                });
        return this.productRepository.save(productEntity);
    }

}
