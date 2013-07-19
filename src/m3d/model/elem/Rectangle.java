package m3d.model.elem;

public class Rectangle {

    public double x, y, width, height;

    public Rectangle () {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }

    public Rectangle (final double x, final double y, final double w,
            final double h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
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