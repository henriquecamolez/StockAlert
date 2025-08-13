package br.com.hcamolez.StockAlert.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseErrorDTO {
    private Instant timestamp;
    private int Status;
    private String Error;
    private  String message;
    private String path;

}
