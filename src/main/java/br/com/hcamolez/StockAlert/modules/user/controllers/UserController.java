package br.com.hcamolez.StockAlert.modules.user.controllers;
import br.com.hcamolez.StockAlert.modules.user.dto.UserDTO;
import br.com.hcamolez.StockAlert.modules.user.useCases.ServiceCreateUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private ServiceCreateUser serviceCreateUser;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody UserDTO UserDTO){
        try {
            var message = this.serviceCreateUser.execute(UserDTO);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Page<UserDTO>> showMarket(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction
    ){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<UserDTO> paged = serviceCreateUser.findAllPaged(pageRequest);
        return ResponseEntity.ok().body(paged);
    }

    public ResponseEntity<Object> marketById(@PathVariable long id){
        try {
            UserDTO UserDTO = serviceCreateUser.findById(id);
            return  ResponseEntity.ok().body(UserDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMarketById(@PathVariable Long id, @RequestBody UserDTO UserDTO){
        UserDTO = serviceCreateUser.updateById(id,UserDTO);
        return  ResponseEntity.ok().body(UserDTO);

    }
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        serviceCreateUser.delete(id);
        return ResponseEntity.noContent().build();
    }



}
