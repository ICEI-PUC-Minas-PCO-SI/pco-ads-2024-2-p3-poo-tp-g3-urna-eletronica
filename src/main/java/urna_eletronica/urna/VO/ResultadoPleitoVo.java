package urna_eletronica.urna.VO;

import java.util.List;

import lombok.Data;
import urna_eletronica.urna.Entity.Candidato;

@Data
public class ResultadoPleitoVo {
  private Candidato vencedor;
    private List<Candidato> segundoTurno;
    private boolean primeiroTurnoResolvido;

    public ResultadoPleitoVo(Candidato vencedor, boolean primeiroTurnoResolvido) {
        this.vencedor = vencedor;
        this.primeiroTurnoResolvido = primeiroTurnoResolvido;
    }

    public ResultadoPleitoVo(List<Candidato> segundoTurno, boolean primeiroTurnoResolvido) {
        this.segundoTurno = segundoTurno;
        this.primeiroTurnoResolvido = primeiroTurnoResolvido;
    }
}
