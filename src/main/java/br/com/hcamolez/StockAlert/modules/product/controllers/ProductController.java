package br.com.hcamolez.StockAlert.modules.product.controllers;
import br.com.hcamolez.StockAlert.modules.product.dto.ProductDTO;
import br.com.hcamolez.StockAlert.modules.product.useCases.ServiceCreateProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ServiceCreateProduct serviceCreateProduct;


    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody ProductDTO productDTO){
        try{
            var message = this.serviceCreateProduct.execute(productDTO);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/")
    public ResponseEntity<Page<ProductDTO>> showProducts(Pageable pageable){

        Page<ProductDTO> paged = serviceCreateProduct.findAllPaged(pageable);
        return  ResponseEntity.ok().body(paged);
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
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        serviceCreateProduct.delete(id);
        return ResponseEntity.noContent().build();

    }


}
