package m3d.impl;

import m3d.M3DContext;

public class M3DProxyFinder {

    @SuppressWarnings ("unchecked")
    public static IM3DProxy build (String techno, M3DContext context) {
        try {
            final Class<IM3DProxy> c = (Class<IM3DProxy>) Class
                    .forName ("m3d.impl." + techno + "." + "M3DProxy");
            IM3DProxy proxy = c.newInstance ();
            proxy.rebuild (context);
            return proxy;
        } catch (final ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (final SecurityException e) {
            e.printStackTrace ();
        } catch (final IllegalArgumentException e) {
            e.printStackTrace ();
        } catch (final InstantiationException e) {
            e.printStackTrace ();
        } catch (final IllegalAccessException e) {
            e.printStackTrace ();
        }
        return null;
    }

}
