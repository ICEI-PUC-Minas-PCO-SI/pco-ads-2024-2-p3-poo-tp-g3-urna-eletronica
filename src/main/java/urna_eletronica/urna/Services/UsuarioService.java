package urna_eletronica.urna.Services;


import java.util.List;

import urna_eletronica.urna.VO.UsuarioVo;

public interface UsuarioService{
  String cadastrarUsuario(UsuarioVo user);
  UsuarioVo verificarUsuario(UsuarioVo user);
  List<UsuarioVo> findAll();
}
