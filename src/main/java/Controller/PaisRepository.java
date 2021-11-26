package Controller;
import org.springframework.data.jpa.repository.JpaRepository;
import Entidades.*;

import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

	Pais findByNome(String nome);
	Pais findByIdentificador(int id);
	
}
