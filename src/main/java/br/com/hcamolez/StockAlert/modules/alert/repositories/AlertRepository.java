package br.com.hcamolez.StockAlert.modules.alert.repositories;

import br.com.hcamolez.StockAlert.modules.alert.entities.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AlertRepository extends JpaRepository<AlertEntity,Long> {

}
