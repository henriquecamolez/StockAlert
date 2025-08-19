package br.com.hcamolez.StockAlert.modules.alert.dto;
import br.com.hcamolez.StockAlert.modules.product.dto.ProductDTO;
import br.com.hcamolez.StockAlert.modules.product.entities.ProductEntity;
import br.com.hcamolez.StockAlert.modules.user.dto.UserDTO;
import br.com.hcamolez.StockAlert.modules.user.entities.UserEntity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertDTO {
    @Id
    private  Long id;
    private int dias_antecedencia;
    private LocalDate dataEmissao ;
    private ProductDTO produto;
    private UserDTO usuario;

}
