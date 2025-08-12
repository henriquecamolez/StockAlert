package br.com.hcamolez.StockAlert.modules.product.controllers;


import br.com.hcamolez.StockAlert.modules.product.dto.ProductDTO;
import br.com.hcamolez.StockAlert.modules.product.entities.ProductEntity;

import br.com.hcamolez.StockAlert.modules.product.useCases.ServiceCreateProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ServiceCreateProduct serviceCreateProduct;


    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody ProductEntity productEntity){
        try{
            var message = this.serviceCreateProduct.execute(productEntity);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/")
    public ResponseEntity<Object> showProducts(){
        try{
        var showProducts = serviceCreateProduct.findAll();
        return ResponseEntity.ok().body(showProducts);} catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        try {
            ProductDTO productDTO = serviceCreateProduct.findById(id);
            return ResponseEntity.ok().body(productDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatedById(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        productDTO = serviceCreateProduct.updatedById(id,productDTO);
        return ResponseEntity.ok().body(productDTO);
    }


}
