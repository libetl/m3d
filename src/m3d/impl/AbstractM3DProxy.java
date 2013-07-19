package m3d.impl;

import m3d.M3DContext;
import m3d.canvas.IM3DCanvas;
import m3d.ops.IM3DRenderer;
import m3d.ops.IM3DRotate;
import m3d.ops.IM3DTranslate;

public abstract class AbstractM3DProxy implements IM3DProxy {

    protected IM3DCanvas    canvas;
    protected IM3DRotate    rotate;
    protected IM3DTranslate translate;
    protected IM3DRenderer  render;

    @Override
    public IM3DCanvas getCanvas () {
        return this.canvas;
    }

    @Override
    public IM3DRotate getRotate () {
        return this.rotate;
    }

    @Override
    public IM3DTranslate getTranslate () {
        return this.translate;
    }

    @Override
    public IM3DRenderer getRenderer () {
        return this.render;
    }

    @Override
    public abstract void rebuild (M3DContext context);
}
