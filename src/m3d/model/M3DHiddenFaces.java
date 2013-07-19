package m3d.model;

import java.util.ArrayList;

public class M3DHiddenFaces {

    ArrayList<M3DArea> hf;

    public M3DHiddenFaces () {
        this.hf = new ArrayList<M3DArea> ();
    }

    public boolean add (final M3DArea e) {
        return this.hf.add (e);
    }

    public M3DArea get (final int index) {
        return this.hf.get (index);
    }

    public int size () {
        return this.hf.size ();
    }
}
