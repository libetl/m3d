package m3d.impl.awt.display;

import m3d.IM3DConstants;
import m3d.M3DContext;
import m3d.canvas.IM3DCanvas;
import m3d.display.DisplayObject;
import m3d.impl.awt.M3DConvertor;
import m3d.model.elem.Point3D;

public class DisplayPolygon extends DisplayObject {

    @Override
    public void display (final IM3DCanvas a, final M3DContext t, final int i) {
        int j, k;
        for (j = 0 ; j < t.m3DCGetNb (i) / 3 - 1 ; j++) {
            final Point3D [] lp2 = new Point3D [2];
            lp2 [0] = new Point3D ();
            lp2 [1] = new Point3D ();
            k = 3 * j;
            lp2 [0].setLocation (
                    M3DConvertor.formuleX (t.m3DCGet (i, k),
                            t.m3DCGet (i, k + 2), t),
                    M3DConvertor.formuleY (t.m3DCGet (i, k + 1),
                            t.m3DCGet (i, k + 2), t));
            k += 3;
            lp2 [1].setLocation (
                    M3DConvertor.formuleX (t.m3DCGet (i, k),
                            t.m3DCGet (i, k + 2), t),
                    M3DConvertor.formuleY (t.m3DCGet (i, k + 1),
                            t.m3DCGet (i, k + 2), t));
            k += 3;
            if ( ( (t.m3DCGet (i, 2 + 3 * j) - t.getPosz () >= 0) || (t
                    .m3DCGet (i, 5 + 3 * j) - t.getPosz () >= 0))
                    && ( ( (lp2 [0].getY () >= 0) && (lp2 [0].getX () >= 0)) || ( (lp2 [1]
                            .getY () >= 0) && (lp2 [1].getX () >= 0)))) {
                a.tLine (lp2);
            }
        }
    }

    @Override
    public void rotate (final M3DContext t, final int axe, final double angle,
            final int i) {
        for (int j = 0 ; j < t.m3DCGetNb (i) / 3 ; j++) {
            if (axe == IM3DConstants.M3DAXEX) {
                final double a = t.m3DCGet (i, 3 * j + 1), b = t.m3DCGet (i,
                        3 * j + 2);
                t.m3DCSet (i, 3 * j + 1, Math.sin (angle) * (b - t.getPosz ())
                        + Math.cos (angle) * (a - t.getPosy ()) + t.getPosy ());
                t.m3DCSet (i, 3 * j + 2, -Math.sin (angle) * (a - t.getPosy ())
                        + Math.cos (angle) * (b - t.getPosz ()) + t.getPosz ());
            }
            if (axe == IM3DConstants.M3DAXEY) {
                final double a = t.m3DCGet (i, 3 * j), b = t.m3DCGet (i,
                        3 * j + 2);
                t.m3DCSet (i, 3 * j, -Math.sin (angle) * (b - t.getPosz ())
                        + Math.cos (angle) * (a - t.getPosx ()) + t.getPosx ());
                t.m3DCSet (i, 3 * j + 2, Math.sin (angle) * (a - t.getPosx ())
                        + Math.cos (angle) * (b - t.getPosz ()) + t.getPosz ());
            }
            if (axe == IM3DConstants.M3DAXEZ) {
                final double a = t.m3DCGet (i, 3 * j), b = t.m3DCGet (i,
                        3 * j + 1);
                t.m3DCSet (i, 3 * j, Math.sin (angle) * (b - t.getPosy ())
                        + Math.cos (angle) * (a - t.getPosx ()) + t.getPosx ());
                t.m3DCSet (i, 3 * j + 1, -Math.sin (angle) * (a - t.getPosx ())
                        + Math.cos (angle) * (b - t.getPosy ()) + t.getPosy ());
            }
        }
    }

    @Override
    public void translate (final M3DContext t, final double x, final double y,
            final double z, final int mode, final int i) {
        final double ix = t.m3DCGet (i, 0);
        final double iy = t.m3DCGet (i, 1);
        final double iz = t.m3DCGet (i, 2);
        for (int j = 0 ; j < t.m3DCGetNb (i) / 3 ; j++) {
            if (mode == IM3DConstants.M3DABSOL) {
                final double dx = t.m3DCGet (i, 3 * j) - ix;
                final double dy = t.m3DCGet (i, 3 * j + 1) - iy;
                final double dz = t.m3DCGet (i, 3 * j + 2) - iz;
                t.m3DCSet (i, 3 * j, x + dx);
                t.m3DCSet (i, 3 * j + 1, y + dy);
                t.m3DCSet (i, 3 * j + 2, z + dz);
            } else {
                t.m3DCSet (i, 3 * j, t.m3DCGet (i, 3 * j) + x);
                t.m3DCSet (i, 3 * j + 1, t.m3DCGet (i, 3 * j + 1) + y);
                t.m3DCSet (i, 3 * j + 2, t.m3DCGet (i, 3 * j + 2) + z);
            }
        }

    }

}
