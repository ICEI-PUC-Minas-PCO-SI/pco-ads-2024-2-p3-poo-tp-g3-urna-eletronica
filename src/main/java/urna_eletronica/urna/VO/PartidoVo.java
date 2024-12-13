package urna_eletronica.urna.VO;

import java.util.List;

import lombok.Data;

@Data
public  class PartidoVo {
  private Long id;
  private String nome;
  private String sigla;
  private List<CandidatoVo> candidatoVo;

  public PartidoVo(){}


}
