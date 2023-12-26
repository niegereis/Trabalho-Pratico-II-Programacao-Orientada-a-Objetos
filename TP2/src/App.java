import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class App {

    public static void main(String[] args) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        JFrame frame = new JFrame("Ejemplo - Java Swing");
        frame.setSize(500, 300);

        JPanel panel = new JPanel();
        panel.setSize(300, 300);

        panel.setLayout(new GridBagLayout());

        JLabel label = new JLabel();
        label.setText("Digite: ");

        JTextArea textArea = new JTextArea(5, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);
        gbc.gridy = 1;
        panel.add(textArea, gbc);
        JButton button = new JButton("Botão");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textArea.getText());
            }
        });
        button.addActionListener(e -> {
            System.out.println(textArea.getText());
            label.setText("Foi digitado algo...");
            textArea.setVisible(false);
            button.setVisible(false);
        });

        gbc.gridy = 2;
        panel.add(button, gbc);
        frame.add(panel);
        frame.setVisible(true);
    }
}
