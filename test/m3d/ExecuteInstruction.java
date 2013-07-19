package m3d;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

import m3d.objects.M3DObject;

public class ExecuteInstruction {

  private static Object analyse (final String text) {

    final int point = text.indexOf ('.');
    final int parenth = text.indexOf ('(');
    if (parenth == -1) {
      try {
        return new Double (text);
      } catch (final RuntimeException re) {
        return text;
      }
    }
    if ((text.length () > 0) && (text.charAt (0) == '"')) {
      if (text.charAt (text.length () - 1) == '"') {
        return text;
      } else {
        return text + '"';
      }
    }
    final Object[] node = new Object[3];
    if ((point != -1) && (parenth > point)) {
      node[0] = text.substring (0, text.indexOf ('.')).trim ();
      node[1] = text.substring (text.indexOf ('.') + 1, text.indexOf ('('))
          .trim ();
    } else {
      node[1] = text.substring (0, text.indexOf ('(')).trim ();
    }
    final String args = (text.substring (text.indexOf ('(') + 1,
        text.lastIndexOf (')')).trim ());
    final LinkedList<Object> ll = new LinkedList<Object> ();

    String cursor = args;
    int indexArgs = 0;
    int indexDebut = 0;
    while (cursor.indexOf (',') != -1) {
      indexArgs += cursor.indexOf (',') + 1;
      if ((ExecuteInstruction.countIndexOf (
          args.substring (indexDebut, indexArgs), '(') == ExecuteInstruction
          .countIndexOf (args.substring (indexDebut, indexArgs), ')'))
          && (ExecuteInstruction.countIndexOf (
              args.substring (indexDebut, indexArgs), '"') % 2 == 0)) {
        ll.add (ExecuteInstruction.analyse (args.substring (indexDebut,
            indexArgs - 1).trim ()));
        indexDebut = indexArgs;
      }
      cursor = cursor.substring (cursor.indexOf (',') + 1);
    }
    if (args.lastIndexOf (')') != -1) {
      ll.add (ExecuteInstruction.analyse (args.substring (indexDebut,
          args.lastIndexOf (')') + 1)));
    } else if (args.substring (indexDebut).trim ().length () > 0) {
      ll.add (ExecuteInstruction.analyse (args.substring (indexDebut).trim ()));
    }
    node[2] = ll.toArray ();
    return node;
  }

  private static int countIndexOf (final String text, final char c) {
    int num = 0;
    String text2 = text;
    while (text2.indexOf (c) != -1) {
      text2 = text2.substring (text2.indexOf (c) + 1);
      num++;
    }
    return num;
  }

  @SuppressWarnings ("unchecked")
  private static Object evaluation (final Object tree, final Object o) {
    if (tree == null) { return tree; }
    if ((tree instanceof String) && "true".equals (tree)) { return new Boolean (
        true); }
    if ((tree instanceof String) && "false".equals (tree)) { return new Boolean (
        false); }
    if ((tree instanceof String) && (((String) tree).length () > 0)
        && (((String) tree).charAt (0) == '"')
        && (((String) tree).charAt (((String) tree).length () - 1) == '"')) { return ((String) tree)
        .substring (1, ((String) tree).length () - 1); }
    if (tree instanceof Double) { return tree; }
    if (((tree instanceof Object[]) && (((Object[]) tree).length < 2))
        || !(((Object[]) tree)[1] instanceof String)) {
      final Object[] resL = new Object[((Object[]) tree).length];
      for (int i = 0 ; i < ((Object[]) tree).length ; i++) {
        resL[i] = ExecuteInstruction.evaluation (((Object[]) tree)[i], o);
      }
      return resL;
    }
    if (tree instanceof Object[]) {
      final Object[] ol = (Object[]) tree;
      try {
        Class<?> objectClass = null;
        final Object res = ExecuteInstruction.evaluation (ol[2], o);
        Object[] resL = null;
        if (res instanceof Object[]) {
          resL = (Object[]) res;
        } else {
          resL = new Object[] { res };
        }

        final Class<?>[] mParameters = new Class[resL.length];

        for (int i = 0 ; i < resL.length ; i++) {
          mParameters[i] = resL[i].getClass ();
          if (M3DObject.class.isAssignableFrom (resL[i].getClass ())) {
            mParameters[i] = M3DObject.class;
          }
        }

        if ((ol.length == 3) && (ol[0] != null) && (ol[0] instanceof String)
            && (ol[1] instanceof String)) {

          final Field f = o.getClass ().getDeclaredField ((String) ol[0]);
          objectClass = f.getType ();
          final Method m = objectClass.getMethod ((String) ol[1], mParameters);
          return m.invoke (f.get (o), resL);
        } else if ((ol.length == 3) && (ol[1] instanceof String)
            && ((String) ol[1]).startsWith ("new ")) {
          try {
            objectClass = Class.forName ("m3d.objects."
                + ((String) ol[1]).substring (4));
          } catch (final ClassNotFoundException e) {
            objectClass = Class.forName ("m3d.modele.elem."
                + ((String) ol[1]).substring (4));
          }

          final Constructor<M3DObject> constr = (Constructor<M3DObject>) objectClass
              .getConstructor (mParameters);

          return constr.newInstance (resL);

        } else if ((ol.length == 3) && (ol[1] instanceof String)) {

          objectClass = o.getClass ();
          final Method m = objectClass.getMethod ((String) ol[1], mParameters);
          return m.invoke (o, resL);
        }

      } catch (final SecurityException e) {
        e.printStackTrace ();
      } catch (final NoSuchFieldException e) {
        e.printStackTrace ();
      } catch (final NoSuchMethodException e) {
        e.printStackTrace ();
      } catch (final IllegalArgumentException e) {
        e.printStackTrace ();
      } catch (final IllegalAccessException e) {
        e.printStackTrace ();
      } catch (final InvocationTargetException e) {
        e.printStackTrace ();
      } catch (final ClassNotFoundException e) {
        e.printStackTrace ();
      } catch (final InstantiationException e) {
        e.printStackTrace ();
      }
    }
    return tree;
  }

  public static void execute (final String text, final Object o) {
    final String instructions[] = text.split (";");
    for (int i = 0 ; i < instructions.length ; i++) {
      if (instructions[i].trim ().length () > 0) {
        instructions[i] = ExecuteInstruction.preproc (instructions[i]);
        final Object tree = ExecuteInstruction.analyse (instructions[i]);
        ExecuteInstruction.evaluation (tree, o);
      }
    }
  }

  private static String preproc (final String string) {
    return string.replace ('«', '"').replace ('»', '"');
  }
}
