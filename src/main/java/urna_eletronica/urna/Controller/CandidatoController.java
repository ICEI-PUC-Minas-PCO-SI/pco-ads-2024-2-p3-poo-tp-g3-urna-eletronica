package urna_eletronica.urna.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import urna_eletronica.urna.Services.CandidatoService;
import urna_eletronica.urna.VO.CandidatoVo;



@RestController
@RequestMapping("/candidato")
public class CandidatoController {
  
  @Autowired private CandidatoService candidatoService;


  @PostMapping("/findBuscarCandidatoCodigo")
  public Long findBuscarCandidatoCodigo(@RequestBody Integer  entity) {
      return candidatoService.findBuscarCandidatoCodigo(entity) ;
  }
  
  
  
}
