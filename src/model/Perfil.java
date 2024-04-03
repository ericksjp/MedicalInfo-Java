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
  private LocalDate geradoEm;

  public Perfil(Pessoa pessoa) {
    this.imc = HealthyCalc.calcularIMC(pessoa.getPeso(), pessoa.getAltura());
  }

  public float getImc() {
    return imc;
  }

  public LocalDate getGeradoEm() {
    return geradoEm;
  }

  public void atualizarPerfil(Pessoa pessoa) {
    this.imc = HealthyCalc.calcularIMC(pessoa.getPeso(), pessoa.getAltura());
    geradoEm = LocalDate.now();
  }

  @Override
  public String toString() {
    return """
        Perfil:
          IMC: %.2f
          Gerado em: %s
        """.formatted(imc, geradoEm);
  }
}
