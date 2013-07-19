package m3d.model;

import m3d.model.elem.Rectangle;

public class M3DArea {
    private final Rectangle r;
    private double          z1, z2;

    public M3DArea (final Rectangle r, final double z1, final double z2) {
        this.r = r;
        this.z1 = z1;
        this.z2 = z2;
    }

    public Rectangle getRectangle () {
        return this.r;
    }

    public double getZ1 () {
        return this.z1;
    }

    public double getZ2 () {
        return this.z2;
    }

    public void setZ1 (final double z1) {
        this.z1 = z1;
    }

    public void setZ2 (final double z2) {
        this.z2 = z2;
    }

}
