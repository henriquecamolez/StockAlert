package br.com.hcamolez.StockAlert.modules.product.repositories;

import br.com.hcamolez.StockAlert.modules.product.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByLote(int lote);

}
