package br.com.hcamolez.StockAlert.modules.alert.entities;

import br.com.hcamolez.StockAlert.modules.product.entities.ProductEntity;
import br.com.hcamolez.StockAlert.modules.user.entities.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
@Entity(name = "alert")
@Data
public class AlertEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private int dias_antecedencia;
    @CreationTimestamp
    private LocalDate dataEmissao ;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UserEntity usuario;


    @ManyToOne
    @JoinColumn(name = "idProduto", nullable = false)
    private ProductEntity produto;
}
