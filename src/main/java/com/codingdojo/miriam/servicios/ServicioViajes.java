package com.codingdojo.miriam.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.codingdojo.miriam.modelos.Gasto;
import com.codingdojo.miriam.repositorios.RepositorioViajes;

@Service
public class ServicioViajes {
	
	//Linking Service(this) With Repository
	private final RepositorioViajes repositorio;
	
	public ServicioViajes(RepositorioViajes repo) {
		this.repositorio = repo;
	}
	
	
	//READ ALL
	public List<Gasto> get_gastos(){
		return repositorio.findAll();
	}
	
	//READ ONE
	public Gasto find_gasto(Long id) {
		Optional<Gasto> optionalGasto = repositorio.findById(id);
		if(optionalGasto.isPresent()) {
			return optionalGasto.get();
		}else {
			return null;
		}
	}
	
	//CREATE & UPDATE
	public Gasto save_gasto(Gasto gasto) {
		return repositorio.save(gasto);
	}
	
	//DELETE
	public void delete_gasto(Long id) {
		repositorio.deleteById(id);
	}
	
	
}
