package utils;

import model.Perfil;
import model.Pessoa;

public class PParser {

  public static String formatPessoaPerfilToCSVType(Pessoa pessoa) {
    Perfil perfil = pessoa.getPerfil();
    String headers = "Nome;Idade;Altura;Peso;Genero;NivelAtivFisica;IMC;Classificacao;FreqCardAlvoMinina;FreqCardAlvoMax;TMB;RecConsAguaDiariO;TaxGordura;\n";
    return "%s%s;%d;%f;%f;%c;%s;%f;%s;%f;%f;%f;%f;%f"
        .formatted(
            headers,
            pessoa.getNome(), pessoa.getIdade(), pessoa.getAltura(),
            pessoa.getPeso(), pessoa.getGenero(), pessoa.getNivelAtividadeFisica(),
            perfil.getImc(), perfil.classificacaoIMC(),
            perfil.frequenciaCardiacaAlvo()[0], perfil.frequenciaCardiacaAlvo()[1],
            perfil.taxaMetabolicaBasal(), perfil.consumoDiarioAgua(),
            perfil.taxaGordura())
        .replaceAll(",", ".");
  }

  public static String formatPessoaToTXTType(Pessoa pessoa) {
    return """
        \s\s\sNome: %s\n
        \s\s\sAltura: %.2f\n
        \s\s\sPeso: %.2f\n
        \s\s\sIdade IMC: %d\n
        \s\s\sGênero: %c\n
        \s\s\sNível de Atividade Física: %s\n
        """.formatted(pessoa.getNome(), pessoa.getAltura(), pessoa.getPeso(), pessoa.getIdade(), pessoa.getGenero(),
        pessoa.getNivelAtividadeFisica());
  }

  public static String formatPerfilToTXTFileType(Perfil perfil) {
    return """
        \s\s\sIMC: %.2f\n
        \s\s\sClassificação IMC: %s\n
        \s\s\sFrequência Cardíaca Alvo: %.2f - %.2f\n
        \s\s\sFrequência Cardíaca Máxima: %.2f\n
        \s\s\sTaxa Metabólica Basal: %.2f\n
        \s\s\sConsumo Diário de Água Recomendado: %.2fL\n
        \s\s\sTaxa de Gordura: %.2f\n
        \s\s\s----------------------------------------------------------------
        \s\s\sData de avaliação: %s
        """.formatted(perfil.getImc(), perfil.classificacaoIMC(), perfil.frequenciaCardiacaAlvo()[0],
        perfil.frequenciaCardiacaAlvo()[1],
        perfil.frequenciaCardiacaMaxima(), perfil.taxaMetabolicaBasal(), perfil.consumoDiarioAgua(),
        perfil.taxaGordura(), perfil.getGeradoEm());
  }

  public static String formatPessoaPerfilToTXTFileType(Pessoa pessoa) {
    return "\n" + formatPessoaToTXTType(pessoa)
        + "   ---------------------------------------------------------------\n\n"
        + formatPerfilToTXTFileType(pessoa.getPerfil());
  }
}
