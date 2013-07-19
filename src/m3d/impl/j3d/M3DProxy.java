package m3d.impl.j3d;

import m3d.M3DContext;
import m3d.impl.AbstractM3DProxy;

public class M3DProxy extends AbstractM3DProxy {

    @Override
    public void rebuild (M3DContext context) {
        this.translate = new M3DTranslate (context);
        this.rotate = new M3DRotate (context);
        this.canvas = new J3dM3DCanvas (context.getOwner (), context.getRect ());
        this.render = new M3DRenderer (context, this.canvas);

    }

}
