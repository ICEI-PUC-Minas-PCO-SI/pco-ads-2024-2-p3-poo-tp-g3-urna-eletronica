package urna_eletronica.urna.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import urna_eletronica.urna.VO.PartidoVo;

@Data
@Entity
public class Partido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String sigla;
  
  @JsonManagedReference
  @OneToMany(mappedBy =  "partido")
  private List<Candidato> candidatos;

  public Partido(){}

  public Partido(String _nome, String _sigla, Long _id){
    this.nome = _nome;
    this.sigla = _sigla;
    this.id = _id;
  }

  public PartidoVo toVo(){
    PartidoVo vo = new PartidoVo();
    vo.setId(getId());
    vo.setNome(getNome());
    vo.setSigla(getSigla());
    vo.setCandidatoVo(getCandidatos().stream().map(Candidato::toSmall).toList());

    return vo;
  }
  public PartidoVo toSmall(){
    PartidoVo vo = new PartidoVo();
    vo.setId(getId());
    vo.setNome(getNome());
    vo.setSigla(getSigla());
    return vo;
  }

 
}
