package br.com.hcamolez.StockAlert.modules.market.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    //@GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nomeMercado;
    @NotBlank
    private String endereco;
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss")
    private LocalDateTime dataCadastro;

}
