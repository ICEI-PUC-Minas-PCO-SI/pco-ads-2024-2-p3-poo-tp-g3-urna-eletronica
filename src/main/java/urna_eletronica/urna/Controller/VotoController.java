package urna_eletronica.urna.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import urna_eletronica.urna.Services.VotoService;
import urna_eletronica.urna.VO.VotoVo;



@RestController
@RequestMapping("/voto")
public class VotoController {
  
  @Autowired private VotoService votoService;

  @PostMapping("/cadastro")
  public ResponseEntity cadastrarVoto(@RequestBody VotoVo entity) {
      return ResponseEntity.ok(votoService.verificacoes(entity));
  }

  @PostMapping("/buscarVotoCandidato/{id}")
  public Integer buscarVotoCandidato(@PathVariable Long id) {
      return votoService.buscarVotoCandidato(id);
  }

  @PostMapping("/buscarVotoPleito/{id}")
  public Integer buscarVotoPleito(@PathVariable Long id) {
      return votoService.buscarVotoPleito(id);
  }
  

  
  
  

}
