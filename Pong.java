/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Pong extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static Canvas canvas;
    RedrawTimer timer = new RedrawTimer();
    private int leftscore;
    private int rightscore;

    private int x, y;
    //declare a ball, right paddle and left paddle
    Ball one;
    Paddle left;
    Paddle right;
    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();
        canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        leftscore = 0;
        rightscore = 0;
        //instantiate a ball that will randomly come out of the middle of the screen
        
        x = (int) (Math.random() * 2)+1;
        if(x == 1){
            x = 1;
        }else if(x == 2){
            x = -1;
        }
        
        y = (int) (Math.random() * 2)+1;
        if(y == 1){
            y = 1;
        }else if(y == 2){
            y = -1;
        }
        
        one = new Ball(WIDTH/2, HEIGHT/2, 20, 20, Color.AQUAMARINE, x*1, y*1);
        //  going to the right or left
        //instantiate a right paddle and left paddle
        left = new Paddle(20, HEIGHT/2, 10, 50, Color.DARKCYAN, 5);
        right = new Paddle(WIDTH - 30, HEIGHT/2, 10, 50,Color.DARKCYAN, 6);
        
        
        
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			//Fill in the code for the keypress events
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP) {
                     right.setDirection("UP");
                }
                if (event.getCode() == KeyCode.DOWN) {
                    right.setDirection("DOWN");
                }
                if (event.getCode() == KeyCode.W) {
                    left.setDirection("UP");
                }
                if (event.getCode() == KeyCode.S) {
                    left.setDirection("DOWN");
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP) {
                    right.setDirection("NEUTRAL");
                }
                if (event.getCode() == KeyCode.DOWN) {
                    right.setDirection("NEUTRAL");
                }
                if (event.getCode() == KeyCode.W) {
                    left.setDirection("NEUTRAL");
                }
                if (event.getCode() == KeyCode.S) {
                    left.setDirection("NEUTRAL");
                }
            }
        });
        primaryStage.setTitle("Pong!");
        primaryStage.setScene(scene);
        primaryStage.show();
        timer.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public class RedrawTimer extends AnimationTimer {
        int direction;

        @Override
        public void handle(long now) {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.clearRect(0, 0, WIDTH, HEIGHT);
            gc.setFont(new Font("Verdana", 14));
            gc.strokeText("Left Score:" + leftscore, 50, 550);
            gc.strokeText("Right Score:" + rightscore, 50,580);

            
            
            //check for ball collision with the top and bottom "wall" and the paddles
            if(left.getY()<=0){
                left.setY(0);
            }
            if(left.getY() + left.getHeight()>=HEIGHT){
                left.setY(HEIGHT - left.getHeight());
            }
            if(right.getY()<=0){
                right.setY(0);
            }
            if(right.getY() + right.getHeight()>=HEIGHT){
                right.setY(HEIGHT - right.getHeight());
            }
            
            
            
            if(one.getY()<0){
                one.setYSpeed(-one.getYSpeed());
            }
            if(one.getY()>HEIGHT-one.getHeight()){
                one.setYSpeed(-one.getYSpeed());
            }
            //update all objects
            //draw all objects
            
            one.update(canvas);
            
            one.draw(canvas, one.getColor());
            left.update(canvas);
            left.draw(canvas, left.getColor());
            right.update(canvas);
            right.draw(canvas, right.getColor());
            one.checkCollideLeft(left);
            one.checkCollideRight(right);
            //check to see if the ball hits the left or right walls.
            //  If so, reset the ball in the middle and adjust the score
            x = (int) (Math.random() * 2)+1;
            if(x == 1){
                x = 1;
            }else if(x == 2){
                x = -1;
            }
        
            y = (int) (Math.random() * 2)+1;
            if(y == 1){
                y = 1;
            }else if(y == 2){
                y = -1;
            }
            if(one.getX()==0){
                rightscore = rightscore + 1;
                one = new Ball(WIDTH/2, HEIGHT/2, 20, 20, Color.AQUAMARINE, x*1, y*1);
              
            }
            if(one.getX()+one.getWidth()>WIDTH){
                leftscore = leftscore + 1;
                one = new Ball(WIDTH/2, HEIGHT/2, 20, 20, Color.AQUAMARINE, x*1, y*1);
            }
            
            


        }
    }
}
