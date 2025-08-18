package br.com.hcamolez.StockAlert.modules.alert.dto;
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
}
