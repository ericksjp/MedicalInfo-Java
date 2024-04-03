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

public abstract class HealthyCalc {

  public static float calcularIMC(final float peso, final float altura) {
    if (peso <= 0 || altura <= 0) {
      throw new IllegalArgumentException("O peso e a altura devem ser valores positivos.");
    }
    return peso / (altura * altura);
  }

  public static String classificarIMC() {
    throw new UnsupportedOperationException("Método não implementado.");
  }

  public static float[] frequenciaCardiacaAlvo(final char genero, final int idade) {
    float frequenciaCardiacaMax = frequenciaCardiacaMaxima(genero, idade);
    
    float frequenciaCardiacaAlvoMinima = frequenciaCardiacaMax * 0.5f;
    float frequenciaCardiacaAlvoMaxima = frequenciaCardiacaMax * 0.85f;

    return new float[]{frequenciaCardiacaAlvoMinima, frequenciaCardiacaAlvoMaxima};
  }

  public static int frequenciaCardiacaMaxima(final char genero, final int idade) {
    if(genero == 'F') return 226 - idade;
    if(genero == 'M') return 220 - idade;
    throw new IllegalArgumentException("Gênero inválido. Use 'F' para feminino e 'M' para masculino.");
  }

  public static float litrosAguaDiarios() {
    throw new UnsupportedOperationException("Método não implementado.");
  }

  public static float taxaGordura() {
    throw new UnsupportedOperationException("Método não implementado.");
  }
}
