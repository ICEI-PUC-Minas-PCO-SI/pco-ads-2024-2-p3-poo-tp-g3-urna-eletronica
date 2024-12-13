package urna_eletronica.urna.Services;

import java.util.List;
import java.util.Map;

import urna_eletronica.urna.Entity.Candidato;
import urna_eletronica.urna.VO.PleitoExecutivoVo;
import urna_eletronica.urna.VO.ResultadoPleitoVo;

public interface PleitoExecutivoService {
  String cadastrarPleitoExecutivo(PleitoExecutivoVo vo);
  ResultadoPleitoVo apurarResultadoPrimeiroTurno(Long idPleito);
  List<PleitoExecutivoVo> findAll();
}
