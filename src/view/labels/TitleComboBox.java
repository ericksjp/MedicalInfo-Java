package view.labels;

import java.awt.Color;
import java.awt.Font;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TitleComboBox extends JPanel {
  private final JComboBox<String> comboBox;

  public TitleComboBox(String titleText, String[] items) {
    comboBox = new JComboBox<>(items);
    comboBox.setBackground(Color.WHITE);
    comboBox.setFont(new Font("Arial", Font.PLAIN, 15));
    comboBox.setSelectedIndex(0);
    comboBox.setBorder(this.createBorder(titleText));
    setVisible(true);
    add(comboBox);
  }

  public String getText() {
    return Objects.requireNonNull(comboBox.getSelectedItem()).toString();
  }

  private Border createBorder(String labelText) {
    Border bor = BorderFactory.createEmptyBorder(0, 0, 0, 0);
    Font font = new Font("Arial", Font.PLAIN, 12).deriveFont(Font.BOLD);
    return BorderFactory.createTitledBorder(bor, labelText, 1, 1, font);
  }
}
