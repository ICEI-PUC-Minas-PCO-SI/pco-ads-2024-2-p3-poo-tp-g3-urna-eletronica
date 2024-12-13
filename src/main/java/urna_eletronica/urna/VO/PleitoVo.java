package urna_eletronica.urna.VO;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public  class PleitoVo {
  private Long id;
  private String nome;
  private Date dataInicio;
  private Date dataFim;
  private Integer vagasDisponiveis;
  private List<CandidatoVo> candidatoVo;

  public PleitoVo(){}
  public PleitoVo(Date _dataIncio, Date _dataFim, Integer _vagasDisponiveis){
    this.dataFim = _dataFim;
    this.dataInicio = _dataIncio;
    this.vagasDisponiveis = _vagasDisponiveis;
  }
}
