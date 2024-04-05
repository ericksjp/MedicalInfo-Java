package enums;

public enum NivelAtividadeFisica {
  SEDENTARIO("Sedentário"),
  LEVEMENTE_ATIVO("Levemente Ativo"),
  MODERADAMENTE_ATIVO("Moderadamente Ativo"),
  ALTAMENTE_ATIVO("Altamente Ativo"),
  EXTREMAMENTE_ATIVO("Extremamente Ativo");

  private final String descricao;

  NivelAtividadeFisica(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

  public static NivelAtividadeFisica getNivelAtividadeFisica(String descricao) {
    for (NivelAtividadeFisica nivel : NivelAtividadeFisica.values()) {
      if (nivel.getDescricao().equals(descricao)) {
        return nivel;
      }
    }
    return null;
  }
}
