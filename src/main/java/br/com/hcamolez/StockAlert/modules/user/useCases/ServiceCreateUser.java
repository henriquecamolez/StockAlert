package br.com.hcamolez.StockAlert.modules.user.useCases;



import br.com.hcamolez.StockAlert.exceptions.UserFoundException;
import br.com.hcamolez.StockAlert.modules.user.entities.UserEntity;
import br.com.hcamolez.StockAlert.modules.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceCreateUser {
    private UserRepository userRepository;

    public UserEntity execute (UserEntity userEntity) {
        this.userRepository.findByNomeOrEmail(userEntity.getNomeUsuario(), userEntity.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });
    return this.userRepository.save(userEntity);
    }
}
