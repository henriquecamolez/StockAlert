package br.com.hcamolez.StockAlert.exceptions;

public class MarketFoundException extends  RuntimeException{
    public MarketFoundException(){
        super("Já Existe um mercado com esse nome cadastrado.");
    }
}
