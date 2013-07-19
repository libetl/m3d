package m3d.objects;

import java.util.LinkedList;
import java.util.List;

public class M3DObject {

    public M3DObject () {

    }

    public String getType () {
        return this.getClass ().getSimpleName ().substring (3);
    }

    public List<Object> getValues () {
        return new LinkedList<Object> ();
    }

    public void setValue (final int j, final Object o) {
    }
}
