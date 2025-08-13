package br.com.hcamolez.StockAlert.exceptions;

public class DatabaseException extends  RuntimeException {
    public  DatabaseException(String msg){
        super(msg);
    }
}
