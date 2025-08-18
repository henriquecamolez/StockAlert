package br.com.hcamolez.StockAlert.exceptions;

public class AlertFoundException extends RuntimeException {
    public AlertFoundException() {
        super("Ja existe um alerta como esse.");
    }
}
