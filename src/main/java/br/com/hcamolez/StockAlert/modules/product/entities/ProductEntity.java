package br.com.hcamolez.StockAlert.modules.product.entities;


import br.com.hcamolez.StockAlert.modules.market.entities.MarketEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity(name ="product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
    private Long id;
    @NotBlank
    private String nomeProduto;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataFabricacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento;
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    private LocalDateTime dataCadastro;
    private int lote;
    private int qtde;
    @ManyToMany
    @JoinTable(
            name = "produtoMercado",
            joinColumns = @JoinColumn(name = "idProduto"),
            inverseJoinColumns = @JoinColumn(name = "idMercado")
    )
    private Set<MarketEntity> mercado = new HashSet<>();

}
