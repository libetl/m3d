package m3d.objects;

import java.util.LinkedList;
import java.util.List;

public class M3DText extends M3DObject {

    private String value;
    private double x;
    private double y;
    private double z;

    public M3DText (final double x, final double y, final double z,
            final char [] value) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.value = new String (value);
    }

    public M3DText (final Double x, final Double y, final Double z,
            final String value) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.value = value;
    }

    public String getValue () {
        return this.value;
    }

    @Override
    public List<Object> getValues () {
        final List<Object> ll = new LinkedList<Object> ();
        ll.add (this.x);
        ll.add (this.y);
        ll.add (this.z);
        ll.add (this.value);
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
        switch (j) {
        case 0 :
            this.x = (Double) o;
            break;
        case 1 :
            this.y = (Double) o;
            break;
        case 2 :
            this.z = (Double) o;
            break;
        case 3 :
            this.value = (String) o;
            break;
        default :
            break;
        }
    }

    public void setValue (final String value) {
        this.value = value;
    }

    public void setX (final double xs) {
        this.x = xs;
    }

    public void setY (final double y) {
        this.y = y;
    }

    public void setYs (final double y) {
        this.y = y;
    }

    public void setZ (final double z) {
        this.z = z;
    }
}
