package com.fabriciobaixo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabriciobaixo.cursomc.domain.Categoria;
import com.fabriciobaixo.cursomc.repositories.CategoriaRepository;
import com.fabriciobaixo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	/*public Categoria update(Categoria obj) {
		Categoria newObj = findById(obj.getId()); 
		updateData(newObj, obj);
		return repo.save(newObj);
		}
	
	private void updateData(Categoria newObj, Categoria obj) {		
		newObj.setNome(obj.getNome());
		newObj.setProdutos(obj.getProdutos());
	}*/
}
