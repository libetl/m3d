package m3d.impl.awt;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import m3d.M3D;
import m3d.IM3DConstants;
import m3d.canvas.IM3DCanvas;
import m3d.model.elem.Point3D;
import m3d.model.elem.Rectangle;
import m3d.model.elem.Rectangle3D;

public class AwtM3DCanvas implements IM3DCanvas {

    private final ActionListener aADroite      = new ActionListener () {
                                                   @Override
                                                public void actionPerformed (
                                                           final ActionEvent e) {
                                                       AwtM3DCanvas.this.m3D
                                                               .deplacer (
                                                                       0.1,
                                                                       0.0,
                                                                       0.0,
                                                                       IM3DConstants.M3DRELAT);
                                                       AwtM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };
    private final ActionListener aAGauche      = new ActionListener () {
                                                   @Override
                                                public void actionPerformed (
                                                           final ActionEvent e) {
                                                       AwtM3DCanvas.this.m3D
                                                               .deplacer (
                                                                       -0.1,
                                                                       0.0,
                                                                       0.0,
                                                                       IM3DConstants.M3DRELAT);
                                                       AwtM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };
    private final ActionListener avancer       = new ActionListener () {

                                                   @Override
                                                public void actionPerformed (
                                                           final ActionEvent e) {
                                                       AwtM3DCanvas.this.m3D
                                                               .deplacer (
                                                                       0.0,
                                                                       0.0,
                                                                       0.1,
                                                                       IM3DConstants.M3DRELAT);
                                                       AwtM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };
    private final ActionListener chXd          = new ActionListener () {

                                                   @Override
                                                public void actionPerformed (
                                                           final ActionEvent e) {
                                                       AwtM3DCanvas.this.m3D
                                                               .tourner (
                                                                       IM3DConstants.M3DAXEZ,
                                                                       0.01);
                                                       AwtM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };
    private final ActionListener chXg          = new ActionListener () {

                                                   @Override
                                                public void actionPerformed (
                                                           final ActionEvent e) {
                                                       AwtM3DCanvas.this.m3D
                                                               .tourner (
                                                                       IM3DConstants.M3DAXEZ,
                                                                       -0.01);
                                                       AwtM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };

                                               private final ActionListener tXb           = new ActionListener () {

                                                   @Override
                                                public void actionPerformed (
                                                           final ActionEvent e) {
                                                       AwtM3DCanvas.this.m3D
                                                               .tourner (
                                                                       IM3DConstants.M3DAXEX,
                                                                       -0.01);
                                                       AwtM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };

    private final ActionListener tXd           = new ActionListener () {

                                                   @Override
                                                public void actionPerformed (
                                                           final ActionEvent e) {
                                                       AwtM3DCanvas.this.m3D
                                                               .tourner (
                                                                       IM3DConstants.M3DAXEY,
                                                                       0.01);
                                                       AwtM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };
    private final ActionListener tXg           = new ActionListener () {

                                                   @Override
                                                public void actionPerformed (
                                                           final ActionEvent e) {
                                                       AwtM3DCanvas.this.m3D
                                                               .tourner (
                                                                       IM3DConstants.M3DAXEY,
                                                                       -0.01);
                                                       AwtM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };

    private final ActionListener tXh           = new ActionListener () {

                                                   @Override
                                                public void actionPerformed (
                                                           final ActionEvent e) {
                                                       AwtM3DCanvas.this.m3D
                                                               .tourner (
                                                                       IM3DConstants.M3DAXEX,
                                                                       0.01);
                                                       AwtM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };

    private Graphics             g;
    public KeyListener           kl            = new KeyListener () {

                                                   @Override
                                                public void keyPressed (
                                                           final KeyEvent e) {
                                                       switch (e.getKeyCode ()) {
                                                       case KeyEvent.VK_UP :
                                                           AwtM3DCanvas.this.tAvancer
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_DOWN :
                                                           AwtM3DCanvas.this.tReculer
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_LEFT :
                                                           AwtM3DCanvas.this.taAGauche
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_RIGHT :
                                                           AwtM3DCanvas.this.taADroite
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_F :
                                                           AwtM3DCanvas.this.tChXg
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_H :
                                                           AwtM3DCanvas.this.tChXd
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_A :
                                                           AwtM3DCanvas.this.tTXg
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_P :
                                                           AwtM3DCanvas.this.tTXd
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_T :
                                                           AwtM3DCanvas.this.tTXh
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_V :
                                                           AwtM3DCanvas.this.tTXb
                                                                   .start ();
                                                           break;
                                                       default :
                                                           break;
                                                       }
                                                   }

                                                   @Override
                                                public void keyReleased (
                                                           final KeyEvent e) {
                                                       switch (e.getKeyCode ()) {
                                                       case KeyEvent.VK_UP :
                                                           AwtM3DCanvas.this.tAvancer
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_DOWN :
                                                           AwtM3DCanvas.this.tReculer
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_LEFT :
                                                           AwtM3DCanvas.this.taAGauche
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_RIGHT :
                                                           AwtM3DCanvas.this.taADroite
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_F :
                                                           AwtM3DCanvas.this.tChXg
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_H :
                                                           AwtM3DCanvas.this.tChXd
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_A :
                                                           AwtM3DCanvas.this.tTXg
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_P :
                                                           AwtM3DCanvas.this.tTXd
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_T :
                                                           AwtM3DCanvas.this.tTXh
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_V :
                                                           AwtM3DCanvas.this.tTXb
                                                                   .stop ();
                                                           break;
                                                       default :
                                                           break;
                                                       }
                                                   }

                                                   @Override
                                                public void keyTyped (
                                                           final KeyEvent e) {
                                                   }
                                               };

    private final M3D            m3D;
    private final Canvas         object;

    private final Timer          rafraichir;
    private final ActionListener reculer       = new ActionListener () {

                                                   @Override
                                                public void actionPerformed (
                                                           final ActionEvent e) {
                                                       AwtM3DCanvas.this.m3D
                                                               .deplacer (
                                                                       0.0,
                                                                       0.0,
                                                                       -0.1,
                                                                       IM3DConstants.M3DRELAT);
                                                       AwtM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };

    private final Timer          taADroite     = new Timer (10, this.aADroite);
    private final Timer          taAGauche     = new Timer (10, this.aAGauche);

    private final ActionListener taskPerformer = new ActionListener () {

                                                   @Override
                                                public void actionPerformed (
                                                           final ActionEvent e) {
                                                       AwtM3DCanvas.this.m3D
                                                               .afficher ();
                                                   }
                                               };
    private final Timer          tAvancer      = new Timer (10, this.avancer);

    private final Timer          tChXd         = new Timer (10, this.chXd);
    private final Timer          tChXg         = new Timer (10, this.chXg);

    private final Timer          tReculer      = new Timer (10, this.reculer);
    private final Timer          tTXb          = new Timer (10, this.tXb);

    private final Timer          tTXd          = new Timer (10, this.tXd);
    private final Timer          tTXg          = new Timer (10, this.tXg);

    private final Timer          tTXh          = new Timer (10, this.tXh);

    public AwtM3DCanvas (final M3D m3D, final Rectangle r) {
        super ();
        this.m3D = m3D;
        this.object = new Canvas ();
        this.object.setBounds ((int) r.x, (int) r.y, (int) r.width,
                (int) r.height);
        this.object.addKeyListener (this.kl);
        this.g = this.object.getGraphics ();
        this.rafraichir = new Timer (1, this.taskPerformer);
        this.rafraichir.start ();
    }

    @Override
    public void stop () {
        this.rafraichir.stop ();
    }

    @Override
    public void start () {
        this.rafraichir.start ();
    }

    @Override
    public void erase () {
        this.g = this.object.getGraphics ();
        this.object.update (this.g);
    }

    @Override
    public Object getImpl () {
        return this.object;
    }

    public void tLine (final int a, final int b, final int c, final int d) {
        this.g.drawLine (a, b, c, d);
    }

    @Override
    public void tLine (final Point3D [] lp) {
        final Graphics g = this.object.getGraphics ();
        if (g != null) {
            g.drawLine ((int) lp [0].getX (), (int) lp [0].getY (),
                    (int) lp [1].getX (), (int) lp [1].getY ());
        }
    }

    @Override
    public void tPolygon (final Point3D [] lp2) {
        if (this.g != null) {

            for (int i = 0 ; i < lp2.length - 1 ; i++) {
                this.g.drawLine ((int) lp2 [i].getX (), (int) lp2 [i].getY (),
                        (int) lp2 [i + 1].getX (), (int) lp2 [i + 1].getY ());
            }
            this.g.drawLine ((int) lp2 [lp2.length - 1].getX (),
                    (int) lp2 [lp2.length - 1].getY (), (int) lp2 [0].getX (),
                    (int) lp2 [0].getY ());
        }

    }

    @Override
    public void tRect (final Rectangle3D rc) {
        this.g.drawRect ((int) rc.getX (), (int) rc.getY (), (int) rc.getX ()
                + (int) rc.getWidth (),
                (int) rc.getY () + (int) rc.getHeight ());
    }

    @Override
    public void tText (final Point3D point, final String get) {
        if (this.g != null) {
            this.g.drawChars (get.toCharArray (), 0, get.length (),
                    (int) point.getX (), (int) point.getY ());
        }
    }

}
