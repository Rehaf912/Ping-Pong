package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.event.KeyEvent;

public class Paddle extends InteractiveGraphicalObject {
    private int keyToGoUp;
    private int keyToGoDown;
    private double speed;
    private int direction;

    public Paddle(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
        width = 20;
        height = 50;

        this.keyToGoUp    = KeyEvent.VK_W;
        this.keyToGoDown   = KeyEvent.VK_S;
        this.direction      = -1; //-1 keine Bewegung, 1 nach unten, 2 nach oben
    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(53, 90, 19, 255);
        drawTool.drawFilledRectangle(x, y, width, height);
    }

    public void update(double dt){
        if(direction == 0){
            y += speed*dt;
            if(y + height > 600){
                y = 600 - height;
            }
        }
        if(direction == 2){
            y -= speed*dt;
            if(y < 50){
                y = 50;
            }
        }
    }

    public void keyPressed(int key) {
        if(key == keyToGoUp) {
            direction = 2;
        }
        else if (key == keyToGoDown) {
            direction = 0;
        }
    }

    public void keyReleased(int key) {
        if(key == keyToGoUp){
            direction = -1;
        }
        if(key == keyToGoDown){
            direction = -1;
        }
    }

}
