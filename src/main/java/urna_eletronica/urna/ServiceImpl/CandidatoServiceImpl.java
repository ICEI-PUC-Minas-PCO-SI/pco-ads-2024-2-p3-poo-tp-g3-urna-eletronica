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
import urna_eletronica.urna.Repository.UsuarioRepository;
import urna_eletronica.urna.Services.CandidatoService;
import urna_eletronica.urna.VO.CandidatoVo;

@Service
public class CandidatoServiceImpl implements CandidatoService {
  
  @Autowired private CandidatoRepository candidatoRepository;
  @Autowired private PartidoRepository partidoRepository;

  @Autowired private UsuarioRepository usuarioRepository;

  private Candidato toEntity(CandidatoVo vo){
    
    Candidato newCandidato = new Candidato();
    newCandidato.setCargo(vo.getCargoDisputado());
    newCandidato.setCpf(vo.getCpf());
    newCandidato.setEmail(vo.getEmail());
    newCandidato.setNome(vo.getNome());
    newCandidato.setPartido(new Partido(vo.getPartidoVo().getNome(), vo.getPartidoVo().getSigla(), vo.getPartidoVo().getId()));
    newCandidato.setSenha(vo.getSenha());
    newCandidato.setPleito(new Pleito(vo.getPleitoVo().getId()));
    newCandidato.setCodigo(vo.getCodigo());

    return newCandidato;
  }

  private void verificarPartido(Candidato candidato, Long id){
    Optional<Partido> partido = partidoRepository.findById(id);
    
    if(!partido.isPresent()){
       candidato.setPartido(partido.get());
    }
  }

  @Override
  public String cadastrarCandidato(CandidatoVo vo) {
    if(usuarioRepository.existsByCpf(vo.getCpf())){
      Candidato candidato = toEntity(vo);
      if(candidato != null){
        try {
          candidatoRepository.save(candidato);
          return "Candidato cadastrado com sucesso";
        } catch (Exception e) {
          System.out.println(e.getMessage());
          System.out.println("Erro a salvar o candidato");
       }
      }
    }
    return "Candidato já cadastrado";
  }

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
