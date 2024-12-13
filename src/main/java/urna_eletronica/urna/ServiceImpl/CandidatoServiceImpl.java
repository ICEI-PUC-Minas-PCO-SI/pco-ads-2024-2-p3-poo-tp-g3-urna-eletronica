package urna_eletronica.urna.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urna_eletronica.urna.Entity.Candidato;
import urna_eletronica.urna.Entity.Partido;
import urna_eletronica.urna.Entity.Pleito;
import urna_eletronica.urna.Repository.CandidatoRepository;
import urna_eletronica.urna.Repository.PartidoRepository;
import urna_eletronica.urna.Services.CandidatoService;
import urna_eletronica.urna.VO.CandidatoVo;

@Service
public class CandidatoServiceImpl implements CandidatoService {
  
  @Autowired private CandidatoRepository candidatoRepository;
  @Autowired private PartidoRepository partidoRepository;



  @Override
  public List<CandidatoVo> findAllCandidato() {
    List<Candidato> candidatos = candidatoRepository.findAll();
    return candidatos.stream()
                     .map(Candidato::toVo)
                     .toList(); 
    
  }

  @Override
  public List<CandidatoVo> findAllPleitoById(Long id) {
    List<Candidato> candidatos = candidatoRepository.findAllCandidatosPleito(id);
    return candidatos.stream().map(Candidato::toVo).toList();
  }

  @Override
  public Long findBuscarCandidatoCodigo(Integer id) {
    Optional<Candidato> candidato = candidatoRepository.findByCodigo(id);
    
    if(candidato.isPresent()){
      return candidato.get().getId();
    }
    return null;
  }
}
