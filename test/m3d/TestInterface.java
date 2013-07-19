package m3d;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.io.PrintStream;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import m3d.model.elem.Point3D;
import m3d.objects.M3DLine;
import m3d.objects.M3DPolygon;
import m3d.objects.M3DText;

public class TestInterface {
  public static void main (final String[] args) {
    /*
     * System.setProperty ("java.library.path", System.getProperty
     * ("java.library.path") + ":" + System.getProperty ("user.dir") +
     * "/i386/"); System.out.print (System.getProperty ("java.library.path"));
     */

    javax.swing.SwingUtilities.invokeLater (new Runnable () {
      public void run () {
        new TestInterface (true, null).play ();
      }
    });
  }

  public Container   c;
  public JTextField  jtf;
  public M3D         m;

  public PrintStream sysout = System.out;

  public TestInterface (final boolean buildContainer, final Container o) {
    if (buildContainer) {
      this.c = new JFrame ();
    } else {
      this.c = o;
    }
  }

  public void play () {

    this.m = new M3D ("awt", 420, 300);
    this.jtf = new JTextField (30);
    this.m.generate (new M3DLine (0, 0, 0, 0, 0, 0.5));
    this.m.generate (new M3DLine (0, 0, 0, 0, -0.5, 0));
    this.m.generate (new M3DLine (0, 0, 0, 0.5, 0, 0));

    this.m.generate (new M3DText (0.0, 0.0, 0.53, "x"));
    this.m.generate (new M3DText (0.0, -0.5, 0.03, "y"));
    this.m.generate (new M3DText (0.5, 0.0, -0.03, "z"));

    this.m.generate (new M3DLine (0.02, 0.0, 0.45, 0, 0, 0.5));
    this.m.generate (new M3DLine (-0.02, 0.0, 0.45, 0, 0, 0.5));

    this.m.generate (new M3DLine (0, -0.02, 0.45, 0, 0, 0.5));
    this.m.generate (new M3DLine (0, 0.02, 0.45, 0, 0, 0.5));

    this.m.generate (new M3DLine (-0.02, -0.45, 0, 0, -0.5, 0));
    this.m.generate (new M3DLine (0.02, -0.45, 0, 0, -0.5, 0));

    this.m.generate (new M3DLine (0, -0.45, -0.02, 0, -0.5, 0));
    this.m.generate (new M3DLine (0, -0.45, 0.02, 0, -0.5, 0));

    this.m.generate (new M3DLine (0.45, 0.0, -0.02, 0.5, 0, 0));
    this.m.generate (new M3DLine (0.45, 0.0, 0.02, 0.5, 0, 0));

    this.m.generate (new M3DLine (0.45, -0.02, 0, 0.5, 0, 0));
    this.m.generate (new M3DLine (0.45, 0.02, 0, 0.5, 0, 0));

    this.m.generate (new M3DPolygon (new Point3D (-0.02, -0.02, 0.45),
        new Point3D (0.02, -0.02, 0.45), new Point3D (0.02, 0.02, 0.45),
        new Point3D (-0.02, 0.02, 0.45), new Point3D (-0.02, -0.02, 0.45)));

    this.m.generate (new M3DPolygon (new Point3D (-0.02, -0.45, -0.02),
        new Point3D (0.02, -0.45, -0.02), new Point3D (0.02, -0.45, 0.02),
        new Point3D (-0.02, -0.45, 0.02), new Point3D (-0.02, -0.45, -0.02)));

    this.m.generate (new M3DPolygon (new Point3D (0.45, -0.02, -0.02),
        new Point3D (0.45, 0.02, -0.02), new Point3D (0.45, 0.02, 0.02),
        new Point3D (0.45, -0.02, 0.02), new Point3D (0.45, -0.02, -0.02)));
    final JPanel boite3D = new JPanel ();
    boite3D.add ((Canvas) this.m.getGraphicalContext ().getImpl ());
    boite3D.setPreferredSize (new Dimension (420, 360));

    final JPanel boiteTexte = new JPanel ();
    final JButton jb = new JButton ("OK");
    this.jtf.setPreferredSize (new Dimension (360, 20));
    jb.setPreferredSize (new Dimension (60, 20));
    boiteTexte.setLayout (new BoxLayout (boiteTexte, BoxLayout.X_AXIS));
    boiteTexte.add (this.jtf);
    boiteTexte.add (jb);
    boiteTexte.setPreferredSize (new Dimension (420, 20));

    jb.addMouseListener (new CommandeValiderMouseListener (this.m, this.jtf,
        this));

    if (this.c instanceof JFrame) {
      this.c.setLayout (new BoxLayout (((JFrame) this.c).getContentPane (),
          BoxLayout.Y_AXIS));
    } else if (this.c instanceof Applet) {
      this.c.setLayout (new BoxLayout (this.c, BoxLayout.Y_AXIS));
    }
    this.c.add (boite3D);
    this.c.add (boiteTexte);
    this.c.setPreferredSize (new Dimension (420, 380));
    if (this.c instanceof JFrame) {
      ((JFrame) this.c).pack ();
      ((JFrame) this.c).setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }

    this.m.demarrer3D ();
    this.m.deplacer (0, -0.5, -3, IM3DConstants.M3DRELAT);
    this.c.setVisible (true);
  }
}
