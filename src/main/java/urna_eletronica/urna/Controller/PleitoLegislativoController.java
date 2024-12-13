package urna_eletronica.urna.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import urna_eletronica.urna.Services.PleitoLegislativoService;
import urna_eletronica.urna.VO.PleitoLegislativoVo;



@RestController
@RequestMapping("/pleitoLegislativo")
public class PleitoLegislativoController {
  
  @Autowired private PleitoLegislativoService pleitoLegislativoService;

  @PostMapping("/cadastro")
  public ResponseEntity cadastrarPleito(@RequestBody PleitoLegislativoVo entity) {      
      return ResponseEntity.ok(pleitoLegislativoService.cadastraPleitoLegislativo(entity));
  }

  @GetMapping("/findAll")
  public List<PleitoLegislativoVo> findAll() {
      return pleitoLegislativoService.findAll();
  }
  
  
  
}
