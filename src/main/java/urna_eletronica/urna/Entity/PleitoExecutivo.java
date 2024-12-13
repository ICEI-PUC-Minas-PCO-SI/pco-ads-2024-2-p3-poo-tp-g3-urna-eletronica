package urna_eletronica.urna.Entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import urna_eletronica.urna.VO.PleitoExecutivoVo;

@Data
@Entity
@DiscriminatorValue("PleitoExecutivo")
public class PleitoExecutivo extends Pleito {
  
  private boolean segundoTurno;
  private int minimoParaSegundoTurno;

  @OneToMany
  private List<Candidato> CandidatoSegundoTurno; //Aqui ira ser aplicado a regra de negócio para o segundo turno

  public PleitoExecutivo(Date _dataIncio, Date _dataFim,
   Integer _vagasDisponiveis, int _minimoParaSegundoTurno, String nome){

    super(_dataIncio, _dataFim, _vagasDisponiveis, nome);
    this.minimoParaSegundoTurno = _minimoParaSegundoTurno;
  }
  public PleitoExecutivo(){}


  public PleitoExecutivoVo toVo(){
    PleitoExecutivoVo vo = new PleitoExecutivoVo();
    vo.setId(getId());
    vo.setDataFim(getDataFim());
    vo.setDataInicio(getDataInicio());
    vo.setMinimoParaSegundoTurno(getMinimoParaSegundoTurno());
    vo.setNome(getNome());
    vo.setVagasDisponiveis(getVagasDisponiveis());
    vo.setCandidatoVo(getCandidatos().stream().map(Candidato::toSmall).toList());
    vo.setSegundoTurno(isSegundoTurno());
    return vo;
  }

  public PleitoExecutivoVo toSmall(){
    PleitoExecutivoVo vo = new PleitoExecutivoVo();
    vo.setId(getId());
    vo.setDataFim(getDataFim());
    vo.setDataInicio(getDataInicio());
    vo.setMinimoParaSegundoTurno(getMinimoParaSegundoTurno());
    vo.setNome(getNome());
    vo.setVagasDisponiveis(getVagasDisponiveis());
    vo.setSegundoTurno(isSegundoTurno());
    return vo;
  }
}

