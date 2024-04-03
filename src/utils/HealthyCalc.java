/**
 * A classe HealthyCalc fornece métodos estáticos para cálculos relacionados à saúde.
 * 
 * Esta classe encapsula diversos cálculos úteis relacionados à saúde, como cálculo do Índice de Massa Corporal (IMC),
 * classificação do IMC, frequência cardíaca alvo, frequência cardíaca máxima, consumo diário de água e taxa de gordura.
 *
 * @date 03-04-2024
 * @author ericksjp
 */

package utils;

public class HealthyCalc {

  public static float calcularIMC(final float peso, final float altura) {
    if (peso <= 0 || altura <= 0) {
      throw new IllegalArgumentException("O peso e a altura devem ser valores positivos.");
    }
    return peso / (altura * altura);
  }

  public static String classificarIMC(final float imc) {
    if (imc <= 18.5) {
      return "Abaixo do Peso";
    } else if (imc <= 24.9) {
      return "Peso Normal";
    } else if (imc <= 29.9) {
      return "Levemente Acima do Peso";
    } else if (imc <= 34.9) {
      return "Obesidade Grau 1";
    } else if (imc <= 39.9) {
      return "Obesidade Grau 2";
    } else {
      return "Obesidade Grau 3";
    }
  }

  public static float litrosAguaDiarios(final int idade, final float quilos) {
    if (idade <= 17) {
      return quilos * 0.040f;
    } else if (idade < 55) {
      return quilos * 0.035f;
    } else if (idade <= 65) {
      return quilos * 0.030f;
    } else {
      return quilos * 0.025f;
    }
  }

  public static float taxaGordura(final int idade, char sexo, final float imc) {
    sexo = Character.toUpperCase(sexo);
    if (sexo == 'M') {
      return (1.20f * imc) + (0.23f * idade) - (10.8f * 1) - 5.4f;
    } else if (sexo == 'F') {
      return (1.20f * imc) + (0.23f * idade) - (10.8f * 0) - 5.4f;
    } else {
      throw new IllegalArgumentException("O sexo deve ser 'M' ou 'F'.");
    }
  }
}
