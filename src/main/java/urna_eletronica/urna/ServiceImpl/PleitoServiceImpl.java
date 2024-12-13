package urna_eletronica.urna.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urna_eletronica.urna.Entity.Pleito;
import urna_eletronica.urna.Repository.PleitoRepository;
import urna_eletronica.urna.Services.PleitoService;

@Service
public class PleitoServiceImpl implements PleitoService {

  @Autowired private PleitoRepository pleitoRepository;

  @Override
  public String excluirPleito(Long id) {
    Optional<Pleito> pleito = pleitoRepository.findById(id);

    if(pleito.isPresent()){
      try {
        pleitoRepository.delete(pleito.get());
        return "Pleito excluido com sucesso";
      } catch (Exception e) {
        System.out.println("Problema na exclusao");
        return "Problema para excluir";
      }
    }
    return "Pleito não foi encontrado";
  }
  
}
