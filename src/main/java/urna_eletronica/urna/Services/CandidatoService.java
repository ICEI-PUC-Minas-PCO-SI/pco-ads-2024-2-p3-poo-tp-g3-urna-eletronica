package urna_eletronica.urna.Services;

import java.util.List;

import urna_eletronica.urna.VO.CandidatoVo;

public interface CandidatoService {
  String cadastrarCandidato(CandidatoVo vo);
  List<CandidatoVo> findAllCandidato();
  List<CandidatoVo> findAllPleitoById(Long id);
  Long findBuscarCandidatoCodigo(Integer id);

}
