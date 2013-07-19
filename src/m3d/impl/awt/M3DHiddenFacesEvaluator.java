package m3d.impl.awt;

import m3d.model.M3DHiddenFaces;

public class M3DHiddenFacesEvaluator {

    public static boolean isDisplayable (final M3DHiddenFaces hf,
            final double x, final double y, final double z, final double px,
            final double py, final double pz, final double w, final double h) {
        int i = 0;
        while (i < hf.size ()) {
            if ( (M3DConvertor.formuleX (hf.get (i).getRectangle ().x,
                    hf.get (i).getZ1 (), px, pz, w) <= M3DConvertor.formuleX (
                    x, z, px, pz, w))
                    && (M3DConvertor.formuleY (hf.get (i).getRectangle ().y, hf
                            .get (i).getZ1 (), py, pz, h) <= M3DConvertor
                            .formuleY (y, z, py, pz, h))
                    && (M3DConvertor.formuleX (hf.get (i).getRectangle ().x
                            + hf.get (i).getRectangle ().width, hf.get (i)
                            .getZ2 (), px, pz, w) >= M3DConvertor.formuleX (x,
                            z, px, pz, w))
                    && (M3DConvertor.formuleY (hf.get (i).getRectangle ().y
                            + hf.get (i).getRectangle ().height, hf.get (i)
                            .getZ2 (), py, pz, h) >= M3DConvertor.formuleY (y,
                            z, py, pz, h))
                    && ( ( (hf.get (i).getZ1 () < z) && (hf.get (i).getZ1 ()
                            - pz > 0)) && ( (hf.get (i).getZ2 () < z) && (hf
                            .get (i).getZ2 () - pz > 0)))) {
                return false;
            }
            i++;
        }
        return true;
    }
}
