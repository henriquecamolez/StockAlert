package br.com.hcamolez.StockAlert.modules.alert.useCases;

import br.com.hcamolez.StockAlert.exceptions.DatabaseException;
import br.com.hcamolez.StockAlert.exceptions.AlertFoundException;
import br.com.hcamolez.StockAlert.modules.alert.dto.AlertDTO;
import br.com.hcamolez.StockAlert.modules.alert.entities.AlertEntity;
import br.com.hcamolez.StockAlert.modules.alert.mapper.MapperAlert;
import br.com.hcamolez.StockAlert.modules.alert.repositories.AlertRepository;
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
public class ServiceCreateAlert {
    @Autowired
    private AlertRepository alertRepository;
    @Autowired
    private MapperAlert MapperAlert;



    @Transactional
    public AlertEntity execute(AlertDTO alertDTO){
        AlertEntity alertEntity = new AlertEntity();
        MapperAlert.targetEntityFromDTO(alertDTO,alertEntity);
        return this.alertRepository.save(alertEntity);
    }

    @Transactional(readOnly = true)
    public Page<AlertDTO> findAllPaged(PageRequest pageRequest){
        Page<AlertEntity> pageEntity = alertRepository.findAll(pageRequest);
        return pageEntity.map(MapperAlert::toDTO);
    }

    @Transactional
    public AlertDTO updateById(Long id, AlertDTO alertDTO) {
        try{
            AlertEntity alertEntity = alertRepository.getReferenceById(id);
            MapperAlert.targetEntityFromDTO(alertDTO, alertEntity);
            alertEntity = alertRepository.save(alertEntity);
            return MapperAlert.toDTO(alertEntity);
        }catch (EntityNotFoundException e){
            throw new AlertFoundException();
        }

    }
    @Transactional
    public AlertDTO findById(long id) {
        Optional<AlertEntity> obj = alertRepository.findById(id);
        AlertEntity alertEntity = obj.orElseThrow(AlertFoundException::new);
        return MapperAlert.toDTO(alertEntity);
    }

    public void delete(Long id) {
        try{
            alertRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new AlertFoundException();

        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integridade do banco violada");
        }

    }
}
