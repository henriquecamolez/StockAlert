package br.com.hcamolez.StockAlert.modules.product.useCases;


import br.com.hcamolez.StockAlert.exceptions.DatabaseException;
import br.com.hcamolez.StockAlert.exceptions.ProductFoundException;
import br.com.hcamolez.StockAlert.modules.product.mapper.MapperProduct;
import br.com.hcamolez.StockAlert.modules.product.dto.ProductDTO;
import br.com.hcamolez.StockAlert.modules.product.entities.ProductEntity;
import br.com.hcamolez.StockAlert.modules.product.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;


@Service
public class ServiceCreateProduct {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MapperProduct mapperProduct;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(PageRequest pageRequest){
        Page<ProductEntity> pageEntity = productRepository.findAll(pageRequest);
        return pageEntity.map(mapperProduct::toDto);

    }

    @Transactional
    public ProductEntity execute(@Valid ProductDTO productDTO){

        ProductEntity productEntity = new ProductEntity();
        mapperProduct.updateEntityFromDto(productDTO, productEntity);
       return  productEntity = productRepository.save(productEntity);

    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<ProductEntity> obj = productRepository.findById(id);
        ProductEntity productEntity = obj.orElseThrow(ProductFoundException::new);
        return mapperProduct.toDto(productEntity);

    }

    @Transactional
    public ProductDTO updatedById(Long id, ProductDTO productDTO) {
        try {
            ProductEntity productEntity = productRepository.getReferenceById(id);
            mapperProduct.updateEntityFromDto(productDTO, productEntity);
            productEntity = productRepository.save(productEntity);
            return mapperProduct.toDto(productEntity);
        } catch (EntityNotFoundException e) {
            throw new ProductFoundException();
        }
    }

    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw  new ProductFoundException();
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integridade do banco violada");
        }

    }
}
