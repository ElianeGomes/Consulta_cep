package br.com.Alcantara.cep.consultacep.model.dto;

import br.com.Alcantara.cep.consultacep.model.Cep;

public record DadosListaCepDTO(
        Long id,
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        String ibge,
        String gia,
        String ddd,
        String siafi) {


    //Contrutor para imprimir lista de ceps
    public DadosListaCepDTO(Cep cep){
        this(cep.getId(),cep.getCep(),cep.getLogradouro(),
        cep.getComplemento(),cep.getBairro(),cep.getLocalidade(),
        cep.getUf(),cep.getIbge(),cep.getGia(),cep.getDdd(), cep.getSiafi());
    }


}
