package br.com.Alcantara.cep.consultacep.repository;

import br.com.Alcantara.cep.consultacep.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepRepository extends JpaRepository<Cep,Long> {


    //acessa banco de dados e busca todos os regitros apartir do cep
    Cep findByCep(String cep);

    //List<Cep> findAll();

}
