package view.labels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TitleTextField extends JPanel implements FocusListener {
  private final JTextField textField;
  private final String placeholder;

  public TitleTextField(String titleText, String placeholder, int columns) {
    this.placeholder = placeholder;
    textField = new JTextField(columns);
    textField.setBackground(Color.WHITE);
    textField.setForeground(Color.GRAY);
    textField.setFont(new Font("Arial", Font.ITALIC, 15)); // Definindo a fonte como negrito e itálico
    textField.setText(placeholder);
    textField.setBorder(this.createBorder(titleText));
    textField.addFocusListener(this);
    add(textField);
    setVisible(true);
  }

  public String getText() {
    return textField.getText();
  }

  public void setText(String text) {
    textField.setText(text);
  }

  private Border createBorder(String labelText) {
    Border bor = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
        BorderFactory.createEmptyBorder(2, 2, 2, 2));
    Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 15); // Fonte negrito e itálico
    return BorderFactory.createTitledBorder(bor, labelText, 1, 1, font);
  }

  @Override
  public void focusGained(FocusEvent e) {
    if (textField.getText().equals(placeholder)) {
      textField.setText("");
      textField.setForeground(Color.BLACK);
    }
  }

  @Override
  public void focusLost(FocusEvent e) {
    if (textField.getText().isEmpty()) {
      textField.setForeground(Color.GRAY);
      textField.setText(placeholder);
    }
  }
}
