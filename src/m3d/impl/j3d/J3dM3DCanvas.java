package m3d.impl.j3d;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Font3D;
import javax.media.j3d.FontExtrusion;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.Group;
import javax.media.j3d.LineArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Text3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.Timer;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;

import m3d.M3D;
import m3d.IM3DConstants;
import m3d.canvas.IM3DCanvas;
import m3d.model.elem.Point3D;
import m3d.model.elem.Rectangle;
import m3d.model.elem.Rectangle3D;

import com.sun.j3d.utils.universe.SimpleUniverse;

public class J3dM3DCanvas implements IM3DCanvas {

    private final ActionListener aADroite      = new ActionListener () {
                                                   @Override
                                                   public void actionPerformed (
                                                           final ActionEvent e) {
                                                       Transform3D torig = new Transform3D ();
                                                       Transform3D t = new Transform3D ();
                                                       Vector3d v = new Vector3d ();
                                                       J3dM3DCanvas.this.camera
                                                               .getTransform (torig);
                                                       t.get (v);
                                                       v.x -= 0.1;
                                                       t.set (v);
                                                       t.mul (torig);
                                                       J3dM3DCanvas.this.camera.setTransform (t);

                                                       J3dM3DCanvas.this.m3D
                                                               .deplacer (
                                                                       0.1,
                                                                       0.0,
                                                                       0.0,
                                                                       IM3DConstants.M3DRELAT);
                                                       J3dM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };
    private final ActionListener aAGauche      = new ActionListener () {
                                                   @Override
                                                   public void actionPerformed (
                                                           final ActionEvent e) {
                                                       Transform3D torig = new Transform3D ();
                                                       Transform3D t = new Transform3D ();
                                                       Vector3d v = new Vector3d ();
                                                       J3dM3DCanvas.this.camera
                                                               .getTransform (torig);
                                                       t.get (v);
                                                       v.x += 0.1;
                                                       t.set (v);
                                                       t.mul (torig);
                                                       J3dM3DCanvas.this.camera.setTransform (t);

                                                       J3dM3DCanvas.this.m3D
                                                               .deplacer (
                                                                       -0.1,
                                                                       0.0,
                                                                       0.0,
                                                                       IM3DConstants.M3DRELAT);
                                                       J3dM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };
    private final Appearance     appBlanc;
    private final ActionListener reculer       = new ActionListener () {
                                                   @Override
                                                   public void actionPerformed (
                                                           final ActionEvent e) {
                                                       Transform3D torig = new Transform3D ();
                                                       Transform3D t = new Transform3D ();
                                                       Vector3d v = new Vector3d ();
                                                       J3dM3DCanvas.this.camera
                                                               .getTransform (torig);
                                                       t.get (v);
                                                       v.z -= 0.1;
                                                       t.set (v);
                                                       t.mul (torig);
                                                       J3dM3DCanvas.this.camera.setTransform (t);
                                                       J3dM3DCanvas.this.m3D
                                                               .deplacer (
                                                                       0.0,
                                                                       0.0,
                                                                       -0.1,
                                                                       IM3DConstants.M3DRELAT);
                                                       J3dM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };

    private final ActionListener avancer       = new ActionListener () {
                                                   @Override
                                                   public void actionPerformed (
                                                           final ActionEvent e) {
                                                       Transform3D torig = new Transform3D ();
                                                       Transform3D t = new Transform3D ();
                                                       Vector3d v = new Vector3d ();
                                                       J3dM3DCanvas.this.camera
                                                               .getTransform (torig);
                                                       t.get (v);
                                                       v.z += 0.1;
                                                       t.set (v);
                                                       t.mul (torig);
                                                       J3dM3DCanvas.this.camera.setTransform (t);
                                                       J3dM3DCanvas.this.m3D
                                                               .deplacer (
                                                                       0.0,
                                                                       0.0,
                                                                       0.1,
                                                                       IM3DConstants.M3DRELAT);
                                                       J3dM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };
    private final ActionListener chXd          = new ActionListener () {
                                                   @Override
                                                   public void actionPerformed (
                                                           final ActionEvent e) {
                                                       Transform3D t = new Transform3D ();
                                                       Transform3D torig = new Transform3D ();
                                                       J3dM3DCanvas.this.camera
                                                               .getTransform (torig);
                                                       t.rotZ (0.01);
                                                       t.mul (torig);
                                                       J3dM3DCanvas.this.camera.setTransform (t);
                                                       J3dM3DCanvas.this.m3D
                                                               .tourner (
                                                                       IM3DConstants.M3DAXEZ,
                                                                       0.01);
                                                       J3dM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };
    private final ActionListener chXg          = new ActionListener () {
                                                   @Override
                                                   public void actionPerformed (
                                                           final ActionEvent e) {
                                                       Transform3D t = new Transform3D ();
                                                       Transform3D torig = new Transform3D ();
                                                       J3dM3DCanvas.this.camera
                                                               .getTransform (torig);
                                                       t.rotZ (-0.01);
                                                       t.mul (torig);
                                                       J3dM3DCanvas.this.camera.setTransform (t);
                                                       J3dM3DCanvas.this.m3D
                                                               .tourner (
                                                                       IM3DConstants.M3DAXEZ,
                                                                       -0.01);
                                                       J3dM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };
                                               private final ActionListener tXb           = new ActionListener () {
                                                   @Override
                                                   public void actionPerformed (
                                                           final ActionEvent e) {
                                                       Transform3D t = new Transform3D ();
                                                       Transform3D torig = new Transform3D ();
                                                       J3dM3DCanvas.this.camera
                                                               .getTransform (torig);
                                                       t.rotX (0.01);
                                                       t.mul (torig);
                                                       J3dM3DCanvas.this.camera.setTransform (t);
                                                       J3dM3DCanvas.this.m3D
                                                               .tourner (
                                                                       IM3DConstants.M3DAXEX,
                                                                       -0.01);
                                                       J3dM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };
    private final ActionListener tXd           = new ActionListener () {
                                                   @Override
                                                   public void actionPerformed (
                                                           final ActionEvent e) {
                                                       Transform3D t = new Transform3D ();
                                                       Transform3D torig = new Transform3D ();
                                                       J3dM3DCanvas.this.camera
                                                               .getTransform (torig);
                                                       t.rotY (0.01);
                                                       t.mul (torig);
                                                       J3dM3DCanvas.this.camera.setTransform (t);
                                                       J3dM3DCanvas.this.m3D
                                                               .tourner (
                                                                       IM3DConstants.M3DAXEY,
                                                                       0.01);
                                                       J3dM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };

    private final ActionListener tXg           = new ActionListener () {
                                                   @Override
                                                   public void actionPerformed (
                                                           final ActionEvent e) {
                                                       Transform3D t = new Transform3D ();
                                                       Transform3D torig = new Transform3D ();
                                                       J3dM3DCanvas.this.camera
                                                               .getTransform (torig);
                                                       t.rotY (-0.01);
                                                       t.mul (torig);
                                                       J3dM3DCanvas.this.camera.setTransform (t);
                                                       J3dM3DCanvas.this.m3D
                                                               .tourner (
                                                                       IM3DConstants.M3DAXEY,
                                                                       -0.01);
                                                       J3dM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };
    private final ActionListener tXh           = new ActionListener () {
                                                   @Override
                                                   public void actionPerformed (
                                                           final ActionEvent e) {
                                                       Transform3D t = new Transform3D ();
                                                       Transform3D torig = new Transform3D ();
                                                       J3dM3DCanvas.this.camera
                                                               .getTransform (torig);
                                                       t.rotX (-0.01);
                                                       t.mul (torig);
                                                       J3dM3DCanvas.this.camera.setTransform (t);
                                                       J3dM3DCanvas.this.m3D
                                                               .tourner (
                                                                       IM3DConstants.M3DAXEX,
                                                                       0.01);
                                                       J3dM3DCanvas.this
                                                               .erase ();
                                                   }
                                               };
                                               
    private BranchGroup          group;

    public KeyListener           kl            = new KeyListener () {

                                                   @Override
                                                   public void keyPressed (
                                                           final KeyEvent e) {
                                                       switch (e.getKeyCode ()) {
                                                       case KeyEvent.VK_UP :
                                                           J3dM3DCanvas.this.tAvancer
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_DOWN :
                                                           J3dM3DCanvas.this.tReculer
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_LEFT :
                                                           J3dM3DCanvas.this.taAGauche
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_RIGHT :
                                                           J3dM3DCanvas.this.taADroite
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_F :
                                                           J3dM3DCanvas.this.tChXg
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_H :
                                                           J3dM3DCanvas.this.tChXd
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_A :
                                                           J3dM3DCanvas.this.tTXg
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_P :
                                                           J3dM3DCanvas.this.tTXd
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_T :
                                                           J3dM3DCanvas.this.tTXh
                                                                   .start ();
                                                           break;
                                                       case KeyEvent.VK_V :
                                                           J3dM3DCanvas.this.tTXb
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
                                                           J3dM3DCanvas.this.tAvancer
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_DOWN :
                                                           J3dM3DCanvas.this.tReculer
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_LEFT :
                                                           J3dM3DCanvas.this.taAGauche
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_RIGHT :
                                                           J3dM3DCanvas.this.taADroite
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_F :
                                                           J3dM3DCanvas.this.tChXg
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_H :
                                                           J3dM3DCanvas.this.tChXd
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_A :
                                                           J3dM3DCanvas.this.tTXg
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_P :
                                                           J3dM3DCanvas.this.tTXd
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_T :
                                                           J3dM3DCanvas.this.tTXh
                                                                   .stop ();
                                                           break;
                                                       case KeyEvent.VK_V :
                                                           J3dM3DCanvas.this.tTXb
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

    private BranchGroup          monde;
    private final Canvas3D       object;

    private final Timer          taADroite     = new Timer (10, this.aADroite);

    private final Timer          taAGauche     = new Timer (10, this.aAGauche);
    private final ActionListener taskPerformer = new ActionListener () {
                                                   @Override
                                                   public void actionPerformed (
                                                           final ActionEvent e) {
                                                       J3dM3DCanvas.this.m3D
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

    private SimpleUniverse       univers;
    private TransformGroup       camera;

    public J3dM3DCanvas (final M3D m3D, final Rectangle r) {
        this.m3D = m3D;

        this.object = new Canvas3D (SimpleUniverse.getPreferredConfiguration ());
        this.object.setPreferredSize (new Dimension ((int) r.width,
                (int) r.height));
        this.appBlanc = new Appearance ();
        final ColoringAttributes blanc = new ColoringAttributes ();
        blanc.setColor (1.0f, 1.0f, 1.0f);
        blanc.setShadeModel (ColoringAttributes.NICEST);
        this.object.addKeyListener (this.kl);
        this.appBlanc.setColoringAttributes (blanc);
        Timer timer;
        timer = new Timer (10, this.taskPerformer);
        timer.setInitialDelay (1000);
        timer.start ();

    }

    @Override
    public void stop () {

    }

    @Override
    public void start () {

        this.camera = new TransformGroup ();
        this.monde = new BranchGroup ();
        this.group = new BranchGroup ();
        this.monde.setCapability (Group.ALLOW_CHILDREN_READ);
        this.monde.setCapability (Group.ALLOW_CHILDREN_WRITE);
        this.monde.setCapability (Group.ALLOW_CHILDREN_EXTEND);
        this.group.setCapability (Group.ALLOW_CHILDREN_READ);
        this.group.setCapability (Group.ALLOW_CHILDREN_WRITE);
        this.group.setCapability (Group.ALLOW_CHILDREN_EXTEND);
        this.camera.setCapability (TransformGroup.ALLOW_TRANSFORM_READ);
        this.camera.setCapability (TransformGroup.ALLOW_TRANSFORM_WRITE);
        this.univers = new SimpleUniverse (this.object);
        this.monde.addChild (this.camera);
        this.camera.addChild (this.group);
        this.univers.addBranchGraph (this.monde);
        this.univers.getViewingPlatform ().setNominalViewingTransform ();
        this.univers.getViewer ().getView ().setFrontClipDistance (0.01);

    }

    @Override
    public void erase () {
        this.object.startRenderer ();

    }

    @Override
    public Object getImpl () {
        return object;
    }

    @Override
    public void tLine (final Point3D [] lp) {

        final LineArray la = new LineArray (2, GeometryArray.COORDINATES);
        la.setCoordinate (0, new float [] { (float) lp [0].getX (),
                (float) lp [0].getY (), (float) lp [0].getZ () });
        la.setCoordinate (1, new float [] { (float) lp [1].getX (),
                (float) lp [1].getY (), (float) lp [1].getZ () });
        final Shape3D line = new Shape3D (la, this.appBlanc);
        final BranchGroup bg = new BranchGroup ();
        bg.addChild (line);
        this.group.addChild (bg);

    }

    @Override
    public void tPolygon (final Point3D [] lp2) {

    }

    @Override
    public void tRect (final Rectangle3D rc) {

    }

    @Override
    public void tText (final Point3D point, final String get) {

        final Font3D myFont = new Font3D (
                new Font ("Helvetica", Font.PLAIN, 1), new FontExtrusion ());

        final Text3D textGeom = new Text3D (myFont, get, new Point3f (
                new Point3f ( (get.length () / 10), (float) (3.0),
                        (float) (10.5))));
        final Shape3D text = new Shape3D (textGeom, this.appBlanc);
        final BranchGroup bg = new BranchGroup ();
        bg.addChild (text);
        this.group.addChild (bg);

    }

}
