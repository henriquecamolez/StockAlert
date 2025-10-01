package br.com.hcamolez.StockAlert.modules.market.useCases;
import br.com.hcamolez.StockAlert.exceptions.DatabaseException;
import br.com.hcamolez.StockAlert.exceptions.MarketFoundException;
import br.com.hcamolez.StockAlert.modules.market.mapper.MapperMarket;
import br.com.hcamolez.StockAlert.modules.market.dto.MarketDTO;
import br.com.hcamolez.StockAlert.modules.market.entities.MarketEntity;
import br.com.hcamolez.StockAlert.modules.market.repositories.MarketRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ServiceCreateMarket {
    @Autowired
    private MarketRepository marketRepository;
    @Autowired
    private MapperMarket mapperMarket;



    @Transactional
    public MarketEntity execute(MarketDTO marketDTO){
        MarketEntity marketEntity = new MarketEntity();
        this.marketRepository.findByNomeMercado(marketDTO.getNomeMercado())
                .ifPresent(market ->{
                    throw new MarketFoundException();
                } );
        mapperMarket.targetEntityFromDto(marketDTO,marketEntity);
        return this.marketRepository.save(marketEntity);
    }

    @Transactional(readOnly = true)
    public Page<MarketDTO> findAllPaged(Pageable pageable){
        Page<MarketEntity> pageEntity = marketRepository.findAll(pageable);
        return pageEntity.map(mapperMarket::toDTO);
    }

    @Transactional
    public MarketDTO updateById(Long id, MarketDTO marketDTO) {
        try{
            MarketEntity marketEntity = marketRepository.getReferenceById(id);
            mapperMarket.targetEntityFromDto(marketDTO, marketEntity);
            marketEntity = marketRepository.save(marketEntity);
            return mapperMarket.toDTO(marketEntity);
        }catch (EntityNotFoundException e){
            throw new MarketFoundException();
        }

    }
    @Transactional
    public MarketDTO findById(long id) {
        Optional<MarketEntity> obj = marketRepository.findById(id);
        MarketEntity marketEntity = obj.orElseThrow(MarketFoundException::new);
        return mapperMarket.toDTO(marketEntity);
    }

    public void delete(Long id) {
        try{
            marketRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new MarketFoundException();

        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integridade do banco violada");
        }

    }
}
