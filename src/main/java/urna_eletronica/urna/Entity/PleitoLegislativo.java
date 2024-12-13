package urna_eletronica.urna.Entity;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import urna_eletronica.urna.VO.PleitoLegislativoVo;

@Data
@Entity
@DiscriminatorValue("PleitoLegislativo")
public class PleitoLegislativo  extends Pleito {
    private Integer votosValidos;
    private Integer quocienteEleitoral;
    private Integer quocientePartidario;

    public PleitoLegislativo(Date _dataIncio, Date _dataFim,
      Integer _vagasDisponiveis, Integer _votosValidos, String nome){

      super(_dataIncio, _dataFim, _vagasDisponiveis, nome);
      this.votosValidos = _votosValidos;
    }
    public PleitoLegislativo(){}


    public PleitoLegislativoVo toVo(){
      PleitoLegislativoVo vo = new PleitoLegislativoVo();
      vo.setDataFim(getDataFim());
      vo.setDataInicio(getDataInicio());
      vo.setId(getId());
      vo.setNome(getNome());
      vo.setQuocienteEleitoral(quocienteEleitoral);
      vo.setQuocientePartidario(quocientePartidario);
      vo.setVagasDisponiveis(getVagasDisponiveis());
      vo.setVotosValidos(getVotosValidos());
      vo.setCandidatoVo(getCandidatos().stream().map(Candidato::toSmall).toList());
      return vo;
    }

    public PleitoLegislativoVo toSmall(){
      PleitoLegislativoVo vo = new PleitoLegislativoVo();
      vo.setDataFim(getDataFim());
      vo.setDataInicio(getDataInicio());
      vo.setId(getId());
      vo.setNome(getNome());
      vo.setQuocienteEleitoral(quocienteEleitoral);
      vo.setQuocientePartidario(quocientePartidario);
      vo.setVagasDisponiveis(getVagasDisponiveis());
      vo.setVotosValidos(getVotosValidos());
      vo.setCandidatoVo(getCandidatos().stream().map(Candidato::toSmall).toList());
      return vo;
    }
}
