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

public  class HealthyCalc {

  public static float calcularIMC(final float peso, final float altura) {
    if (peso <= 0 || altura <= 0) {
      throw new IllegalArgumentException("O peso e a altura devem ser valores positivos.");
    }
    return peso / (altura * altura);
  }

  public static String classificarIMC(float imc) {
    if (imc <= 18.5){
      String resposta = "Abaixo do Peso";
      return resposta;
    }
    if (imc >= 18.6 && imc <= 24.9){
      String resposta = "Peso Normal (Parabéns)";
      return  resposta;
    }
    if (imc >=25.0 && imc <= 29.9){
      String resposta = "Levemente acima do peso";
      return  resposta;
    }
    if (imc >= 30.0 && imc <= 34.9){
      String resposta = "Obsedidade Grau 1";
      return  resposta;
    }
    if (imc >= 35.0 && imc <= 39.9){
      String resposta = "Obesidade Grau 2";
      return  resposta;
    }
    else {
      String resposta = "Obesidade Grau 3";
      return  resposta;
    }


  }

  public static float frequenciaCardiacaAlvo() {
    throw new UnsupportedOperationException("Método não implementado.");
  }

  public static float frequenciaCardiacaMaxima() {
    throw new UnsupportedOperationException("Método não implementado.");
  }

  public static float litrosAguaDiarios(int idade, float quilos) {
    if(idade <= 17){
      return  quilos * 0.040f;
    }
    if (idade >= 18 && idade < 55) {
      return  quilos * 0.035f;

    }
    if (idade >=55 && idade <=65) {
      return  quilos * 0.030f;
    }
    else {
      return  quilos * 0.025f;
    }

  }
  public static float taxaGordura(int idade, String sexo, float imc){
    if (sexo == "M" || sexo == "m"){
      return (1.20f * imc) + (0.23f * idade) - (10.8f * 1) - 5.4f;
    }
    else {
      return (1.20f * imc) + (0.23f * idade) - (10.8f * 0) - 5.4f;
    }

  }
}
