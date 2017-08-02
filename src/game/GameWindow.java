package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by SNOW on 8/1/2017.
 */
public class GameWindow extends JFrame {

    BufferedImage background;
    BufferedImage backBufferedImage;
    Graphics2D backBufferGraphic2D;

    BufferedImage corePlayer;

    private int playerX;
    private int backGroundX;

    public GameWindow() {
        setUpWindow();
        loadImage();

        backGroundX = 0;
        playerX = 200;

        backBufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        backBufferGraphic2D = (Graphics2D) backBufferedImage.getGraphics();

        setupInput();

        this.setVisible(true);
    }

    private void setupInput() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_RIGHT:
                        backGroundX -= 20;
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void loop(){

        while (true) {
            try {
                Thread.sleep(17);

                backBufferGraphic2D.setColor(Color.BLACK);
                backBufferGraphic2D.fillRect(0, 0, this.getWidth(), this.getHeight());
                backBufferGraphic2D.drawImage(background, backGroundX, this.getHeight() - background.getHeight(), null);
                backBufferGraphic2D.drawImage(corePlayer, this.playerX, 450,null);

                Graphics2D g2d = (Graphics2D) this.getGraphics();
                g2d.drawImage(backBufferedImage, 0, 0, null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadImage() {
        try {
            background = ImageIO.read(new File("assert/background/background_duongpho.png"));
            corePlayer = ImageIO.read(new File("assert/player/shape229.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setUpWindow() {
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setTitle("Run for your life");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


    }
}
