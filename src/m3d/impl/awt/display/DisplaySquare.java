package m3d.impl.awt.display;

import m3d.IM3DConstants;
import m3d.M3DContext;
import m3d.canvas.IM3DCanvas;
import m3d.display.DisplayObject;
import m3d.impl.awt.M3DConvertor;
import m3d.model.elem.Point3D;

public class DisplaySquare extends DisplayObject {

    @Override
    public void display (final IM3DCanvas a, final M3DContext t, final int i) {
        if ( ( (t.m3DCGet (i, 2) - t.getPosz () > 0) || (t.m3DCGet (i, 5)
                - t.getPosz () > 0))) {
            final Point3D [] lp2 = new Point3D [4];
            for (int l = 0 ; l < 4 ; l++) {
                lp2 [l] = new Point3D ();
            }
            lp2 [0].setLocation (M3DConvertor.formuleX (t.m3DCGet (i, 0),
                    t.m3DCGet (i, 2), t), M3DConvertor.formuleY (
                    t.m3DCGet (i, 1), t.m3DCGet (i, 2), t));
            lp2 [1].setLocation (M3DConvertor.formuleX (t.m3DCGet (i, 3),
                    t.m3DCGet (i, 5), t), M3DConvertor.formuleY (
                    t.m3DCGet (i, 1), t.m3DCGet (i, 5), t));
            lp2 [2].setLocation (lp2 [1].getX (), (M3DConvertor.formuleY (
                    t.m3DCGet (i, 4), t.m3DCGet (i, 5), t)));
            lp2 [3].setLocation (lp2 [0].getX (), M3DConvertor.formuleY (
                    t.m3DCGet (i, 4), t.m3DCGet (i, 2), t));
            a.tPolygon (lp2);
        }
    }

    @Override
    public void rotate (final M3DContext t, final int axe, final double angle,
            final int i) {
        if (axe == IM3DConstants.M3DAXEX) {
            final double a = t.m3DCGet (i, 1), b = t.m3DCGet (i, 2), c = t
                    .m3DCGet (i, 4), d = t.m3DCGet (i, 5);
            t.m3DCSet (i, 1,
                    Math.sin (angle) * (b - t.getPosz ()) + Math.cos (angle)
                            * (a - t.getPosy ()) + t.getPosy ());
            t.m3DCSet (i, 2,
                    -Math.sin (angle) * (a - t.getPosy ()) + Math.cos (angle)
                            * (b - t.getPosz ()) + t.getPosz ());
            t.m3DCSet (i, 4,
                    Math.sin (angle) * (d - t.getPosz ()) + Math.cos (angle)
                            * (c - t.getPosy ()) + t.getPosy ());
            t.m3DCSet (i, 5,
                    -Math.sin (angle) * (c - t.getPosy ()) + Math.cos (angle)
                            * (d - t.getPosz ()) + t.getPosz ());
        }
        if (axe == IM3DConstants.M3DAXEY) {
            final double a = t.m3DCGet (i, 0), b = t.m3DCGet (i, 2), c = t
                    .m3DCGet (i, 3), d = t.m3DCGet (i, 5);
            t.m3DCSet (i, 0,
                    -Math.sin (angle) * (b - t.getPosz ()) + Math.cos (angle)
                            * (a - t.getPosx ()) + t.getPosx ());
            t.m3DCSet (i, 2,
                    Math.sin (angle) * (a - t.getPosx ()) + Math.cos (angle)
                            * (b - t.getPosz ()) + t.getPosz ());
            t.m3DCSet (i, 3,
                    -Math.sin (angle) * (d - t.getPosz ()) + Math.cos (angle)
                            * (c - t.getPosx ()) + t.getPosx ());
            t.m3DCSet (i, 5,
                    Math.sin (angle) * (c - t.getPosx ()) + Math.cos (angle)
                            * (d - t.getPosz ()) + t.getPosz ());
        }
        if (axe == IM3DConstants.M3DAXEZ) {
            final double a = t.m3DCGet (i, 0), b = t.m3DCGet (i, 1), c = t
                    .m3DCGet (i, 3), d = t.m3DCGet (i, 4);
            t.m3DCSet (i, 0,
                    Math.sin (angle) * (b - t.getPosy ()) + Math.cos (angle)
                            * (a - t.getPosx ()) + t.getPosx ());
            t.m3DCSet (i, 1,
                    -Math.sin (angle) * (a - t.getPosx ()) + Math.cos (angle)
                            * (b - t.getPosy ()) + t.getPosy ());
            t.m3DCSet (i, 3,
                    Math.sin (angle) * (d - t.getPosy ()) + Math.cos (angle)
                            * (c - t.getPosx ()) + t.getPosx ());
            t.m3DCSet (i, 4,
                    -Math.sin (angle) * (c - t.getPosx ()) + Math.cos (angle)
                            * (d - t.getPosy ()) + t.getPosy ());
        }
    }

    @Override
    public void translate (final M3DContext t, final double x, final double y,
            final double z, final int mode, final int i) {
        final double tailleX = t.m3DCGet (i, 3) - t.m3DCGet (i, 0);
        final double tailleY = t.m3DCGet (i, 4) - t.m3DCGet (i, 1);
        final double tailleZ = t.m3DCGet (i, 5) - t.m3DCGet (i, 2);
        if (mode == IM3DConstants.M3DABSOL) {
            t.m3DCSet (i, 0, x);
            t.m3DCSet (i, 1, y);
            t.m3DCSet (i, 2, z);
            t.m3DCSet (i, 3, x + tailleX);
            t.m3DCSet (i, 4, y + tailleY);
            t.m3DCSet (i, 5, z + tailleZ);
        } else {
            t.m3DCSet (i, 0, t.m3DCGet (i, 0) + x);
            t.m3DCSet (i, 1, t.m3DCGet (i, 1) + y);
            t.m3DCSet (i, 2, t.m3DCGet (i, 2) + z);
            t.m3DCSet (i, 3, t.m3DCGet (i, 3) + x);
            t.m3DCSet (i, 4, t.m3DCGet (i, 4) + y);
            t.m3DCSet (i, 5, t.m3DCGet (i, 5) + z);
        }
    }

}
