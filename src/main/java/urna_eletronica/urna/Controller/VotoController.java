package urna_eletronica.urna.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import urna_eletronica.urna.Services.VotoService;
import urna_eletronica.urna.VO.VotoVo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/voto")
public class VotoController {
  
  @Autowired private VotoService votoService;

  @PostMapping("/cadastro")
  public ResponseEntity cadastrarVoto(@RequestBody VotoVo entity) {
      return ResponseEntity.ok(votoService.verificacoes(entity));
  }
  

}
