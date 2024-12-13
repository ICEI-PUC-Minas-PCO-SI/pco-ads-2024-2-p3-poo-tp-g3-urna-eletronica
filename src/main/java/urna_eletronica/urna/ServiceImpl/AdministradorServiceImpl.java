package urna_eletronica.urna.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urna_eletronica.urna.Entity.Administrador;
import urna_eletronica.urna.Repository.AdministradorRepository;
import urna_eletronica.urna.Services.AdministradorService;
import urna_eletronica.urna.VO.AdministradorVo;

@Service
public class AdministradorServiceImpl implements AdministradorService {
  
  @Autowired private AdministradorRepository administradorRepository;

  private Administrador toEntity(AdministradorVo vo){
    Administrador adm = new Administrador(vo.getNome(), vo.getEmail(), 
    vo.getSenha(), vo.getCpf(),
    vo.getFuncao(), vo.isTemAcessoTotal(),
    vo.isPodeAlterarPleitos(),
    vo.isPodeGerenciarCandidatos(), vo.isPodeVerResultados(), vo.getIdade());

    return adm;
  }

  @Override
  public String cadastrarAdministrador(AdministradorVo vo) {
    
    Administrador adm = toEntity(vo);
    if(adm != null){
      try {
        
        administradorRepository.save(adm);
        return "Cadastro do administrador feito com sucesso";
        
      } catch (Exception e) {
        // TODO: 
        System.out.println(e.getMessage());
        System.out.println("Erro ao cadastrar");
      }
    }

    return "Administrador não foi cadastrado";
  }

  @Override 
  public List<AdministradorVo> findAll(){
    List<Administrador> list = administradorRepository.findAll();
    return list.stream().map(Administrador::toVo).toList();
  }

  
}
