package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import view.labels.TitleComboBox;
import view.labels.TitleTextField;

public class FormGUI extends JFrame {

  final private Container c;
  final private TitleTextField nome;
  final private TitleTextField idade;
  final private TitleTextField altura;
  final private TitleTextField peso;
  final private TitleComboBox genero;
  final private TitleComboBox nivelAtividadeFisica;
  final private JButton sub;
  public FormGUI() {
    setTitle("Form");
    setBounds(300, 90, 900, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setBackground(Color.WHITE);

    c = getContentPane();
    c.setLayout(null);

    nome = new TitleTextField("Nome", "Ex: João", 15);
    nome.setLayout(new FlowLayout(FlowLayout.LEFT));
    nome.setBounds(100, 80, 300, 55);
    nome.setBackground(Color.WHITE);
    c.add(nome);

    altura = new TitleTextField("Altura (cm)", "Ex: 1,81", 10);
    altura.setLayout(new FlowLayout(FlowLayout.LEFT));
    altura.setBounds(100, 135, 300, 55);
    altura.setBackground(Color.WHITE);
    c.add(altura);

    peso = new TitleTextField("Peso (kg)", "Ex: 75", 10);
    peso.setLayout(new FlowLayout(FlowLayout.LEFT));
    peso.setBounds(100, 190, 300, 55);
    peso.setBackground(Color.WHITE);
    c.add(peso);

    idade = new TitleTextField("Idade", "Ex: 19", 10);
    idade.setLayout(new FlowLayout(FlowLayout.LEFT));
    idade.setBounds(100, 245, 300, 55);
    idade.setBackground(Color.WHITE);
    c.add(idade);

    genero = new TitleComboBox("Gênero", new String[] { "Masculino", "Feminino" });
    genero.setLayout(new FlowLayout(FlowLayout.LEFT));
    genero.setBounds(100, 300, 300, 55);
    genero.setBackground(Color.WHITE);
    c.add(genero);

    nivelAtividadeFisica = new TitleComboBox("Nível de Atividade Física", new String[] { "Sedentário",
        "Levemente Ativo", "Moderadamente Ativo", "Altamente Ativo", "Extremamente Ativo" });
    nivelAtividadeFisica.setLayout(new FlowLayout(FlowLayout.LEFT));
    nivelAtividadeFisica.setBounds(100, 355, 300, 70);
    nivelAtividadeFisica.setBackground(Color.WHITE);
    c.add(nivelAtividadeFisica);

    sub = new JButton("Submit");
    sub.setFont(new Font("Arial", Font.PLAIN, 15));
    sub.setBounds(190, 430, 100, 30);
    sub.setBackground(Color.WHITE);
    c.add(sub);

    setVisible(true);
  }

  public static void main(String[] args) {
    new FormGUI();
  }
}
