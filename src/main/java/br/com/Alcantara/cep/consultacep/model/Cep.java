package br.com.Alcantara.cep.consultacep.model;


import br.com.Alcantara.cep.consultacep.model.dto.DadosCadastroCepDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cep")
@Entity(name = "Cep")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Cep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public Cep(DadosCadastroCepDTO dados){
        this.cep = dados.cep().replace("-","");
        this.logradouro = dados.logradouro();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();

        this.localidade = dados.localidade();
        this.uf = dados.uf();
        this.ibge = dados.ibge();
        this.gia = dados.gia();
        this.ddd = dados.ddd();
        this.siafi = dados.siafi();
    }



}
