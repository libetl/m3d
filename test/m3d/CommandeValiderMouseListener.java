package m3d;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

public class CommandeValiderMouseListener implements MouseListener {

  private final JTextField    jtf;
  private final TestInterface ti;

  public CommandeValiderMouseListener (final M3D m, final JTextField jtf,
      final TestInterface ti) {
    this.jtf = jtf;
    this.ti = ti;
  }

  public void mouseClicked (final MouseEvent e) {
    final String text = this.jtf.getText ();
    ExecuteInstruction.execute (text, this.ti);
  }

  public void mouseEntered (final MouseEvent e) {

  }

  public void mouseExited (final MouseEvent e) {

  }

  public void mousePressed (final MouseEvent e) {

  }

  public void mouseReleased (final MouseEvent e) {

  }

}
