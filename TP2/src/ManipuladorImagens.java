import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ManipuladorImagens {
  private static ImageIcon imagemBandeira;
  private static ImageIcon imagemCarinhaFeliz;
  private static ImageIcon imagemCarinhaTriste;
  private static ImageIcon imagemCarinhaNormal;
  private static ImageIcon imagemBombinha;

  public static ImageIcon getImagemCarinhaTriste() {
    return imagemCarinhaTriste;
  }

  public static ImageIcon getImagemCarinhaFeliz() {
    return imagemCarinhaFeliz;
  }

  public static ImageIcon getImagemCarinhaNormal() {
    return imagemCarinhaNormal;
  }

  public static ImageIcon getImagemBandeira() {
    return imagemBandeira;
  }

  public static ImageIcon getImagemBombinha() {
    return imagemBombinha;
  }

  public static void carregarAssets() {
    imagemCarinhaTriste = carregaImagem("/assets/1.png", 50, 50);
    imagemCarinhaNormal = carregaImagem("/assets/2.png", 50, 50);
    imagemCarinhaFeliz = carregaImagem("/assets/3.png", 50, 50);
    imagemBandeira = carregaImagem("/assets/4.png", 10, 45);
    imagemBombinha = carregaImagem("/assets/b.png", 30, 30);
  }

  private static ImageIcon carregaImagem(String caminhoImagem, int altura, int largura) {
    try {
      BufferedImage img = ImageIO.read(Objects.requireNonNull(ManipuladorImagens.class.getResource(caminhoImagem)));
      Image imagemRedimensionada = img.getScaledInstance(altura, largura, Image.SCALE_SMOOTH);
      return new ImageIcon(imagemRedimensionada);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
