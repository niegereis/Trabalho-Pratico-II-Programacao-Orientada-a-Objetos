import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class Jogo extends JPanel {
  public Jogo() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.weightx = 1;
    gbc.gridx = 1;
    this.setLayout(new GridBagLayout());
    Cabecalho cabecalho = new Cabecalho();

    Tabuleiro tabuleiro = new Tabuleiro(marcacoes -> {
      cabecalho.atualizaLabelDoContador(marcacoes.intValue());
    }, venceu -> {
      if (venceu)
        cabecalho.atualizarCarinhaParaFeliz();
      else
        cabecalho.atualizarCarinhaParaTriste();
    });
    gbc.gridy = 0;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.BOTH;
    this.add(cabecalho, gbc);
    gbc.gridy = 1;
    gbc.weighty = 9;
    gbc.fill = GridBagConstraints.BOTH;
    this.add(tabuleiro, gbc);
  }
}
