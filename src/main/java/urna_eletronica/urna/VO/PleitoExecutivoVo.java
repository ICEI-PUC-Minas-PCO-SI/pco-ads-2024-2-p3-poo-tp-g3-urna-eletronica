package urna_eletronica.urna.VO;

import java.util.Date;

import lombok.Data;

@Data
public class PleitoExecutivoVo extends PleitoVo {
  private boolean segundoTurno;
  private int minimoParaSegundoTurno;

 

  public PleitoExecutivoVo(){}
}
