package m3d.model.elem;

public class Point3D {
    private double x, y, z;

    public Point3D () {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Point3D (final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D (final Double x, final Double y, final Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public void setLocation (final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public void setLocation (final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX (final double x) {
        this.x = x;
    }

    public void setY (final double y) {
        this.y = y;
    }

    public void setZ (final double z) {
        this.z = z;
    }
}
