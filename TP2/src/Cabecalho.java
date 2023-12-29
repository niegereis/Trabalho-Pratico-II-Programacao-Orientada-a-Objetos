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
    labelCarinha.setText("Carinha feliz!");
  }

  public void atualizarCarinhaParaTriste() {
    labelCarinha.setText("Carinha triste!");
  }

  public void atualizaLabelDoContador(int marcacoes) {
    String marcacoesStr = String.valueOf(marcacoes);
    if (marcacoes < 10)
      this.labelContador.setText("00" + marcacoesStr);
    else if (marcacoes < 100)
      this.labelContador.setText("0" + marcacoesStr);

  }

  public Cabecalho() {
    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    this.add(Box.createRigidArea(new Dimension(24, 0)));
    labelContador = new JLabel("000");
    labelContador.setFont(new Font("Aria", Font.BOLD, 20));
    this.add(labelContador);
    this.setAlignmentX(LEFT_ALIGNMENT);
    this.add(Box.createRigidArea(new Dimension(80, 0)));
    labelCarinha = new JLabel("Carinha normal!");
    this.add(labelCarinha);
  }
}
