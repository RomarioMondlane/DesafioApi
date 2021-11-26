package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Entidades.Pais;

@RestController
public class PaisEventos {

	
	@Autowired
	private PaisRepository pr;
	
	
	
	@RequestMapping(value="/criarPais", method=RequestMethod.POST)	
	public ResponseEntity<String> CriarPais(@Valid @ModelAttribute Pais pais) throws IllegalStateException, IOException {
		
		
		if(pr.findByNome(pais.getNome())!=null ) {
			
			return new ResponseEntity<>("PAis exsitente!",HttpStatus.OK);
			
		}else {
			pr.save(pais);}
			return new ResponseEntity<>("Pais criado com sucesso!",HttpStatus.OK);
	
	}

	@RequestMapping(value="/listar", method=RequestMethod.GET)

	public List<Pais> listaClubes() {
		
	return  pr.findAll();
	
	}
	@RequestMapping(value="/listarClubes", method=RequestMethod.GET)

	public ResponseEntity<String> Atualizar(@ModelAttribute Pais pais) {
		
	Pais p=	pr.findById(pais.getIdentificador()).get();
	p.setArea(pais.getArea());
	p.setCapital(pais.getCapital());
	p.setNome(pais.getNome());
	p.setRegiao(pais.getRegiao());
	p.setSubregiao(pais.getRegiao());
	
	pr.save(p);
	
	return new ResponseEntity<>("Atualizado com sucesso!",HttpStatus.OK); 
	}
	
	
	@RequestMapping(value="/apagar", method=RequestMethod.GET)
	public ResponseEntity<String> Apagar(@RequestParam("identificador") int i ) {
		
		Pais p=pr.findByIdentificador(i);
				pr.delete(p);
				
	return new ResponseEntity<>("Apagado com sucesso!",HttpStatus.OK); 
				
	}
	
	@RequestMapping(value="/ordenar", method=RequestMethod.GET)
	public ResponseEntity<List<Pais>> Ordenar(@RequestParam("criterio") int criterio ) {
		List<Pais>  list= new ArrayList<Pais>();
		switch(criterio) {
		  case 1: list=pr.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		   
		    break;
		  case 2:list=pr.findAll(Sort.by(Sort.Direction.ASC, "capital"));
		    break;

		  case 3:list=pr.findAll(Sort.by(Sort.Direction.ASC, "regiao"));
		    break;

		  case 4:list=pr.findAll(Sort.by(Sort.Direction.ASC, "area"));
		    break;

		  case 5:list=pr.findAll(Sort.by(Sort.Direction.ASC, "subreagiao"));
		    break;
		  default:
		}
			
		
		return new ResponseEntity<>(list,HttpStatus.OK); 
		
	
	}
	
	
	
	
	
	
}


