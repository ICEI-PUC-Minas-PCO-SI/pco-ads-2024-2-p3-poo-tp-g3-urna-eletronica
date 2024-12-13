package urna_eletronica.urna.VO;

import java.util.Date;

import lombok.Data;

@Data
public class PleitoExecutivoVo extends PleitoVo {
  private boolean segundoTurno;
  private int minimoParaSegundoTurno;

  public PleitoExecutivoVo(Date _dataIncio, Date _dataFim,
   Integer _vagasDisponiveis, boolean _segundoTurno, int _minimoParaSegundoTurno){
    super(_dataIncio, _dataFim, _vagasDisponiveis);
    this.segundoTurno = _segundoTurno;
    this.minimoParaSegundoTurno = _minimoParaSegundoTurno;
  }

  public PleitoExecutivoVo(){}
}
