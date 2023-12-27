import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Campo minado");
            frame.setSize(450, 600);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setLayout(new GridBagLayout());

            JPanel painel = new JPanel();
            painel.setLayout(new GridBagLayout());

            // boolean clicado = false;
            Botao botao = new Botao(false);
            botao.setQtdBombas(5);

            painel.add(botao);
            frame.add(painel);
        });
    }
}