package urna_eletronica.urna.Services;

import java.util.List;

import urna_eletronica.urna.VO.AdministradorVo;

public interface AdministradorService {
  String cadastrarAdministrador(AdministradorVo vo);
  List<AdministradorVo> findAll();
}
