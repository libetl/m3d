package m3d.model;

import java.util.LinkedList;

import m3d.objects.M3DObject;

public class M3DMatrix {
    private final LinkedList<M3DObject> m;

    public M3DMatrix () {
        this.m = new LinkedList<M3DObject> ();
    }

    public void m3DMDelObject (final int idMo) {
        this.m.remove (idMo);
    }

    public int m3DMGenObject (final M3DObject mo) {
        this.m.add (mo);
        return this.m.size () - 1;
    }

    public M3DObject m3DMGet (final int i) {
        return this.m.get (i);
    }

    public double m3DMGet (final int i, final int j) {
        return (Double) (this.m.get (i).getValues ().get (j));
    }

    public Object m3DMGetMisc (final int i, final int j) {
        return (this.m.get (i).getValues ().get (j));
    }

    public int m3DMGetNb (final int i) {
        return this.m.get (i).getValues ().size ();
    }

    public String m3DMGetType (final int i) {
        return this.m.get (i).getType ();
    }

    public void m3DMSet (final int i, final int j, final double v) {
        this.m.get (i).setValue (j, new Double (v));
    }

    public int m3DMSize () {
        return this.m.size ();
    }
}
