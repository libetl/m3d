package m3d.objects;

import java.util.LinkedList;
import java.util.List;

public class M3DSquare extends M3DObject {

    private double xf;
    private double xs;
    private double yf;
    private double ys;
    private double zf;
    private double zs;

    public M3DSquare (final double xs, final double ys, final double zs,
            final double xf, final double yf, final double zf) {
        this.xs = xs;
        this.ys = ys;
        this.zs = zs;
        this.xf = xf;
        this.yf = yf;
        this.zf = zf;
    }

    public M3DSquare (final Double xs, final Double ys, final Double zs,
            final Double xf, final Double yf, final Double zf) {
        this.xs = xs;
        this.ys = ys;
        this.zs = zs;
        this.xf = xf;
        this.yf = yf;
        this.zf = zf;
    }

    @Override
    public List<Object> getValues () {
        final List<Object> ll = new LinkedList<Object> ();
        ll.add (this.xs);
        ll.add (this.ys);
        ll.add (this.zs);
        ll.add (this.xf);
        ll.add (this.yf);
        ll.add (this.zf);
        return ll;
    }

    public double getXf () {
        return this.xf;
    }

    public double getXs () {
        return this.xs;
    }

    public double getYf () {
        return this.yf;
    }

    public double getYs () {
        return this.ys;
    }

    public double getZf () {
        return this.zf;
    }

    public double getZs () {
        return this.zs;
    }

    @Override
    public void setValue (final int j, final Object o) {
        final Double d = (Double) o;
        switch (j) {
        case 0 :
            this.xs = d;
            break;
        case 1 :
            this.ys = d;
            break;
        case 2 :
            this.zs = d;
            break;
        case 3 :
            this.xf = d;
            break;
        case 4 :
            this.yf = d;
            break;
        case 5 :
            this.zf = d;
            break;
        default :
            break;
        }
    }

    public void setXf (final double xf) {
        this.xf = xf;
    }

    public void setXs (final double xs) {
        this.xs = xs;
    }

    public void setYf (final double yf) {
        this.yf = yf;
    }

    public void setYs (final double ys) {
        this.ys = ys;
    }

    public void setZf (final double zf) {
        this.zf = zf;
    }

    public void setZs (final double zs) {
        this.zs = zs;
    }
}
