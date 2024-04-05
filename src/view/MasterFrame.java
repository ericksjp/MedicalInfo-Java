
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import enums.NivelAtividadeFisica;
import model.Pessoa;
import utils.PParser;
import view.labels.TitleComboBox;
import view.labels.TitleTextField;

public class MasterFrame extends JFrame implements ActionListener {

  final private Container c;
  final private TitleTextField nome;
  final private TitleTextField idade;
  final private TitleTextField altura;
  final private TitleTextField peso;
  final private TitleComboBox genero;
  final private TitleComboBox nivelAtividadeFisica;
  final private JButton sub;
  final private JTextArea resadd;
  final private JButton saveCSV;
  final private JButton saveTXT;
  private Pessoa pessoa;

  public MasterFrame() {
    setTitle("Form");
    setBounds(300, 90, 1000, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setBackground(Color.WHITE);

    c = getContentPane();
    c.setLayout(null);

    nome = new TitleTextField("Nome", "Ex: João", 15);
    nome.setLayout(new FlowLayout(FlowLayout.LEFT));
    nome.setBounds(50, 80, 300, 55);
    nome.setBackground(Color.WHITE);
    nome.requestFocusInWindow();
    nome.requestFocus();
    c.add(nome);

    altura = new TitleTextField("Altura (cm)", "Ex: 181", 10);
    altura.setLayout(new FlowLayout(FlowLayout.LEFT));
    altura.setBounds(50, 135, 300, 55);
    altura.setBackground(Color.WHITE);
    c.add(altura);

    peso = new TitleTextField("Peso (kg)", "Ex: 75", 10);
    peso.setLayout(new FlowLayout(FlowLayout.LEFT));
    peso.setBounds(50, 190, 300, 55);
    peso.setBackground(Color.WHITE);
    c.add(peso);

    idade = new TitleTextField("Idade", "Ex: 19", 10);
    idade.setLayout(new FlowLayout(FlowLayout.LEFT));
    idade.setBounds(50, 245, 300, 55);
    idade.setBackground(Color.WHITE);
    c.add(idade);

    genero = new TitleComboBox("Gênero", new String[] { "Masculino", "Feminino" });
    genero.setLayout(new FlowLayout(FlowLayout.LEFT));
    genero.setBounds(50, 300, 300, 55);
    genero.setBackground(Color.WHITE);
    c.add(genero);

    nivelAtividadeFisica = new TitleComboBox("Nível de Atividade Física", new String[] { "Sedentário",
        "Levemente Ativo", "Moderadamente Ativo", "Altamente Ativo", "Extremamente Ativo" });
    nivelAtividadeFisica.setLayout(new FlowLayout(FlowLayout.LEFT));
    nivelAtividadeFisica.setBounds(50, 355, 300, 70);
    nivelAtividadeFisica.setBackground(Color.WHITE);
    c.add(nivelAtividadeFisica);

    sub = new JButton("Submit");
    sub.setFont(new Font("Arial", Font.PLAIN, 15));
    sub.setBounds(140, 430, 100, 30);
    sub.setBackground(Color.WHITE);
    sub.addActionListener(this);
    c.add(sub);

    saveCSV = new JButton("SaveCSV");
    saveCSV.setFont(new Font("Arial", Font.PLAIN, 15));
    saveCSV.setBounds(850, 495, 100, 30);
    saveCSV.setBackground(Color.WHITE);
    saveCSV.addActionListener(this);
    saveCSV.setEnabled(false);
    c.add(saveCSV);

    saveTXT = new JButton("SaveTXT");
    saveTXT.setFont(new Font("Arial", Font.PLAIN, 15));
    saveTXT.setBounds(735, 495, 100, 30);
    saveTXT.setBackground(Color.WHITE);
    saveTXT.addActionListener(this);
    saveTXT.setEnabled(false);
    c.add(saveTXT);

    resadd = new JTextArea();
    resadd.setFont(new Font("Arial", Font.PLAIN, 18));
    resadd.setBounds(450, 50, 500, 440);
    resadd.setLineWrap(true);
    resadd.setEditable(false);
    resadd.setFocusable(false);
    c.add(resadd);

    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == sub) {
      try {
        Object[] info = parseInfo();
        pessoa = new Pessoa((String) info[0], (char) info[1], (int) info[2], (float) info[3], (float) info[4],
            (NivelAtividadeFisica) info[5]);

        resadd.setFocusable(true);
        resadd.setText("\n" + PParser.formatPerfilToTXTFileType(pessoa.getPerfil()));
        saveCSV.setEnabled(true);
        saveTXT.setEnabled(true);
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
      }
    } else if (e.getSource() == saveCSV) {
      String texto = PParser.formatPessoaPerfilToCSVType(pessoa);
      salvarDadosEmArquivo(texto);
    } else if (e.getSource() == saveTXT) {
      String texto = PParser.formatPessoaPerfilToTXTFileType(pessoa);
      salvarDadosEmArquivo(texto);
    }
  }

  private Object[] parseInfo() {
    Object[] info = new Object[6];
    if (nome.getText().isEmpty())
      throw new IllegalArgumentException("O nome não pode ser vazio.");
    if (nome.getText().length() > 40)
      throw new IllegalArgumentException("O nome deve ter no máximo 40 caracteres.");

    info[0] = nome.getText();
    info[1] = genero.getText().charAt(0);

    try {
      info[2] = Integer.parseInt(idade.getText());
      if ((int) info[2] < 0)
        throw new IllegalArgumentException("A idade deve ser um valor positivo.");
      else if ((int) info[2] > 120)
        throw new IllegalArgumentException("A idade deve ser menor que 120 anos.");
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("A idade deve ser um número inteiro.");
    }

    try {
      info[3] = Float.parseFloat(altura.getText().replace(",", "."));
      if ((float) info[3] <= 0)
        throw new IllegalArgumentException("A altura deve ser um valor positivo.");
      else if ((float) info[3] > 250)
        throw new IllegalArgumentException("A altura deve ser menor que 250 cm.");
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("A altura deve ser um número real.");
    }

    try {
      info[4] = Float.parseFloat(peso.getText().replace(",", "."));
      if ((float) info[4] <= 0)
        throw new IllegalArgumentException("O peso deve ser um valor positivo.");
      else if ((float) info[4] > 300)
        throw new IllegalArgumentException("O peso deve ser menor que 300 kg.");
      Float.parseFloat(peso.getText().replace(",", "."));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("O peso deve ser um número real.");
    }

    info[5] = NivelAtividadeFisica.getNivelAtividadeFisica(nivelAtividadeFisica.getText());

    return info;
  }

  private void salvarDadosEmArquivo(String texto) {
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showSaveDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      try (PrintWriter writer = new PrintWriter(file)) {
        writer.println(texto);
        JOptionPane.showMessageDialog(this, "Dados salvos com sucesso em " + file.getAbsolutePath());
      } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo: " + ex.getMessage());
      }
    }
  }
}
