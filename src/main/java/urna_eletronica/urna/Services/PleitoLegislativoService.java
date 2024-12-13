package urna_eletronica.urna.Services;

import java.util.List;

import urna_eletronica.urna.Entity.PleitoLegislativo;
import urna_eletronica.urna.VO.PleitoLegislativoVo;

public interface PleitoLegislativoService {
  String cadastraPleitoLegislativo(PleitoLegislativoVo vo);
  void apurarResultadosPleitoLegislativo(PleitoLegislativo pleito);
  List<PleitoLegislativoVo> findAll();
  
}
