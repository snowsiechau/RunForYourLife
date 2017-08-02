package game.bases.physics;

import game.bases.GameObject;

import java.util.Vector;

/**
 * Created by SNOW on 8/2/2017.
 */
public class Physics {
    private static Vector<PhysicBody> bodies = new Vector<>();

    public static void add(PhysicBody body){
        bodies.add(body);
    }

    public static <T extends PhysicBody> T bodyInred(BoxCollider boxCollider, Class<T> classz){
        for (PhysicBody body: bodies){
            if (body.isActive() && body.getBoxCollider().collideWidth(boxCollider)){
                if (body.getClass() == classz){
                    return (T) body;
                }
            }
        }
        return null;
    }

    public static void clear(){
        bodies.clear();
    }
}
