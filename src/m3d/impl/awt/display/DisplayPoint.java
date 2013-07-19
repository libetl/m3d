package m3d.impl.awt.display;

import m3d.IM3DConstants;
import m3d.M3DContext;
import m3d.canvas.IM3DCanvas;
import m3d.display.DisplayObject;
import m3d.impl.awt.M3DConvertor;
import m3d.impl.awt.M3DHiddenFacesEvaluator;
import m3d.model.M3DHiddenFaces;
import m3d.model.elem.Point3D;

public class DisplayPoint extends DisplayObject {

    @Override
    public void display (final IM3DCanvas a, final M3DContext t, final int i) {

        final M3DHiddenFaces h = t.getHiddenFaces ();
        final Point3D [] lp = new Point3D [2];
        if ( (t.m3DCGet (i, 2) - t.getPosz () > 0)
                && (t.m3DCGet (i, 2) - t.getPosz () < 40)
                && M3DHiddenFacesEvaluator.isDisplayable (h, t.m3DCGet (i, 0),
                        t.m3DCGet (i, 1), t.m3DCGet (i, 2), t.getPosx (), t
                                .getPosy (), t.getPosz (), t.getRect ()
                                .getWidth (), t.getRect ().getHeight ())) {
            lp [0] = new Point3D ();
            lp [1] = new Point3D ();
            lp [0].setLocation (M3DConvertor.formuleX (t.m3DCGet (i, 0),
                    t.m3DCGet (i, 2), t), M3DConvertor.formuleY (
                    t.m3DCGet (i, 1), t.m3DCGet (i, 2), t));
            lp [1].setLocation (M3DConvertor.formuleX (t.m3DCGet (i, 0),
                    t.m3DCGet (i, 2), t) + 1, M3DConvertor.formuleY (
                    t.m3DCGet (i, 1), t.m3DCGet (i, 2), t) + 1);
            a.tLine (lp);
        }
    }

    @Override
    public void rotate (final M3DContext t, final int axe, final double angle,
            final int i) {
        if (axe == IM3DConstants.M3DAXEX) {
            final double a = t.m3DCGet (i, 1), b = t.m3DCGet (i, 2);
            t.m3DCSet (i, 1,
                    Math.sin (angle) * (b - t.getPosz ()) + Math.cos (angle)
                            * (a - t.getPosy ()) + t.getPosy ());
            t.m3DCSet (i, 2,
                    -Math.sin (angle) * (a - t.getPosy ()) + Math.cos (angle)
                            * (b - t.getPosz ()) + t.getPosz ());
        }
        if (axe == IM3DConstants.M3DAXEY) {
            final double a = t.m3DCGet (i, 0), b = t.m3DCGet (i, 2);
            t.m3DCSet (i, 0,
                    -Math.sin (angle) * (b - t.getPosz ()) + Math.cos (angle)
                            * (a - t.getPosx ()) + t.getPosx ());
            t.m3DCSet (i, 2,
                    Math.sin (angle) * (a - t.getPosx ()) + Math.cos (angle)
                            * (b - t.getPosz ()) + t.getPosz ());
        }
        if (axe == IM3DConstants.M3DAXEZ) {
            final double a = t.m3DCGet (i, 0), b = t.m3DCGet (i, 1);
            t.m3DCSet (i, 0,
                    Math.sin (angle) * (b - t.getPosy ()) + Math.cos (angle)
                            * (a - t.getPosx ()) + t.getPosx ());
            t.m3DCSet (i, 1,
                    -Math.sin (angle) * (a - t.getPosx ()) + Math.cos (angle)
                            * (b - t.getPosy ()) + t.getPosy ());
        }
    }

    @Override
    public void translate (final M3DContext t, final double x, final double y,
            final double z, final int mode, final int i) {
        if (mode == IM3DConstants.M3DABSOL) {
            t.m3DCSet (i, 0, x);
            t.m3DCSet (i, 1, y);
            t.m3DCSet (i, 2, z);
        } else {
            t.m3DCSet (i, 0, t.m3DCGet (i, 0) + x);
            t.m3DCSet (i, 1, t.m3DCGet (i, 1) + y);
            t.m3DCSet (i, 2, t.m3DCGet (i, 2) + z);
        }
    }

}
