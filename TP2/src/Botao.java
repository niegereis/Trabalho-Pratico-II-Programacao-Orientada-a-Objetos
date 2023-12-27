import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Botao extends JButton implements MouseListener {
  private boolean clicado = false;
  private boolean contemBomba;
  private int qtdBombas = 0;
  private JLabel texto;

  public void setQtdBombas(int qtdBombas) {
    this.qtdBombas = qtdBombas;
  }

  public Botao(boolean contemBomba) {
    this.setPreferredSize(new Dimension(30, 30));
    this.addMouseListener(this);
    this.contemBomba = contemBomba;

    texto = new JLabel();
    texto.setFont(new Font("Arial", Font.PLAIN, 24));
    texto.setForeground(Color.WHITE);
  }

  // Botão esquerdo = 1 e Botão direito = 3
  @Override
  public void mouseClicked(MouseEvent e) {
    System.out.println(e.getButton());
    if (e.getButton() == 1) {
      this.setEnabled(false);
      clicado = true;
      if (contemBomba) {
        this.setBackground(Color.RED);
        // acabar o jogo
      } else if (qtdBombas > 0) {

        texto.setText("5");
        this.setBackground(Color.BLUE);
        this.add(texto);
      } else if (qtdBombas == 0) {
        // abrir o tabuleiro até encontrar botao com bombas próximas
      }

    } else if (e.getButton() == 3) {

    } else {
      System.out.println("Botão não permitido no jogo!");
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }
}
