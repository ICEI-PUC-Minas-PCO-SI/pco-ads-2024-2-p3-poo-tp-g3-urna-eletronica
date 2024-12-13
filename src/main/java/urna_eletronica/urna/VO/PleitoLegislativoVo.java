package urna_eletronica.urna.VO;

import java.util.Date;

import lombok.Data;
import urna_eletronica.urna.Entity.PleitoLegislativo;

@Data
public class PleitoLegislativoVo extends PleitoVo {
  private Integer votosValidos;
  private Integer quocienteEleitoral;
  private Integer quocientePartidario;

  public PleitoLegislativoVo(Date _dataIncio, Date _dataFim,
   Integer _vagasDisponiveis, Integer _votosValidos,
    Integer _quocienteEleitoral, Integer  _quocientePartidario){
    super(_dataIncio, _dataFim, _vagasDisponiveis);
    this.votosValidos = _votosValidos;
    this.quocienteEleitoral = _quocienteEleitoral;
    this.quocientePartidario = _quocientePartidario;
  }

  public PleitoLegislativoVo(){}

  public PleitoLegislativo toEntity(){
    PleitoLegislativo pleito = new PleitoLegislativo();
    pleito.setDataInicio(getDataInicio());
    pleito.setDataFim(getDataFim());
    pleito.setVagasDisponiveis(getVagasDisponiveis());
    pleito.setVotosValidos(getVotosValidos());
    pleito.setQuocienteEleitoral(getQuocienteEleitoral());
    pleito.setQuocientePartidario(getQuocientePartidario());


    return pleito;
  }
}
