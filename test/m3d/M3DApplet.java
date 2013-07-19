package m3d;

import java.applet.Applet;

public class M3DApplet extends Applet {

  /**
	 * 
	 */
  private static final long serialVersionUID = 5070643940707000121L;

  @Override
  public void init () {
    new TestInterface (false, this).play ();
  }

}
