package urna_eletronica.urna.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urna_eletronica.urna.Entity.Usuario;
import urna_eletronica.urna.Repository.UsuarioRepository;
import urna_eletronica.urna.Services.UsuarioService;
import urna_eletronica.urna.VO.UsuarioVo;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  @Autowired private UsuarioRepository usuarioRepository;
  

  private Usuario toEntity(UsuarioVo entity){
    
    Usuario usuario = new Usuario();
    
    usuario.setCpf(entity.getCpf());
    usuario.setEmail(entity.getEmail());
    usuario.setNome(entity.getNome());
    usuario.setSenha(entity.getSenha());
    
    return usuario;
  }

  private Boolean verificarUsuario(String cpf){
    return usuarioRepository.existsByCpf(cpf);
  }

  public String cadastrarUsuario(UsuarioVo user) {
    if(!verificarUsuario(user.getCpf())){
      usuarioRepository.save(toEntity(user));
      return "Usuario criado com sucesso";
    }
    return null;
  }

  @Override
  public UsuarioVo verificarUsuario(UsuarioVo user) {

    try {
      Optional<Usuario> usuario = usuarioRepository.findByCpfAndSenha( user.getCpf(), user.getSenha());
      
      if(usuario.isPresent()){
        
        UsuarioVo usuarioVo = usuario.get().toVo();
        return usuarioVo;
     }
     return null;

    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public List<UsuarioVo> findAll() {
    List<Usuario> list = usuarioRepository.findAll();
    return list.stream().map(Usuario::toVo).toList();
  }

  @Override
  public String excluirUsuario(Long id) {
    Optional<Usuario> user = usuarioRepository.findById(id);
   if(user.isPresent()){
    try {
      usuarioRepository.delete(user.get());
      return "Usuario excluido";
    } catch (Exception e) {
      System.out.println("Error caiu no catch");
      return "Problema para excluir";
    }
   }
    return "Usuario não existe";
  }
}

