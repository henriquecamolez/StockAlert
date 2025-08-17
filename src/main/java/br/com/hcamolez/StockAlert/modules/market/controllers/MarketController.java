package br.com.hcamolez.StockAlert.modules.market.controllers;
import br.com.hcamolez.StockAlert.modules.market.dto.MarketDTO;
import br.com.hcamolez.StockAlert.modules.market.repositories.MarketRepository;
import br.com.hcamolez.StockAlert.modules.market.useCases.ServiceCreateMarket;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/markets")
public class MarketController {

    @Autowired
    private ServiceCreateMarket serviceCreateMarket;
    @Autowired
    private MarketRepository marketRepository;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody MarketDTO marketDTO){
        try {
            var message = this.serviceCreateMarket.execute(marketDTO);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Page<MarketDTO>> showMarket(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction
    ){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<MarketDTO> paged = serviceCreateMarket.findAllPaged(pageRequest);
        return ResponseEntity.ok().body(paged);
    }

    public ResponseEntity<Object> marketById(@PathVariable long id){
        try {
           MarketDTO marketDTO = serviceCreateMarket.findById(id);
            return  ResponseEntity.ok().body(marketDTO);
        } catch (Exception e) {
           return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMarketById(@PathVariable Long id, @RequestBody MarketDTO marketDTO){
        marketDTO = serviceCreateMarket.updateById(id,marketDTO);
        return  ResponseEntity.ok().body(marketDTO);

    }
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        serviceCreateMarket.delete(id);
        return ResponseEntity.noContent().build();
    }


}
