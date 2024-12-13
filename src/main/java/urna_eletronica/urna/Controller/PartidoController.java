package urna_eletronica.urna.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import urna_eletronica.urna.Services.PartidoService;
import urna_eletronica.urna.VO.PartidoVo;


@RestController
@RequestMapping("/partido")
public class PartidoController {
  
  @Autowired private PartidoService partidoService;

  @PostMapping("/cadastro")
  public ResponseEntity postMethodName(@RequestBody PartidoVo entity) {
      //TODO: 
      return ResponseEntity.ok(partidoService.cadastrarPartido(entity));
  }
  
}
