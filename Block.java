package pong;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;




public class Block implements Renderable {

    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color color;

    //add a default and initialization Block constructor - x , y , width, height, color
    public Block(){
        xPos = 20;
        yPos = 20;
        width = 20;
        height = 20;
        color = Color.RED;
    }
    public Block(int x, int y, int wid, int hei, Color col){
        xPos = x;
        yPos = y;
        width = wid;
        height = hei;
        color = col;
    }

    
    
    //add the get and set methods
    public void setX(int x){
        xPos = x;
    }
    public void setY(int y){
        yPos = y;
    }
    public void setWidth(int wid){
        width = wid;
    }
    public void setHeight(int hei){
        height = hei;
    }
    public void setColor(Color col){
        color = col;
    }
    
    
    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public Color getColor(){
        return color;
    }

    @Override
    public void draw(Canvas canvas, Color col) {
        //uncomment after you write the set and get methods
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.setFill(col);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight()); 
    }

    public boolean equals(Object obj) {
		//complete this method
    Block other = (Block)obj;
    if(xPos == other.xPos && yPos == other.yPos && width == other.width && height == other.height){
        return true;
    }
        return false;
    }
    //add a toString() method  - x , y , width, height, color
    
    public String toString(){
        return "xPos = " + xPos  + ", yPos = " + yPos 
                + ", width = " + width + ", height = "
                + height + ", Color = " + color;
    }
    

}