import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ManipuladorImagens.carregarAssets();
            JFrame frame = new JFrame("Campo minado");
            frame.setSize(500, 600);
            frame.setResizable(false);
            frame.add(new Jogo());
            frame.setVisible(true);
        });
    }
}