package game.bases;

import game.bases.physics.PhysicBody;
import game.bases.physics.Physics;
import game.bases.renderer.ImageRenderer;
import game.bases.renderer.Renderer;

import java.awt.*;
import java.lang.reflect.GenericArrayType;
import java.util.Vector;

/**
 * Created by SNOW on 8/1/2017.
 */
public class GameObject {
    public Vector2D position;
    public Vector2D screenPosition;

    public Renderer renderer;
    public boolean isActive;

    public Vector<GameObject> children;

    private static Vector<GameObject> gameObjects = new Vector<>();
    private static Vector<GameObject> newGameObject = new Vector<>();

    public GameObject(){
        this.position = new Vector2D();
        this.screenPosition = new Vector2D();
        this.children = new Vector<>();
        this.isActive = true;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public static void add(GameObject gameObject){
        newGameObject.add(gameObject);
        if (gameObject instanceof PhysicBody){
            Physics.add((PhysicBody) gameObject);
        }
    }

    public void run(Vector2D parentPosition){
        this.screenPosition = parentPosition.add(position);

        for (GameObject child: children){
            child.run(this.screenPosition);
        }
    }

    public void runAll(){
        for (GameObject gameObject: gameObjects){
            if (gameObject.isActive){
                gameObject.run(new Vector2D(0,0));
            }
        }

        gameObjects.addAll(newGameObject);
        newGameObject.clear();
    }

    public void render(Graphics2D g2d){
        if (renderer != null){
            renderer.render(g2d, this.position);
        }
    }

    public void renderAll(Graphics2D g2d){
        for (GameObject gameObject: gameObjects){
            if (gameObject.isActive){
                gameObject.render(g2d);
            }
        }
    }


}
