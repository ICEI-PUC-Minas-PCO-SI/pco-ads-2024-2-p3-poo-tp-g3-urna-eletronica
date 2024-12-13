package urna_eletronica.urna.Services;

import urna_eletronica.urna.VO.VotoVo;

public interface VotoService {
  String verificacoes(VotoVo vo);
  Integer buscarVotoCandidato(Long id);
  Integer buscarVotoPleito(Long id);
}
