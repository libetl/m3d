package m3d.impl.j3d.display;

import m3d.M3DContext;
import m3d.canvas.IM3DCanvas;
import m3d.display.DisplayObject;
import m3d.model.elem.Point3D;

public class DisplayLine extends DisplayObject {
    @Override
    public void display (final IM3DCanvas a, final M3DContext t, final int i) {
        final Point3D [] lp = new Point3D [2];
        lp [0] = new Point3D ();
        lp [1] = new Point3D ();
        lp [0].setLocation (t.m3DCGet (i, 0), t.m3DCGet (i, 1),
                t.m3DCGet (i, 2));
        lp [1].setLocation (t.m3DCGet (i, 3), t.m3DCGet (i, 4),
                t.m3DCGet (i, 5));
        a.tLine (lp);
    }
}
