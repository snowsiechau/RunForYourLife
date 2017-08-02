package game.bases;

import game.bases.GameObject;

import java.lang.reflect.GenericArrayType;
import java.util.Vector;

/**
 * Created by SNOW on 8/2/2017.
 */
public class GameObjectPool {
    private static Vector<GameObject> pool = new Vector<>();

    public static <T extends GameObject> T recycle(Class<T> classz){
        for (GameObject gameObject : pool){
            if (!gameObject.isActive && gameObject.getClass() == classz){
                gameObject.setActive(true);
                return (T) gameObject;
            }
        }

        try {
            T newGameObject = classz.newInstance();
            pool.add(newGameObject);
            GameObject.add(newGameObject);
            return newGameObject;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
            return null;
    }
}
