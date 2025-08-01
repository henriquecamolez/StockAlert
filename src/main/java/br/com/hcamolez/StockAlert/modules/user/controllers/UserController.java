package br.com.hcamolez.StockAlert.modules.user.controllers;

import br.com.hcamolez.StockAlert.modules.user.entities.UserEntity;
import br.com.hcamolez.StockAlert.modules.user.useCases.ServiceCreateUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    private ServiceCreateUser serviceCreateUser;

    public ResponseEntity<Object> execute(@Valid @RequestBody UserEntity userEntity){
        try {
            var message = this.serviceCreateUser.execute(userEntity);
            return ResponseEntity.ok(message);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
