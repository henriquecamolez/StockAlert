package br.com.hcamolez.StockAlert.modules.market.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity(name="market")
public class MarketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "market_seq")
    @SequenceGenerator(name = "market_seq", sequenceName = "MARKET_SEQ", allocationSize = 1)
    private Long id;
    @NotBlank
    private String nomeMercado;
    @NotBlank
    private String endereco;
    @CreationTimestamp
    private LocalDateTime dataCadastro;

}
