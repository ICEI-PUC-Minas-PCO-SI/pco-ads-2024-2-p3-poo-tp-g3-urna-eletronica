package urna_eletronica.urna.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import urna_eletronica.urna.VO.PleitoVo;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  
public  class Pleito {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private Date dataInicio;
  private Date dataFim;
  private Integer vagasDisponiveis;

  @JsonManagedReference
  @OneToMany(mappedBy = "pleito")
  private  List<Candidato> candidatos;
  
  public Pleito(Date _dataIncio, Date _dataFim, Integer _vagasDisponiveis, String nome){
    this.dataFim = _dataFim;
    this.dataInicio = _dataIncio;
    this.vagasDisponiveis = _vagasDisponiveis;
    this.nome = nome;
  }
  public Pleito(){}

  public Pleito(Long _id){
    this.id = _id;
  }

 public PleitoVo tovO(){
  PleitoVo vo = new PleitoVo();
  vo.setId(getId());
  vo.setNome(getNome());
  vo.setVagasDisponiveis(getVagasDisponiveis());
  vo.setDataInicio(getDataInicio());
  vo.setDataFim(getDataFim());
  vo.setCandidatoVo(getCandidatos().stream().map(Candidato::toVo).toList());

  return vo;
 }

 public PleitoVo toSmall(){
  PleitoVo vo = new PleitoVo();
  vo.setId(getId());
  vo.setNome(getNome());
  vo.setVagasDisponiveis(getVagasDisponiveis());
  vo.setDataInicio(getDataInicio());
  vo.setDataFim(getDataFim());
  return vo;
 }
  
}
