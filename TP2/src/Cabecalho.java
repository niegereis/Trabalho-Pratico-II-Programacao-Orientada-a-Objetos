import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cabecalho extends JPanel {
  private JLabel labelContador;
  private JLabel labelCarinha;

  public void atualizarCarinhaParaFeliz() {
    labelCarinha.setIcon(ManipuladorImagens.getImagemCarinhaFeliz());
  }

  public void atualizarCarinhaParaTriste() {
    labelCarinha.setIcon(ManipuladorImagens.getImagemCarinhaTriste());
  }

  public void atualizarCarinhaParaNormal() {
    labelCarinha.setIcon(ManipuladorImagens.getImagemCarinhaNormal());
  }

  public void atualizaLabelDoContador(int marcacoes) {
    String marcacoesStr = String.valueOf(marcacoes);
    if (marcacoes < 10)
      this.labelContador.setText("00" + marcacoesStr);
    else if (marcacoes < 100)
      this.labelContador.setText("0" + marcacoesStr);
  }

  public Cabecalho() {
    labelCarinha = new JLabel();
    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    this.add(Box.createRigidArea(new Dimension(24, 0)));
    labelContador = new JLabel("000");
    labelContador.setFont(new Font("Aria", Font.BOLD, 20));
    this.add(labelContador);
    this.setAlignmentX(LEFT_ALIGNMENT);
    this.add(Box.createRigidArea(new Dimension(80, 0)));
    atualizarCarinhaParaNormal();
    this.add(labelCarinha);
  }
}
