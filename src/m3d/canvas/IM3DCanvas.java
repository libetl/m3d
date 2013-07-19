package m3d.canvas;

import m3d.model.elem.Point3D;
import m3d.model.elem.Rectangle3D;

public interface IM3DCanvas {

    void stop ();

    void start ();

    void erase ();

    Object getImpl ();

    void tLine (Point3D [] lp);

    void tPolygon (Point3D [] lp2);

    void tRect (Rectangle3D rc);

    void tText (Point3D point, String get);

}
