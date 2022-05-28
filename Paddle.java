/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 *
 * @author wkranz
 */
public class Paddle extends Block implements Renderable, Updateable {

    private int speed;
    private String direction;

    public Paddle() {
        super(10, 10, 10, 40, Color.BLACK);
        speed = 5;
        direction = "NEUTRAL	";
    }

    //add the other Paddle constructors
    public Paddle(int x, int y, int wid, int hei, Color col){
        super(x, y, wid, hei, col);
        speed = 5;
        direction = "NEUTRAL	";
    }
    public Paddle(int x, int y, int wid, int hei, Color col, int s){
        super(x, y, wid, hei, col);
        speed = s;
        direction = "NEUTRAL	";
    }
    //add get methods
    public int getSpeed(){
        return speed;
    }
    public String getDirection(){
        return direction;
    }
    //add set methods
    public void setSpeed(int s){
        speed = s;
    }
    public void setDirection(String dir){
        direction = dir;
    }
    //add a toString() method
    public String toString(){
        return super.toString() + " speed = " + speed + ", direction = " + direction;
    }
    @Override
    public void update(Canvas canvas) {
        draw(canvas, Color.WHITE);
        if (direction.equals("UP")) {
            super.setY(super.getY() + -speed);
        } else if (direction.equals("DOWN")) {
            super.setY(super.getY() + speed);
        }
    }



}