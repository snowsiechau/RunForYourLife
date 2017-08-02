package game.bases.renderer;

import game.bases.Vector2D;

import java.awt.*;

/**
 * Created by SNOW on 8/2/2017.
 */
public interface Renderer {
    void render(Graphics2D g2d, Vector2D position);
}
