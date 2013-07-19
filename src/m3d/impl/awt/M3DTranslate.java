package m3d.impl.awt;

import m3d.IM3DConstants;
import m3d.M3DContext;
import m3d.display.DisplayObject;
import m3d.ops.IM3DTranslate;

public class M3DTranslate implements IM3DTranslate {

    private M3DContext context;

    public M3DTranslate (M3DContext co) {
        this.context = co;
    }

    @Override
    public void translate (final double x, final double y, final double z,
            final int mode) {
        final M3DContext t = this.context;
        final double dOx = z * Math.sin (t.getRoty ()) + y
                * Math.sin (t.getRotz ()) + x * Math.cos (t.getRotz ())
                * Math.cos (t.getRoty ());
        final double dOy = y * Math.cos (t.getRotx ())
                * Math.cos (t.getRotz ()) - z * Math.sin (t.getRotx ()) - x
                * Math.sin (t.getRotz ());
        final double dOz = y * Math.sin (t.getRotx ()) - x
                * Math.sin (t.getRoty ()) + z * Math.cos (t.getRoty ())
                * Math.cos (t.getRotx ());
        if (mode == IM3DConstants.M3DABSOL) {
            t.setOx (dOx);
            t.setOy (dOy);
            t.setOz (dOz);
            t.setPosx (x);
            t.setPosy (y);
            t.setPosz (z);
        } else {
            t.setOx (t.getOx () + dOx);
            t.setOy (t.getOy () + dOy);
            t.setOz (t.getOz () + dOz);
            t.setPosx (t.getPosx () + x);
            t.setPosy (t.getPosy () + y);
            t.setPosz (t.getPosz () + z);
        }
    }

    @Override
    public void translate (final double x, final double y, final double z,
            final int mode, final int i) {

        final M3DContext t = this.context;
        Class<?> clazz;
        try {
            clazz = Class.forName ("m3d.impl.awt.display.Display"
                    + t.m3DCGetType (i));
            final DisplayObject dO = (DisplayObject) clazz.newInstance ();
            dO.translate (t, x, y, z, mode, i);
        } catch (final ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (final InstantiationException e) {
            e.printStackTrace ();
        } catch (final IllegalAccessException e) {
            e.printStackTrace ();
        }
    }

}
