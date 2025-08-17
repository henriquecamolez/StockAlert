package br.com.hcamolez.StockAlert.modules.user.repositories;

import br.com.hcamolez.StockAlert.modules.user.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByLogin(String login);

}
