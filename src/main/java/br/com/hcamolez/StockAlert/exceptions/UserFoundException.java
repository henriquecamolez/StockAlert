package br.com.hcamolez.StockAlert.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException()
    {
        super("Já Existe um usuário com esse nome cadastrado!");

    }
}
