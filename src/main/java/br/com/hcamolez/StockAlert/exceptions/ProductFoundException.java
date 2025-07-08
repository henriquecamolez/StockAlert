package br.com.hcamolez.StockAlert.exceptions;

public class ProductFoundException extends RuntimeException{
    public ProductFoundException(){
        super("Já Existe um produto com esse lote cadastrado!");
    }
}
