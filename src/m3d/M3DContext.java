package m3d;

import m3d.model.M3DArea;
import m3d.model.M3DHiddenFaces;
import m3d.model.M3DMatrix;
import m3d.model.elem.Rectangle;
import m3d.objects.M3DObject;

public class M3DContext {
    private boolean              actif;
    private final M3DHiddenFaces h;
    private final M3D            m3d;
    private final M3DMatrix      matrice;
    private double               ox, oy, oz;
    private double               posx, posy, posz;
    private Rectangle            rect;
    private double               rotx, roty, rotz;

    public M3DContext (final M3D m3d, final int x, final int y, final int h,
            final int w) {
        this.actif = true;
        this.h = new M3DHiddenFaces ();
        this.matrice = new M3DMatrix ();
        this.rect = new Rectangle ();
        this.ox = 0;
        this.oy = 0;
        this.oz = 0;
        this.rotx = 0;
        this.roty = 0;
        this.rotz = 0;
        this.rotx = 0;
        this.roty = 0;
        this.rotz = 0;
        this.m3d = m3d;
        this.rect.setRect (x, y, h, w);
    }

    public double getOx () {
        return this.ox;
    }

    public double getOy () {
        return this.oy;
    }

    public double getOz () {
        return this.oz;
    }

    public double getPosx () {
        return this.posx;
    }

    public double getPosy () {
        return this.posy;
    }

    public double getPosz () {
        return this.posz;
    }

    public Rectangle getRect () {
        return this.rect;
    }

    public double getRotx () {
        return this.rotx;
    }

    public double getRoty () {
        return this.roty;
    }

    public double getRotz () {
        return this.rotz;
    }

    public boolean isActif () {
        return this.actif;
    }

    public void m3DCDelObject (final int idMo) {
        this.matrice.m3DMDelObject (idMo);
    }

    public int m3DCGenObject (final M3DObject mo) {
        int id = 0;
        final double posxtmp = this.posx;
        final double posytmp = this.posy;
        final double posztmp = this.posz;
        final double rotxtmp = this.rotx;
        final double rotytmp = this.roty;
        final double rotztmp = this.rotz;
        final double oxtmp = this.ox;
        final double oytmp = this.oy;
        final double oztmp = this.oz;

        this.m3d.tourner (IM3DConstants.M3DAXEX, -rotxtmp);
        this.m3d.tourner (IM3DConstants.M3DAXEY, -rotytmp);
        this.m3d.tourner (IM3DConstants.M3DAXEZ, -rotztmp);
        this.m3d.deplacer (-oxtmp, -oytmp, -oztmp, IM3DConstants.M3DRELAT);
        this.m3d.bouger (-this.posx, -this.posy, -this.posz,
                IM3DConstants.M3DRELAT);
        this.posx = 0;
        this.posy = 0;
        this.posz = 0;

        id = this.matrice.m3DMGenObject (mo);

        this.posx = posxtmp;
        this.posy = posytmp;
        this.posz = posztmp;
        this.m3d.bouger (this.posx, this.posy, this.posz,
                IM3DConstants.M3DRELAT);
        this.m3d.deplacer (oxtmp, oytmp, oztmp, IM3DConstants.M3DRELAT);
        this.m3d.tourner (IM3DConstants.M3DAXEZ, rotztmp);
        this.m3d.tourner (IM3DConstants.M3DAXEY, rotytmp);
        this.m3d.tourner (IM3DConstants.M3DAXEX, rotxtmp);
        return id;
    }

    public double m3DCGet (final int i, final int j) {
        return this.matrice.m3DMGet (i, j);
    }

    public Object m3DCGetMisc (final int i, final int j) {
        return this.matrice.m3DMGetMisc (i, j);
    }

    public int m3DCGetNb (final int i) {
        return this.matrice.m3DMGetNb (i);
    }

    public String m3DCGetType (final int i) {
        return this.matrice.m3DMGetType (i);
    }

    public void m3DCSet (final int i, final int j, final double v) {
        this.matrice.m3DMSet (i, j, v);
    }

    public int m3DCSize () {
        return this.matrice.m3DMSize ();
    }

    public void setActif () {
        this.actif = true;
    }

    public void setInactif () {
        this.actif = false;
    }

    public void setOx (final double ox) {
        this.ox = ox;
    }

    public void setOy (final double oy) {
        this.oy = oy;
    }

    public void setOz (final double oz) {
        this.oz = oz;
    }

    public void setPosx (final double posx) {
        this.posx = posx;
    }

    public void setPosy (final double posy) {
        this.posy = posy;
    }

    public void setPosz (final double posz) {
        this.posz = posz;
    }

    public void setRect (final int x, final int y, final int w, final int h) {
        this.rect.setRect (x, y, w, h);
    }

    public void setRect (final Rectangle rect) {
        this.rect = rect;
    }

    public void setRotx (final double rotx) {
        this.rotx = rotx;
    }

    public void setRoty (final double roty) {
        this.roty = roty;
    }

    public void setRotz (final double rotz) {
        this.rotz = rotz;
    }

    public M3D getOwner () {
        return this.m3d;
    }

    public void addHiddenFace (M3DArea ma) {
        this.h.add (ma);
    }

    public M3DHiddenFaces getHiddenFaces () {
        return this.h;
    }
}
