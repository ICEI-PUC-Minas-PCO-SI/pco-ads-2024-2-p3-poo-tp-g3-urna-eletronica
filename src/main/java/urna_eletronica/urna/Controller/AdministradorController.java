package urna_eletronica.urna.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import urna_eletronica.urna.Services.AdministradorService;
import urna_eletronica.urna.VO.AdministradorVo;



@RestController
@RequestMapping("/administrador")
public class AdministradorController {
  
  @Autowired private AdministradorService administradorService;

  @PostMapping("/cadastro")
  public ResponseEntity postMethodName(@RequestBody AdministradorVo entity) {
      return ResponseEntity.ok(administradorService.cadastrarAdministrador(entity));
  }

  @GetMapping("/findAll")
  public List<AdministradorVo> findAll() {
      return administradorService.findAll();
  }
  
  
}
