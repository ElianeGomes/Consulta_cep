package br.com.Alcantara.cep.consultacep.controller;

import br.com.Alcantara.cep.consultacep.model.dto.DadosCadastroCepDTO;
import br.com.Alcantara.cep.consultacep.model.dto.DadosListaCepDTO;
import br.com.Alcantara.cep.consultacep.model.Cep;
import br.com.Alcantara.cep.consultacep.repository.CepRepository;
import br.com.Alcantara.cep.consultacep.service.CepService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consulta-cep")
public class CepController {
    @Autowired
    private CepService cepService;
    @GetMapping("{cep}")
    public DadosCadastroCepDTO consultaCep(@PathVariable("cep") String cep){
        return cepService.consulta(cep);
    }
}
