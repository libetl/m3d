package m3d;

import m3d.canvas.IM3DCanvas;
import m3d.impl.IM3DProxy;
import m3d.impl.M3DProxyFinder;
import m3d.model.M3DArea;
import m3d.model.elem.Rectangle;
import m3d.objects.M3DObject;

public class M3D {

    private M3DContext      t;
    private final IM3DProxy proxy;

    public M3D (final String techno, final int w, final int h) {
        this.t = new M3DContext (this, 0, 0, w, h);
        this.proxy = M3DProxyFinder.build (techno, this.t);
    }

    public void afficher () {
        if (!this.t.isActif ()) {
            return;
        }
        for (int i = 0 ; i < this.t.m3DCSize () ; i++) {
            this.proxy.getRenderer ().display (i);
        }
    }

    public void ajoutFaceCachee (final M3DArea ma) {
        this.t.addHiddenFace (ma);
    }

    public void arret3D () {
        this.proxy.getRenderer ().stop ();
    }

    public void bouger (final double x, final double y, final double z,
            final int mode) {
        for (int i = 0 ; i < this.t.m3DCSize () ; i++) {
            this.proxy.getTranslate ().translate (x, y, z, mode, i);
        }
    }

    public void demarrer3D () {
        this.proxy.getRenderer ().start ();
    }

    public void deplacer (final double x, final double y, final double z,
            final int mode) {
        this.proxy.getTranslate ().translate (x, y, z, mode);
    }

    public void effacer () {
        this.proxy.getRenderer ().erase ();
    }

    public void generate (final M3DObject mo) {
        this.t.m3DCGenObject (mo);
    }

    public void purger (final Double w, final Double h) {
        this.t = new M3DContext (this, 0, 0, w.intValue (), h.intValue ());
    }

    public void purger (final int w, final int h) {
        this.t = new M3DContext (this, 0, 0, w, h);
    }

    public void redimensionner (final Rectangle r) {
        this.t.getRect ().setRect (r.getX (), r.getY (), r.getWidth (),
                r.getHeight ());
        this.afficher ();
    }

    public void remove (final Double idMo) {
        this.t.m3DCDelObject (idMo.intValue ());
    }

    public void remove (final int idMo) {
        this.t.m3DCDelObject (idMo);
    }

    public void tourner (final int axe, final double angle) {
        int i;
        if (axe == IM3DConstants.M3DAXEX) {
            this.t.setRotx (this.t.getRotx () + angle);
        } else if (axe == IM3DConstants.M3DAXEY) {
            this.t.setRoty (this.t.getRoty () + angle);
        } else if (axe == IM3DConstants.M3DAXEZ) {
            this.t.setRotz (this.t.getRotz () + angle);
        }
        for (i = 0 ; i < this.t.m3DCSize () ; i++) {
            this.proxy.getRotate ().rotate (axe, angle, i);
        }
        for (i = 0 ; i < this.t.getHiddenFaces ().size () ; i++) {
            this.proxy.getRotate ().rotateHF (axe, angle, i);
        }
    }

    public IM3DCanvas getGraphicalContext () {
        return this.proxy.getCanvas ();
    }
    
    
}