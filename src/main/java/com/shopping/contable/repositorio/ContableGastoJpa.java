package com.shopping.contable.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopping.contable.modelo.ContableLibroDiario;


public interface ContableGastoJpa extends JpaRepository<ContableLibroDiario, String>{
	
	
	@Query(value="SELECT g.* FROM contable_libro_diario g JOIN contable_tipo_gastos t ON (g.idtipoie=t.id) WHERE  MONTH(fecha) = :mes AND YEAR(fecha) = :anio AND t.gasto ='COSTO DIRECTO'", nativeQuery=true)
	List<ContableLibroDiario> findCosotosDirectos(int mes, int anio);

}
