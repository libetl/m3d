package m3d.impl.awt;

import m3d.M3DContext;

public class M3DConvertor {

    public static int formuleX (final double x, final double z,
            final double px, final double pz, final double w) {
        // Formule 3D->2D pour les x :
        if (z - pz > 0) {
            return (int) ( (x - px) * (1.0 + w) / (z - pz) + w / 2);
        } else {
            return (int) ( (x - px) * (1.0 + w) / 0.1 + w / 2);
        }
    }

    public static int formuleX (final double x, final double z,
            final M3DContext t) {
        // Formule 3D->2D pour les x :
        if (z - t.getPosz () > 0) {
            return (int) ( (x - t.getPosx ()) * (1.0 + t.getRect ().width)
                    / (z - t.getPosz ()) + t.getRect ().width / 2);
        } else {
            return (int) ( (x - t.getPosx ()) * (1.0 + t.getRect ().width)
                    / 0.1 + t.getRect ().width / 2);
        }
    }

    public static int formuleY (final double y, final double z,
            final double py, final double pz, final double h) {
        // Formule 3D->2D pour les y :
        if (z - pz > 0) {
            return (int) ( (y - py) * (1.0 + h) / (z - pz) + h / 2);
        } else {
            return (int) ( (y - py) * (1.0 + h) / 0.1 + h / 2);
        }
    }

    public static int formuleY (final double y, final double z,
            final M3DContext t) {
        // Formule 3D->2D pour les y :
        if (z - t.getPosz () > 0) {
            return (int) ( (y - t.getPosy ()) * (1.0 + t.getRect ().height)
                    / (z - t.getPosz ()) + t.getRect ().height / 2);
        } else {
            return (int) ( (y - t.getPosy ()) * (1.0 + t.getRect ().height)
                    / 0.1 + t.getRect ().height / 2);
        }
    }
}
