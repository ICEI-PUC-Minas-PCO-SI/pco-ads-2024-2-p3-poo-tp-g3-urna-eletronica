package urna_eletronica.urna.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import urna_eletronica.urna.Services.UsuarioService;
import urna_eletronica.urna.VO.UsuarioVo;



@RestController
@RequestMapping("/usuario")
public class UsuarioController {
  
  @Autowired private UsuarioService usuarioService;

   @PostMapping("/cadastro")
  public ResponseEntity<?> cadastroUsuario(@RequestBody UsuarioVo entity) {
    String result = usuarioService.cadastrarUsuario(entity);
      return result != null ? ResponseEntity.ok(result) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF já utilizado");
  }

  @PostMapping("/login")
  public ResponseEntity<?> verificarLogin(@RequestBody UsuarioVo entity) {
    UsuarioVo user = usuarioService.verificarUsuario(entity);
    return user != null ? ResponseEntity.ok(user) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
  }

  @GetMapping("/findAll")
  public List<UsuarioVo> findAll() {
    return usuarioService.findAll();
  }
  
  
  
}
