/**
 * Esta classe encapsula informações essenciais sobre uma pessoa, como nome, gênero, idade, altura e peso,
 * e mantém um perfil associado que calcula e atualiza automaticamente o Índice de Massa Corporal (IMC)
 * com base nos dados da pessoa.
 * 
 * @date 03-04-2024
 * @author ericksjp
 */

package model;

import enums.NivelAtividadeFisica;

public class Pessoa {
  private String nome;
  private char genero;
  private int idade;
  private float altura;
  private float peso;
  private NivelAtividadeFisica nivelAtividadeFisica;
  private Perfil perfil;

  public Pessoa(String nome, char genero, int idade, float altura, float peso, NivelAtividadeFisica nivelAtividadeFisica) {
    if (nome.replaceAll(" ", "").length() < 3)
      throw new IllegalArgumentException("O nome deve ter no mínimo 3 caracteres.");
    if (nome.length() > 50)
      throw new IllegalArgumentException("O nome deve ter no máximo 50 caracteres.");

    genero = Character.toUpperCase(genero);
    if (genero != 'F' && genero != 'M')
      throw new IllegalArgumentException("O gênero deve ser M ou F.");

    if (idade < 0) {
      throw new IllegalArgumentException("A idade deve ser um valor positivo.");
    }

    if (altura <= 0)
      throw new IllegalArgumentException("A altura deve ser um valor positivo.");
    if (peso <= 0)
      throw new IllegalArgumentException("O peso deve ser um valor positivo.");

    this.nome = nome;
    this.genero = genero;
    this.idade = idade;
    this.altura = altura;
    this.peso = peso;
    this.nivelAtividadeFisica = nivelAtividadeFisica;
    this.perfil = new Perfil(this);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    if (nome.replaceAll(" ", "").length() < 3)
      throw new IllegalArgumentException("O nome deve ter no mínimo 3 caracteres.");
    if (nome.length() > 50)
      throw new IllegalArgumentException("O nome deve ter no máximo 50 caracteres.");
    this.nome = nome;
  }

  public char getGenero() {
    return genero;
  }

  public void setGenero(char genero) {
    genero = Character.toUpperCase(genero);
    if (genero != 'F' && genero != 'M')
      throw new IllegalArgumentException("O gênero deve ser M ou F.");

    this.genero = genero;
    perfil.atualizarPerfil(this);
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    if (idade < 0) {
      throw new IllegalArgumentException("A idade deve ser um valor positivo.");
    }

    this.idade = idade;
    perfil.atualizarPerfil(this);
  }

  public float getAltura() {
    return altura;
  }

  public void setAltura(float altura) {
    if (altura <= 0)
      throw new IllegalArgumentException("A altura deve ser um valor positivo.");

    this.altura = altura;
    perfil.atualizarPerfil(this);
  }

  public float getPeso() {
    return peso;
  }

  public void setPeso(float peso) {
    if (peso <= 0)
      throw new IllegalArgumentException("O peso deve ser um valor positivo.");
    this.peso = peso;
    perfil.atualizarPerfil(this);
  }

  public NivelAtividadeFisica getNivelAtividadeFisica() {
    return nivelAtividadeFisica;
  }

  public void setNivelAtividadeFisica(NivelAtividadeFisica nivelAtividadeFisica) {
    this.nivelAtividadeFisica = nivelAtividadeFisica;
  }

  @Override
  public String toString() {
    return """
        Pessoa:
          Nome: %s
          Idade: %d
          Gênero: %c
          Peso: %.2f
          Altura: %.2f
        Perfil:
          IMC: %.2
          """.formatted(nome, idade, genero, peso, altura, perfil.getImc());

  }
}
