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

import urna_eletronica.urna.Services.PleitoExecutivoService;
import urna_eletronica.urna.VO.PleitoExecutivoVo;
import urna_eletronica.urna.VO.ResultadoPleitoVo;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/pleitoExecutivo")
public class PleitoExecutivoController {

  @Autowired private PleitoExecutivoService pleitoExecutivoService;

  @PostMapping("/cadastro")
  public ResponseEntity<?> cadastrarPleitoExecutivo(@RequestBody PleitoExecutivoVo entity) {
      return ResponseEntity.ok(pleitoExecutivoService.cadastrarPleitoExecutivo(entity));
  }

  @GetMapping("/apurarResultadoPrimeiroTurno/{param}")
  public ResponseEntity<ResultadoPleitoVo> apurarResultadoPrimeiroTurno(@PathVariable Long param) {
      return ResponseEntity.ok(pleitoExecutivoService.apurarResultadoPrimeiroTurno(param));
  }

  @GetMapping("/findAll")
  public List<PleitoExecutivoVo> findAll() {
      return pleitoExecutivoService.findAll();
  }

  
}
