package br.com.hcamolez.StockAlert.modules.user.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO{
    @Id
    private Long id;
    private String nome;
    private String login;
    private String email;
    private String senha;
}
