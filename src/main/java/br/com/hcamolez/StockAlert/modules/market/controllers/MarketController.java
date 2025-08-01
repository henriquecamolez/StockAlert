package br.com.hcamolez.StockAlert.modules.market.controllers;

import br.com.hcamolez.StockAlert.modules.market.entities.MarketEntity;
import br.com.hcamolez.StockAlert.modules.market.repositories.MarketRepository;
import br.com.hcamolez.StockAlert.modules.market.useCases.ServiceCreateMarket;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/markets")
public class MarketController {

    @Autowired
    private ServiceCreateMarket serviceCreateMarket;
    @Autowired
    private MarketRepository marketRepository;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody MarketEntity marketEntity){
        try {
            var message = this.serviceCreateMarket.execute(marketEntity);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/")
    public List<MarketEntity> showMarket(){
        return marketRepository.findAll();
    }

}
