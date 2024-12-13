package urna_eletronica.urna.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import urna_eletronica.urna.VO.CandidatoVo;

@Data
@Entity
@DiscriminatorValue("Candidato")
public class Candidato extends Usuario {
  
  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "partido_id")
  private Partido partido;

  String cargo;

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "pleito_id")
  private Pleito pleito;
  private Integer codigo;

  public Candidato(Long _id){
    this.setId(_id);
  }

  Candidato(String _nome, String _email, String _senha, String _cpf, Partido _partido, String _cargo, Integer idade)
  {
    super(_nome, _email, _senha, _cpf, idade );
    this.cargo = _cargo;
    this.partido = _partido;
  }
  public Candidato(){
    super();
  }

  public CandidatoVo toVo(){
    CandidatoVo vo = new CandidatoVo();
    vo.setId(getId());
    vo.setCargoDisputado(getCargo());
    vo.setCpf(getCpf());
    vo.setEmail(getEmail());
    vo.setNome(getNome());
    vo.setCodigo(getCodigo());
    vo.setPartidoVo(getPartido().toSmall());
    vo.setPleitoVo(getPleito().toSmall());

    return vo;
  }
  public CandidatoVo toSmall(){
    CandidatoVo vo = new CandidatoVo();
    vo.setId(getId());
    vo.setCargoDisputado(getCargo());
    vo.setCpf(getCpf());
    vo.setEmail(getEmail());
    vo.setCodigo(getCodigo());
    vo.setNome(getNome());
    vo.setPartidoVo(getPartido().toSmall());

    return vo;
  }
}
