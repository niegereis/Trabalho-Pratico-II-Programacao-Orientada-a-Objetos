import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ManipuladorImagens {
  private static ImageIcon imagemBandeira;

  public static ImageIcon getImagemBandeira() {
    return imagemBandeira;
  }

  public static void carregarAssets() {
    imagemBandeira = carregaImagem("/TP2/src/assets/4.png");
  }

  private static ImageIcon carregaImagem(String caminhoImagem) {
    // try {
    Image img = (Image) Toolkit.getDefaultToolkit().getImage(caminhoImagem);
    // Image imagemRedimensionada = img.getScaledInstance(50, 50,
    // Image.SCALE_SMOOTH);
    return new ImageIcon(img);
    // } catch (IOException e) {
    // e.printStackTrace();
    // return null;
    // }
  }
}
