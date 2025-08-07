package br.com.hcamolez.StockAlert.modules.product.dto;

import br.com.hcamolez.StockAlert.modules.product.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ProductDTO {
    private String nomeProduto;
    private String marca;
    private LocalDate dataFabricacao;
    private LocalDate dataVencimento;
    private int lote;
    private int qtde;

    public ProductDTO(ProductEntity entity){
        this.nomeProduto = entity.getNomeProduto();
        this.lote = entity.getLote();

    }

}
