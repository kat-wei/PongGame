/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;


public class Ball extends Block implements Renderable, Updateable {

    private int xSpeed;
    private int ySpeed;

    public Ball() {
        super();
        xSpeed = 3;
        ySpeed = 1;
    }

    

    //add the other Ball constructors - see BallTestOne
    public Ball(int x, int y, int wid, int hei, Color col){
        super(x, y, wid, hei, col);
    }
    
    public Ball(int x, int y, int wid, int hei, Color col, int xS, int yS){
        super(x, y, wid, hei, col);
        xSpeed = xS;
        ySpeed = yS;
    }
    //add the set methods
    public void setXSpeed(int xS){
        xSpeed = xS;
    }
    public void setYSpeed(int yS){
        ySpeed = yS;
    }
    //add the get methods
    public int getXSpeed(){
        return xSpeed;
    }
    public int getYSpeed(){
        return ySpeed;
    }
    //add a toString() method
    public String toString(){
        return "" + super.toString() + " xSpeed = " + xSpeed + 
                ", ySpeed = " + ySpeed;
    }
    @Override
    public void update(Canvas canvas) {
        //draw a white ball at old ball location
        draw(canvas, Color.WHITE);
        super.setX(super.getX() + xSpeed);
        super.setY(super.getY() + ySpeed);
		//update the ball location


    }

    @Override
    public boolean equals(Object obj) {
        //complete this method
        Ball object = (Ball)obj;
        if(super.equals(object) && xSpeed == object.xSpeed && ySpeed == object.ySpeed){
            return true;
        }
        return false;
    }

    public void checkCollideLeft(Block b) {
	//complete this method - the word document might be helpful
        Block paddle = (Block)b;
        if(this.getX()<=paddle.getX() + paddle.getWidth()
                && this.getY()>=paddle.getY()
            && this.getY()<paddle.getY()+paddle.getHeight()){
            
            xSpeed = -xSpeed;
        }
        
    }
    public void checkCollideRight(Block b) { 
	//complete this method - the word document might be helpful
        Block paddle = (Block)b;
        if(this.getX()+this.getWidth()>=paddle.getX() && this.getY()>=paddle.getY()
                && this.getY()<paddle.getY()+paddle.getHeight()){
            xSpeed = -xSpeed;
        }

    }


}
