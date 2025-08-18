package br.com.hcamolez.StockAlert.modules.user.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity(name = "usuario")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Pattern(regexp = "\\S+", message = "O campo [NomeUsuario] não deve conter espaços")
    private String login;
    private String nome;
    @NotBlank
    @Email(message = "Digite um endereço de email valido!")
    private String email;
    @Length(min = 8, max = 15)
    @NotBlank
    private String senha;
}
