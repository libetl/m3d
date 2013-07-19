package m3d.impl;

import m3d.M3DContext;
import m3d.canvas.IM3DCanvas;
import m3d.ops.IM3DRenderer;
import m3d.ops.IM3DRotate;
import m3d.ops.IM3DTranslate;

public interface IM3DProxy {

    IM3DCanvas getCanvas ();

    IM3DRotate getRotate ();

    IM3DTranslate getTranslate ();

    IM3DRenderer getRenderer ();

    void rebuild (M3DContext context);
}
