package urna_eletronica.urna.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import urna_eletronica.urna.VO.UsuarioVo;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  
public  class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String email;
  private String senha;
  private Integer idade;

  @Column(unique = true)
  private String cpf;
  

  public Usuario(String nome, String email, String senha, String cpf, Integer idade){
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.cpf = cpf;
    this.idade = idade;
  }
  public Usuario(){}

  public UsuarioVo toVo(){
    UsuarioVo vo = new UsuarioVo();
    vo.setNome(getNome());
    vo.setCpf(getCpf());
    vo.setEmail(getEmail());
    vo.setSenha(getSenha());

    return vo;
  }
}
