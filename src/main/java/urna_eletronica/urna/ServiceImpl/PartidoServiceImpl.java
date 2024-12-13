package urna_eletronica.urna.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urna_eletronica.urna.Entity.Partido;
import urna_eletronica.urna.Repository.PartidoRepository;
import urna_eletronica.urna.Services.PartidoService;
import urna_eletronica.urna.VO.PartidoVo;

@Service
public class PartidoServiceImpl implements PartidoService {

  @Autowired private PartidoRepository  partidoRepository;
  
  private Partido toEntity(PartidoVo vo){
    
    Partido partido = new Partido();

    return partido;
  }

  @Override
  public String cadastrarPartido(PartidoVo vo) {
    Partido newPartido = toEntity(vo);
    newPartido.setNome(vo.getNome());
    newPartido.setSigla(vo.getSigla());
    if(newPartido != null){
      try {
        
        partidoRepository.save(newPartido);
        return "Partido criado com sucesso";
      } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Erro ao salvar partido");
      }
    }
 
    return "Partido não foi salvo!";
  }

  @Override
  public List<PartidoVo> findAll() {
    List<Partido> list = partidoRepository.findAll();
    return list.stream().map(Partido::toVo).toList();
  }

  
}
