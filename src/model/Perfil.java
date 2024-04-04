/**
 * Classe Perfil que representa o perfil de uma pessoa, gerado com base nos dados fornecidos.
 * Os cálculos são realizados utilizando a classe HealthyCalc.
 * 
 * Esta classe encapsula o perfil de uma pessoa, incluindo o Índice de Massa Corporal (IMC) calculado
 * a partir do peso e altura da pessoa. Além disso, mantém a data em que o perfil foi gerado.
 * 
 * @date 03-04-2024
 * @author ericksjp
 */

package model;

import java.time.LocalDate;
import utils.HealthyCalc;

public class Perfil {
  private float imc;
  private String classificacaoIMC;
  private float[] frequenciaCardiacaAlvo;
  private float frequenciaCardiacaMaxima;
    private float taxaMetabolicaBasal;
    private float consumoDiarioAgua;
    private float taxaGordura;
  private LocalDate geradoEm;

  public Perfil(Pessoa pessoa) {
    this.imc = HealthyCalc.calcularIMC(pessoa.getPeso(), pessoa.getAltura());
    this.classificacaoIMC = HealthyCalc.classificarIMC(imc);
    this.frequenciaCardiacaAlvo = HealthyCalc.frequenciaCardiacaAlvo(pessoa.getGenero(), pessoa.getIdade());
    this.frequenciaCardiacaMaxima = HealthyCalc.frequenciaCardiacaMaxima(pessoa.getGenero(), pessoa.getIdade());
    this.taxaMetabolicaBasal = HealthyCalc.taxaMetabolicaBasal(pessoa);
    this.consumoDiarioAgua = HealthyCalc.litrosAguaDiarios(pessoa.getIdade(), pessoa.getPeso());
    this.taxaGordura = HealthyCalc.taxaGordura(pessoa.getIdade(), pessoa.getGenero() , imc);
    this.geradoEm = LocalDate.now();
  }

  public String classificacaoIMC() {
    return classificacaoIMC;
  }

  public float[] frequenciaCardiacaAlvo() {
    return frequenciaCardiacaAlvo;
  }

  public float frequenciaCardiacaMaxima() {
    return frequenciaCardiacaMaxima;
  }

  public float taxaMetabolicaBasal() {
    return taxaMetabolicaBasal;
  }

  public float consumoDiarioAgua() {
    return consumoDiarioAgua;
  }

  public float taxaGordura() {
    return taxaGordura;
  }

  public float getImc() {
    return imc;
  }

  public LocalDate getGeradoEm() {
    return geradoEm;
  }

  public void atualizarPerfil(Pessoa pessoa) {
    imc = HealthyCalc.calcularIMC(pessoa.getPeso(), pessoa.getAltura());
    classificacaoIMC = HealthyCalc.classificarIMC(imc);
    frequenciaCardiacaAlvo = HealthyCalc.frequenciaCardiacaAlvo(pessoa.getGenero(), pessoa.getIdade());
    frequenciaCardiacaMaxima = HealthyCalc.frequenciaCardiacaMaxima(pessoa.getGenero(), pessoa.getIdade());
    taxaMetabolicaBasal = HealthyCalc.taxaMetabolicaBasal(pessoa);
    consumoDiarioAgua = HealthyCalc.litrosAguaDiarios(pessoa.getIdade(), pessoa.getPeso());
    taxaGordura = HealthyCalc.taxaGordura(pessoa.getIdade(), pessoa.getGenero() , imc);
    geradoEm = LocalDate.now();
  }

  @Override
  public String toString(){
    return """
        Perfil:
          IMC: %.2f
          Classificação IMC: %s
          Frequência Cardíaca Alvo: %.2f - %.2f
          Frequência Cardíaca Máxima: %.2f
          Taxa Metabólica Basal: %.2f
          Consumo Diário de Água: %.2f
          Taxa de Gordura: %.2f
          ----------------------------
          Gerado em: %s
          """.formatted(imc, classificacaoIMC, frequenciaCardiacaAlvo[0], frequenciaCardiacaAlvo[1], frequenciaCardiacaMaxima, taxaMetabolicaBasal, consumoDiarioAgua, taxaGordura, geradoEm);
  }
}
