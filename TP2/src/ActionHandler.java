import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class ActionHandler implements ActionListener {
  private JTextArea text;

  public ActionHandler(JTextArea textArea) {
    this.text = textArea;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println(this.text.getText());
  }

}
