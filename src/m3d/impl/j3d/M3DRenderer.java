package m3d.impl.j3d;

import m3d.M3DContext;
import m3d.canvas.IM3DCanvas;
import m3d.display.DisplayObject;
import m3d.ops.IM3DRenderer;

public class M3DRenderer implements IM3DRenderer {

    private IM3DCanvas canvas;
    private M3DContext context;

    public M3DRenderer (M3DContext co, IM3DCanvas ca) {
        this.canvas = ca;
        this.context = co;
    }

    @Override
    public void display (int i) {
        Class<?> c;
        try {
            c = Class.forName ("m3d.impl.j3d.display.Display"
                    + this.context.m3DCGetType (i));
            final DisplayObject dO = (DisplayObject) c.newInstance ();
            dO.display (this.canvas, this.context, i);
        } catch (final ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (final InstantiationException e) {
            e.printStackTrace ();
        } catch (final IllegalAccessException e) {
            e.printStackTrace ();
        }
    }

    @Override
    public void stop () {
        this.canvas.stop ();
    }

    @Override
    public void start () {
        this.canvas.start ();
    }

    @Override
    public void erase () {
        this.canvas.erase ();
    }

}
