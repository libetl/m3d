package m3d.model.elem;

public class Point {
    private double x, y;

    public Point () {
        this.x = 0;
        this.y = 0;
    }

    public Point (final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public double getX () {
        return this.x;
    }

    public double getY () {
        return this.y;
    }

    public void setLocation (final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public void setX (final double x) {
        this.x = x;
    }

    public void setY (final double y) {
        this.y = y;
    }

}
