package urna_eletronica.urna.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
      return ResponseEntity.ok(usuarioService.cadastrarUsuario(entity));
  }

  @PostMapping("/login")
  public ResponseEntity<?> verificarLogin(@RequestBody UsuarioVo entity) {
      UsuarioVo user = usuarioService.verificarUsuario(entity);
      return user != null ? ResponseEntity.ok(user) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
  }
  
  
}
