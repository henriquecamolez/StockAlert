package br.com.hcamolez.StockAlert.modules.market.useCases;

import br.com.hcamolez.StockAlert.exceptions.MarketFoundException;
import br.com.hcamolez.StockAlert.modules.market.entities.MarketEntity;
import br.com.hcamolez.StockAlert.modules.market.repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCreateMarket {
    @Autowired
    private MarketRepository marketRepository;

    public MarketEntity execute(MarketEntity marketEntity){
        this.marketRepository.findByNomeMercado(marketEntity.getNomeMercado())
                .ifPresent(market ->{
                    throw new MarketFoundException();
                } );
        return this.marketRepository.save(marketEntity);
    }

}
