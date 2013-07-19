package m3d.objects;

import java.util.LinkedList;
import java.util.List;

public class M3DPoint extends M3DObject {

    private double x;
    private double y;
    private double z;

    public M3DPoint (final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public M3DPoint (final Double x, final Double y, final Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public List<Object> getValues () {
        final List<Object> ll = new LinkedList<Object> ();
        ll.add (this.x);
        ll.add (this.y);
        ll.add (this.z);
        return ll;
    }

    public double getX () {
        return this.x;
    }

    public double getY () {
        return this.y;
    }

    public double getZ () {
        return this.z;
    }

    @Override
    public void setValue (final int j, final Object o) {
        final Double d = (Double) o;
        switch (j) {
        case 0 :
            this.x = d;
            break;
        case 1 :
            this.y = d;
            break;
        case 2 :
            this.z = d;
            break;
        default :
            break;
        }
    }

    public void setX (final double xs) {
        this.x = xs;
    }

    public void setYs (final double y) {
        this.y = y;
    }

    public void setZ (final double z) {
        this.z = z;
    }
}
