package br.com.hcamolez.StockAlert.modules.market.repositories;

import br.com.hcamolez.StockAlert.modules.market.entities.MarketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketRepository extends JpaRepository<MarketEntity, Long> {
    Optional<MarketEntity> findByNomeMercado(String nomeMercado);
}
