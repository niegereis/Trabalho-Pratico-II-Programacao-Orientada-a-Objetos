import java.awt.GridLayout;
import java.util.Random;
import java.util.function.Consumer;
import javax.swing.JPanel;

public class Tabuleiro extends JPanel {
  private Botao[][] tabuleiro = new Botao[9][9];
  private int contaMarcacoes = 0;

  private Consumer<Boolean> jogoFinalizou;

  public int getContaMarcacoes() {
    return this.contaMarcacoes;
  }

  private Consumer<Integer> atualizacaoDeContadorMarcacado;

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

  public Tabuleiro(Consumer<Integer> atualizacaoContadorDeMarcacao, Consumer<Boolean> jogoFinalizou) {
    this.setLayout(new GridLayout(9, 9));
    this.atualizacaoDeContadorMarcacado = atualizacaoContadorDeMarcacao;
    this.jogoFinalizou = jogoFinalizou;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        tabuleiro[i][j] = new Botao(b -> {
          this.abrirTabuleiro(b);
          this.jogoFinalizou.accept(false);
          return null;
        }, a -> {
          this.clicouEmBotaoVazio(a);
          return null;
        }, m -> {
          this.atualizarContadorMarcacao(m);
          return null;
        }, j, i, () -> {
          this.verificaVitoria();
        });
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

  private void verificaVitoria() {
    int contaBombas = 0;
    boolean somenteSemBombasAbertas = true;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (tabuleiro[i][j].getContemBomba() && tabuleiro[i][j].getMarcado())
          contaBombas++;
        else if (tabuleiro[i][j].getMarcado())
          contaBombas--;
        if (!(tabuleiro[i][j].getClicado() && !tabuleiro[i][j].getContemBomba()))
          somenteSemBombasAbertas = false;
        else if (!tabuleiro[i][j].getClicado() && !tabuleiro[i][j].getContemBomba()) {
          somenteSemBombasAbertas = false;
        }
      }
    }
    if (contaBombas == 10 || somenteSemBombasAbertas == true) {
      abrirTabuleiro(null);
      this.jogoFinalizou.accept(true);
    }
  }

  private void atualizarContadorMarcacao(Boolean m) {
    if (m)
      this.contaMarcacoes++;
    else
      this.contaMarcacoes--;
    atualizacaoDeContadorMarcacado.accept(this.contaMarcacoes);
  }
}
