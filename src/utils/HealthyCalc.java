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

import enums.NivelAtividadeFisica;
import model.Pessoa;

public abstract class HealthyCalc {

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

  public static float taxaMetabolicaBasal(Pessoa pessoa) {
    float taxaAtividade = 0;
    switch (pessoa.getNivelAtividadeFisica()) {
      case SEDENTARIO: taxaAtividade = 1.2f; break;
      case LEVEMENTE_ATIVO: taxaAtividade = 1.375f; break;
      case MODERADAMENTE_ATIVO: taxaAtividade = 1.55f; break;
      case ALTAMENTE_ATIVO: taxaAtividade = 1.725f; break;
      case EXTREMAMENTE_ATIVO: taxaAtividade = 1.9f;
    }

    if(pessoa.getGenero() == 'M') {
      return taxaAtividade * (66 + 13.7f * pessoa.getPeso() + 5 * (pessoa.getAltura() * 100) - 6.8f * pessoa.getIdade()); // O cálculo é feito com a medida de altura em cm
    }

    if(pessoa.getGenero() == 'F') {
      return taxaAtividade * (655 + 9.6f * pessoa.getPeso() + 1.8f * (pessoa.getAltura() * 100) - 4.7f * pessoa.getIdade());
    }

    throw new IllegalArgumentException("Gênero inválido. Use 'F' para feminino e 'M' para masculino.");
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
