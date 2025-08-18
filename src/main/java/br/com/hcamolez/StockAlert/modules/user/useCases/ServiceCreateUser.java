package br.com.hcamolez.StockAlert.modules.user.useCases;

<<<<<<< HEAD


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
=======
import br.com.hcamolez.StockAlert.exceptions.DatabaseException;
import br.com.hcamolez.StockAlert.exceptions.UserFoundException;
import br.com.hcamolez.StockAlert.modules.user.mapper.MapperUser;
import br.com.hcamolez.StockAlert.modules.user.repositories.UserRepository;
import br.com.hcamolez.StockAlert.modules.user.dto.UserDTO;
import br.com.hcamolez.StockAlert.modules.user.entities.UserEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ServiceCreateUser {
    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private MapperUser MapperUser;



    @Transactional
    public UserEntity execute(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        this.UserRepository.findByLogin(userDTO.getLogin())
                .ifPresent(user ->{
                    throw new UserFoundException();
                } );
        MapperUser.targetEntityFromDTO(userDTO,userEntity);
        return this.UserRepository.save(userEntity);
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> findAllPaged(PageRequest pageRequest){
        Page<UserEntity> pageEntity = UserRepository.findAll(pageRequest);
        return pageEntity.map(MapperUser::toDTO);
    }

    @Transactional
    public UserDTO updateById(Long id, UserDTO UserDTO) {
        try{
            UserEntity userEntity = UserRepository.getReferenceById(id);
            MapperUser.targetEntityFromDTO(UserDTO, userEntity);
            userEntity = UserRepository.save(userEntity);
            return MapperUser.toDTO(userEntity);
        }catch (EntityNotFoundException e){
            throw new UserFoundException();
        }

    }
    @Transactional
    public UserDTO findById(long id) {
        Optional<UserEntity> obj = UserRepository.findById(id);
        UserEntity userEntity = obj.orElseThrow(UserFoundException::new);
        return MapperUser.toDTO(userEntity);
    }

    public void delete(Long id) {
        try{
            UserRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new UserFoundException();

        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integridade do banco violada");
        }

>>>>>>> master
    }
}
