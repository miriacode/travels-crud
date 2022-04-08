package com.codingdojo.miriam.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.miriam.modelos.Gasto;

@Repository
public interface RepositorioViajes extends CrudRepository<Gasto, Long>{
	
	//READ ALL
	List<Gasto> findAll();
	
	//READ ONE
	List<Gasto> findById(long id);
	
	//SAVE & UPDATE
	Gasto save(Gasto gasto);
	
	//DELETE
	void deleteById(Long id);
}
