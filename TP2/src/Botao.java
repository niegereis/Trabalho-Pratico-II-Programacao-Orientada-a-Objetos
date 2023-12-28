import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Function;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Botao extends JButton implements MouseListener {
  private boolean contemBomba;
  private boolean clicado = false;
  private boolean marcado = false;
  private int qtdBombas = 0;
  private final int posX, posY;
  private JLabel texto;
  private Function<Botao, Void> clicouEmBomba;
  private Function<Botao, Void> clicouEmBotaoVazio;

  public boolean getClicado() {
    return this.clicado;
  }

  public int getPosX() {
    return this.posX;
  }

  public int getPosY() {
    return this.posY;
  }

  public boolean contemBombasPerto() {
    return this.qtdBombas > 0;
  }

  public void setQtdBombas(int qtdBombas) {
    this.qtdBombas = qtdBombas;
  }

  public void incrementaQtdBombas() {
    this.qtdBombas++;
  }

  public void setContemBomba(boolean cb) {
    this.contemBomba = cb;
    if (cb)
      this.setBackground(Color.PINK);
  }

  public boolean getContemBomba() {
    return this.contemBomba;
  }

  public Botao(Function<Botao, Void> clicouEmBomba, Function<Botao, Void> clicouEmBotaoVazio, int x, int y) {
    this.addMouseListener(this);
    this.clicouEmBomba = clicouEmBomba;
    this.clicouEmBotaoVazio = clicouEmBotaoVazio;
    this.posX = x;
    this.posY = y;

    texto = new JLabel();
    texto.setFont(new Font("Arial", Font.PLAIN, 20));
    texto.setForeground(Color.BLACK);
    this.add(texto);
  }

  // Botão esquerdo = 1 e Botão direito = 3
  @Override
  public void mouseClicked(MouseEvent e) {
    System.out.println(e.getButton());
    if (e.getButton() == 1 && !this.marcado) {
      if (contemBomba) {
        clicouEmBomba.apply(this);
      } else if (qtdBombas == 0) {
        clicouEmBotaoVazio.apply(this);
      }
      click();
    } else if (e.getButton() == 3 && !this.clicado) {
      if (this.marcado) {
        this.marcado = false;
        if (contemBomba) {
          this.setBackground(Color.PINK);
        } else {
          this.setBackground(null);
        }
      } else {
        this.marcado = true;
        this.setBackground(Color.ORANGE);
      }
    } else {
      System.out.println("Botão não permitido no jogo!");
    }
  }

  public void click() {
    this.setEnabled(false);
    this.clicado = true;
    if (contemBomba) {
      this.setBackground(Color.RED);
    } else if (qtdBombas > 0) {
      this.setBackground(Color.BLUE);
      texto.setText(String.valueOf(qtdBombas));
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
