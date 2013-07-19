package m3d.model.elem;

public class Rectangle3D {

    public double x, y, z, width, height, depth;

    public Rectangle3D () {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.width = 0;
        this.height = 0;
        this.depth = 0;
    }

    public Rectangle3D (final double x, final double y, final double w,
            final double h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public Rectangle3D (final double x, final double y, final double z,
            final double w, final double h, final double d) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = w;
        this.height = h;
        this.depth = d;
    }

    public Rectangle3D (final Double x, final Double y, final Double w,
            final Double h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public Rectangle3D (final Double x, final Double y, final Double z,
            final Double w, final Double h, final Double d) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = w;
        this.height = h;
        this.depth = d;
    }

    public double getHeight () {
        return this.height;
    }

    public double getWidth () {
        return this.width;
    }

    public double getX () {
        return this.x;
    }

    public double getY () {
        return this.y;
    }

    public void setRect (final double x, final double y, final double w,
            final double h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public void setX1 (final double x1) {
        this.x = x1;
    }

    public void setX2 (final double x2) {
        this.width = x2 - this.x;
    }

    public void setY1 (final double y1) {
        this.y = y1;
    }

    public void setY2 (final double y2) {
        this.height = y2 - this.y;
    }

}