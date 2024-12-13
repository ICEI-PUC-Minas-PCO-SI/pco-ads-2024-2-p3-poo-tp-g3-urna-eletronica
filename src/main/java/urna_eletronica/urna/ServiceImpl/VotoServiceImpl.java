package urna_eletronica.urna.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urna_eletronica.urna.Entity.Candidato;
import urna_eletronica.urna.Entity.Partido;
import urna_eletronica.urna.Entity.Pleito;
import urna_eletronica.urna.Entity.Voto;
import urna_eletronica.urna.Repository.UsuarioRepository;
import urna_eletronica.urna.Repository.VotoRepository;
import urna_eletronica.urna.Services.VotoService;
import urna_eletronica.urna.VO.VotoVo;

@Service
public class  VotoServiceImpl implements VotoService {

  @Autowired private UsuarioRepository usuarioRepository;
  @Autowired private VotoRepository votoRepository;

  private Voto toEntity(VotoVo vo){
    Voto newVoto = new Voto();
    newVoto.setCandidato(new Candidato(vo.getCandidatoVo().getId()));
    newVoto.setPleito(new Pleito(vo.getPleitoVo().getId()));
    newVoto.setDataHora(new Date());
    newVoto.setCpf(vo.getCpf());

    return newVoto;
  }
  private boolean verificarUsuario(String cpf){
    // return  usuarioRepository.existsByCpf(cpf);
    return true;
  }

  @Override
  public String verificacoes(VotoVo vo) {
    if(verificarUsuario(vo.getCpf())){
      return cadastrarVoto(vo);
    }
    return "Cpf não encotrado";
  }
  
  private String cadastrarVoto(VotoVo vo){
    Optional<Voto> voto = votoRepository.findByCpf(vo.getCpf(), vo.getPleitoVo().getId());
    if(!voto.isPresent()){
      Voto newVoto = toEntity(vo);

       try {
        votoRepository.save(newVoto);
        return "Voto cadastrado";
      } catch (Exception e) {
          System.out.println(e.getMessage());
          System.out.println("Erro ao cadastrar");
      }
    }
    return "Você já votou";
  }

  public Map<Partido, Integer> calcularVotosPorPartido(Pleito pleito) {
    List<Voto> votos = votoRepository.findByPleito(pleito);

    return votos.stream()
            .collect(Collectors.groupingBy(
                voto -> voto.getCandidato().getPartido(),
                Collectors.summingInt(voto -> 1) // Cada voto conta como 1
            ));
}
  @Override
  public Integer buscarVotoCandidato(Long id) {
    return votoRepository.quantidadeDeVotos(id);
  }
  @Override
  public Integer buscarVotoPleito(Long id) {
    return votoRepository.quantidadeVotosPleito(id);
  }

}
