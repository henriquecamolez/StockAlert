package br.com.hcamolez.StockAlert.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException()
    {
        super("Usuário Já Cadastrado!");
    }
}
