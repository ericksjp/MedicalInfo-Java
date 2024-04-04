package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import model.Perfil;
import model.Pessoa;

public class ParseToCSV {

  public static Path parsePessoaToCSV(Pessoa pessoa, String path) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
      writer.write(formatPessoaToCSV(pessoa));
      return Paths.get(path);
    } catch (IOException e) {
      throw new IOException("Erro ao escrever arquivo CSV.", e);
    }
  }

  private static String formatPessoaToCSV(Pessoa pessoa) {
    Perfil perfil = pessoa.getPerfil();
    return String.format("%s;%d;%f;%f;%s;%s;%f;%s;%d;%d;%d;%d;%f\n",
        pessoa.getNome(), pessoa.getIdade(), pessoa.getAltura(),
        pessoa.getPeso(), pessoa.getGenero(), pessoa.getNivelAtividadeFisica(),
        perfil.getImc(), perfil.classificacaoIMC(),
        perfil.frequenciaCardiacaAlvo()[0], perfil.frequenciaCardiacaAlvo()[1],
        perfil.taxaMetabolicaBasal(), perfil.consumoDiarioAgua(),
        perfil.taxaGordura());
  }
}

