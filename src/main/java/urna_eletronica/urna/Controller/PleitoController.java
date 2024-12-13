package urna_eletronica.urna.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import urna_eletronica.urna.Services.PleitoService;

@RestController
@RequestMapping("/pleito")
public class PleitoController {
    
   @Autowired private PleitoService pleitoService;

    @PutMapping("/excluir/{id}")
  public String excluirUsuario(@PathVariable Long id) {
      return pleitoService.excluirPleito(id);
  }
  
}
