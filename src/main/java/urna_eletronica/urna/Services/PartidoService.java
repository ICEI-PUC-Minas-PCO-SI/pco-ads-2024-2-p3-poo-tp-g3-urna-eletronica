package urna_eletronica.urna.Services;

import java.util.List;

import urna_eletronica.urna.VO.PartidoVo;

public interface PartidoService  {
  String cadastrarPartido(PartidoVo vo);
  List<PartidoVo> findAll();
}
