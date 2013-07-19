package m3d.objects;

import java.util.LinkedList;
import java.util.List;

import m3d.model.elem.Point3D;

public class M3DPolygon extends M3DObject {

    Point3D [] lp;

    public M3DPolygon (final Point3D... lp) {
        this.lp = lp;
    }

    public M3DPolygon (final Point3D p1, final Point3D p2, final Point3D p3) {
        this (new Point3D [] { p1, p2, p3 });
    }

    public M3DPolygon (final Point3D p1, final Point3D p2, final Point3D p3,
            final Point3D p4) {
        this (new Point3D [] { p1, p2, p3, p4 });
    }

    public M3DPolygon (final Point3D p1, final Point3D p2, final Point3D p3,
            final Point3D p4, final Point3D p5) {
        this (new Point3D [] { p1, p2, p3, p4, p5 });
    }

    public M3DPolygon (final Point3D p1, final Point3D p2, final Point3D p3,
            final Point3D p4, final Point3D p5, final Point3D p6) {
        this (new Point3D [] { p1, p2, p3, p4, p5, p6 });
    }

    @Override
    public List<Object> getValues () {
        final LinkedList<Object> ll = new LinkedList<Object> ();
        for (final Point3D p : this.lp) {
            ll.add (p.getX ());
            ll.add (p.getY ());
            ll.add (p.getZ ());
        }
        return ll;
    }

    @Override
    public void setValue (final int j, final Object o) {
        final int num = j / 3;
        final int coord = j % 3;
        switch (coord) {
        case 0 :
            this.lp [num].setX ((Double) o);
            break;
        case 1 :
            this.lp [num].setY ((Double) o);
            break;
        case 2 :
            this.lp [num].setZ ((Double) o);
            break;
        default :
            break;
        }
    }
}
