package br.com.hcamolez.StockAlert.modules.product.repositories;

import br.com.hcamolez.StockAlert.modules.product.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByLote(int lote);

}
