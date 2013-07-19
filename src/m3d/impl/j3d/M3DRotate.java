package m3d.impl.j3d;

import m3d.IM3DConstants;
import m3d.M3DContext;
import m3d.display.DisplayObject;
import m3d.model.M3DHiddenFaces;
import m3d.model.elem.Rectangle;
import m3d.ops.IM3DRotate;

public class M3DRotate implements IM3DRotate {

    private M3DContext context;

    public M3DRotate (M3DContext co) {
        this.context = co;
    }

    @Override
    public void rotate (final int axe, final double angle, final int i) {
        M3DContext t = this.context;
        Class<?> clazz;
        try {
            clazz = Class.forName ("m3d.impl.j3d.display.Display"
                    + t.m3DCGetType (i));
            final DisplayObject dO = (DisplayObject) clazz.newInstance ();
            dO.rotate (t, axe, angle, i);
        } catch (final ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (final InstantiationException e) {
            e.printStackTrace ();
        } catch (final IllegalAccessException e) {
            e.printStackTrace ();
        }
    }

    @Override
    public void rotateHF (final int axe, final double angle, final int i) {
        M3DContext t = this.context;
        M3DHiddenFaces h = t.getHiddenFaces ();
        final Rectangle r = h.get (i).getRectangle ();
        if (axe == IM3DConstants.M3DAXEX) {
            final double a = r.y, b = h.get (i).getZ1 (), c = r.y + r.height, d = h
                    .get (i).getZ2 ();
            r.setY1 (Math.sin (angle) * (b - t.getPosz ()) + Math.cos (angle)
                    * (a - t.getPosy ()) + t.getPosy ());
            h.get (i).setZ1 (
                    -Math.sin (angle) * (a - t.getPosy ()) + Math.cos (angle)
                            * (b - t.getPosz ()) + t.getPosz ());
            r.setY2 (Math.sin (angle) * (d - t.getPosz ()) + Math.cos (angle)
                    * (c - t.getPosy ()) + t.getPosy ());
            h.get (i).setZ2 (
                    -Math.sin (angle) * (c - t.getPosy ()) + Math.cos (angle)
                            * (d - t.getPosz ()) + t.getPosz ());
        }
        if (axe == IM3DConstants.M3DAXEY) {
            final double a = r.x, b = h.get (i).getZ1 (), c = r.x + r.width, d = h
                    .get (i).getZ2 ();
            r.setX1 (-Math.sin (angle) * (b - t.getPosz ()) + Math.cos (angle)
                    * (a - t.getPosx ()) + t.getPosx ());
            h.get (i).setZ1 (
                    Math.sin (angle) * (a - t.getPosx ()) + Math.cos (angle)
                            * (b - t.getPosz ()) + t.getPosz ());
            r.setX2 (-Math.sin (angle) * (d - t.getPosz ()) + Math.cos (angle)
                    * (c - t.getPosx ()) + t.getPosx ());
            h.get (i).setZ2 (
                    Math.sin (angle) * (c - t.getPosx ()) + Math.cos (angle)
                            * (d - t.getPosz ()) + t.getPosz ());
        }
        if (axe == IM3DConstants.M3DAXEZ) {
            final double a = r.x, b = r.y, c = r.x + r.width, d = r.y
                    + r.height;
            r.setX1 (Math.sin (angle) * (b - t.getPosy ()) + Math.cos (angle)
                    * (a - t.getPosx ()) + t.getPosx ());
            r.setY1 (-Math.sin (angle) * (a - t.getPosx ()) + Math.cos (angle)
                    * (b - t.getPosy ()) + t.getPosy ());
            r.setX2 (Math.sin (angle) * (d - t.getPosy ()) + Math.cos (angle)
                    * (c - t.getPosx ()) + t.getPosx ());
            r.setY2 (-Math.sin (angle) * (c - t.getPosx ()) + Math.cos (angle)
                    * (d - t.getPosy ()) + t.getPosy ());
        }
    }
}
