package br.com.hcamolez.StockAlert.modules.product.useCases;


import br.com.hcamolez.StockAlert.exceptions.ProductFoundException;
import br.com.hcamolez.StockAlert.modules.product.dto.ProductDTO;
import br.com.hcamolez.StockAlert.modules.product.entities.ProductEntity;
import br.com.hcamolez.StockAlert.modules.product.map.ProductMapper;
import br.com.hcamolez.StockAlert.modules.product.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceCreateProduct {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<ProductEntity> list = productRepository.findAll();


        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }
    @Transactional
    public ProductEntity execute(@Valid ProductEntity productEntity){
        this.productRepository.findByLote(productEntity.getLote())
                .ifPresent(prd -> {
                    throw new ProductFoundException();
                });
        return this.productRepository.save(productEntity);
    }
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<ProductEntity> obj = productRepository.findById(id);
        ProductEntity productEntity = obj.orElseThrow(ProductFoundException::new);
        return new ProductDTO(productEntity);

    }
    @Transactional
    public ProductDTO updatedById(Long id, ProductDTO productDTO) {
        try {
            ProductEntity productEntity = productRepository.getReferenceById(id);
            productMapper.updateEntityFromDto(productDTO, productEntity);
            productEntity = productRepository.save(productEntity);
            return productMapper.toDto(productEntity);
        } catch (EntityNotFoundException e) {
            throw new ProductFoundException();
        }
    }
}
