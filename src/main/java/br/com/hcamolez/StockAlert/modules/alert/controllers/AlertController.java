package br.com.hcamolez.StockAlert.modules.alert.controllers;

import br.com.hcamolez.StockAlert.modules.alert.dto.AlertDTO;
import br.com.hcamolez.StockAlert.modules.alert.useCases.ServiceCreateAlert;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/Alerts")
    public class AlertController {
        @Autowired
        private ServiceCreateAlert serviceCreateAlert;

        @PostMapping("/")
        public ResponseEntity<Object> create(@Valid @RequestBody AlertDTO alertDTO){
            try {
                var message = this.serviceCreateAlert.execute(alertDTO);
                return ResponseEntity.ok(message);
            } catch (Exception e) {
                return  ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/")
        public ResponseEntity<Page<AlertDTO>> showAlert(
                @RequestParam(value = "page", defaultValue = "0") Integer page,
                @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
                @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
                @RequestParam(value = "direction", defaultValue = "DESC") String direction
        ){
            PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction), orderBy);
            Page<AlertDTO> paged = serviceCreateAlert.findAllPaged(pageRequest);
            return ResponseEntity.ok().body(paged);
        }

        public ResponseEntity<Object> alertById(@PathVariable long id){
            try {
                AlertDTO alertDTO = serviceCreateAlert.findById(id);
                return  ResponseEntity.ok().body(alertDTO);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }

        }

        @PutMapping("/{id}")
        public ResponseEntity<Object> updateAlertById(@PathVariable Long id, @RequestBody AlertDTO alertDTO){
            alertDTO = serviceCreateAlert.updateById(id,alertDTO);
            return  ResponseEntity.ok().body(alertDTO);

        }
        public ResponseEntity<Void> deleteById(@PathVariable Long id){
            serviceCreateAlert.delete(id);
            return ResponseEntity.noContent().build();
        }



    }


