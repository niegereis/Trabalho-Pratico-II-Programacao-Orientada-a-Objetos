import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;

public class Tabuleiro extends JPanel {
  private Botao[][] tabuleiro = new Botao[9][9];

  private void abrirTabuleiro(Botao b) {
    for (Botao[] linha : tabuleiro) {
      for (Botao botao : linha) {
        botao.click();
      }
    }
  }

  private void clicouEmBotaoVazio(Botao b) {
    if (b.contemBombasPerto())
      return;
    if (b.getClicado())
      return;
    b.click();
    int posYCima = b.getPosY() - 1;
    if (posYCima >= 0) {
      Botao acima = tabuleiro[posYCima][b.getPosX()];
      clicouEmBotaoVazio(acima);
    }
    int posYBaixo = b.getPosY() + 1;
    if (posYBaixo <= 8) {
      Botao baixo = tabuleiro[posYBaixo][b.getPosX()];
      clicouEmBotaoVazio(baixo);
    }
    int posXDireita = b.getPosX() + 1;
    if (posXDireita <= 8) {
      Botao direita = tabuleiro[b.getPosY()][posXDireita];
      clicouEmBotaoVazio(direita);
    }
    int posXEsquerda = b.getPosX() - 1;
    if (posXEsquerda >= 0) {
      Botao esquerda = tabuleiro[b.getPosY()][posXEsquerda];
      clicouEmBotaoVazio(esquerda);
    }
  }

  public Tabuleiro() {
    this.setLayout(new GridLayout(9, 9));
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        tabuleiro[i][j] = new Botao(b -> {
          this.abrirTabuleiro(b);
          return null;
        }, a -> {
          this.clicouEmBotaoVazio(a);
          return null;
        }, j, i);
        this.add(tabuleiro[i][j]);
      }
    }

    int qtdMaxBombas = 10;
    while (qtdMaxBombas > 0) {
      int x = new Random().nextInt(9);
      int y = new Random().nextInt(9);
      if (tabuleiro[x][y].getContemBomba()) {
        continue;
      } else {
        tabuleiro[x][y].setContemBomba(true);
        qtdMaxBombas--;
      }
    }

    for (int x = 0; x < 9; x++) {
      for (int y = 0; y < 9; y++) {
        for (int i = x - 1; i <= x + 1; i++) {
          for (int j = y - 1; j <= y + 1; j++) {
            if (!(i >= 0 && i <= 8 && j >= 0 && j <= 8))
              continue;
            if (tabuleiro[i][j].getContemBomba())
              tabuleiro[x][y].incrementaQtdBombas();
          }
        }
      }
    }
  }
}
