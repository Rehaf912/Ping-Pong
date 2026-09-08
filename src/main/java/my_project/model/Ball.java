package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

public class Ball extends InteractiveGraphicalObject {
    private double vx;
    private double vy;

    public Ball(double x, double y){
        this.x = x;
        this.y = y;
        radius = 10;

        vx = 150;
        vy = 100;
    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(91, 219, 52, 255);
        drawTool.drawFilledCircle(x, y, radius);
    }

    public void update(double dt){
        x += vx * dt;
        y += vy * dt;

        if(x - radius < 0 || x + radius > 600){
            vx = -vx;
        }
        if(y - radius < 0 || y + radius > 600){
            vy = -vy;
        }
    }
    public double getVx(){
        return vx;
    }
    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }
}
