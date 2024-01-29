package br.com.Alcantara.cep.consultacep.service;

import br.com.Alcantara.cep.consultacep.model.Cep;
import br.com.Alcantara.cep.consultacep.model.dto.DadosCadastroCepDTO;
import br.com.Alcantara.cep.consultacep.repository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    @Autowired
    private CepRepository repository;


    public DadosCadastroCepDTO consulta(String cep){
       Cep cepConsultado = repository.findByCep(cep); // consulta cep no banco

        if(cepConsultado == null){// se não achar, procura cep na api e salva no banco de dados
            return  consultaCepNoViaCep(cep);
        }else { // caso cep estaja cadastrado no banco, trás as informações do banco
            return new DadosCadastroCepDTO(cepConsultado);

        }

    }

    public DadosCadastroCepDTO consultaCepNoViaCep(String cep){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DadosCadastroCepDTO> resp =
                restTemplate.getForEntity(
                        String.format("https://viacep.com.br/ws/%s/json",cep), DadosCadastroCepDTO.class);
        DadosCadastroCepDTO dadosCadastroCepDTO = resp.getBody();

        cadastrar(dadosCadastroCepDTO);

        return resp.getBody();
    }

    public void cadastrar(DadosCadastroCepDTO dados){
        repository.save(new Cep(dados));
    }

    public DadosCadastroCepDTO consultCepNoBanco(String cep){
        Cep cepConsultado = repository.findByCep(cep);
        return new DadosCadastroCepDTO(cepConsultado);
    }

}
