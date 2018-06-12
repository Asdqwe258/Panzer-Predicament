// Billington.  email: mlbillington@fcps.edu
// version: 7.25.2007
// updated by Phil Ero 16NOV07

   import java.awt.*;
  import javax.swing.*;

   public class Polkadot
   {
   private Graphics buffer;
      private double myX;   // x and y coordinates of center
      private double myY;
      private double myDiameter;//size of the tank
      private Color myColor; 
      private double myRadius; 
      private int myAngle; //angle of tank
      private int type, score;
     // constructors
      public Polkadot(int x)     //default constructor
      {
         myX = Math.random() *1400;
         myY = Math.random() *1400;
         myDiameter = 200;
         myColor = Color.RED;
         myRadius = myDiameter/2;
         myAngle = 1;
         type = x;
         
      }
      public Polkadot(double x, double y, double d, Color c, int a)
      {
         myX = x;
         myY = y;
         myDiameter = d;
         myColor = c;
         myRadius = d/2;
         myAngle = a;
      }
    // accessor methods
      public double getX() 
      { 
         return myX;
      }
      public double getY()      
      { 
         return myY;
      }
      public double getDiameter() 
      { 
         return myDiameter;
      }
      public Color getColor() 
      { 
         return myColor;
      }
      public double getRadius() 
      { 
         return myRadius;
      }
      public int getAngle()
      {
      return myAngle;
      }
   // modifier methods
      public void setX(double x) //moves tanks x coordinate
      {
         myX = x;
      } 
      public void setY(double y) //moves tanks y coordinate
      {
         myY = y;
      } 
      public void setColor(Color c)
      {
         myColor = c;
      }
      public void setDiameter(double d)
      {
         myDiameter = d;
         myRadius = d/2;
      }
      public void setRadius(double r)
      {
         myRadius = r;
         myDiameter = 2*r;
      }
      public void addScore()
      {
      score++;
      }
      public int getScore()
      {
      return score;
      }
      public void setAngle(int a) { //changes the angle of tank
      myAngle = a;
      if (myAngle > 64) { //makes sure that angle does not become less than 360
      myAngle = 1;
      }
      if( myAngle < 1){ //makes sure that angle does not become less than 0
      myAngle = 64;
      }
      }
    //	 instance methods
      public void jump(int rightEdge, int bottomEdge)
      {
         // moves location to random (x, y) within the edges
         myX = (Math.random()* (rightEdge-myDiameter) + myRadius);
         myY = (Math.random()* (bottomEdge-myDiameter) + myRadius);
      }
      public void draw(Graphics myBuffer, int angle) 
      {
		//String tankA = "tank.png";
      //tankA = (tankA.substring(0, 3) + angle + tankA.substring(3, 7));
         
         myBuffer.setColor(myColor);
         myBuffer.fillOval((int)(getX() - getRadius()), (int)(getY()-getRadius()), (int)getDiameter(), (int)getDiameter());
				if(type == 1){ //player1's tank
            if(getDiameter()!=5 && getDiameter()!=0)
				{
				ImageIcon tank = new ImageIcon("tank" + angle + ".png");
				myBuffer.drawImage(tank.getImage(), (int)getX()-159, (int)getY()-163, null);
            buffer = myBuffer;
				}
            }
            if(type == 2) {//player2's tank
            if(getDiameter()!=5 && getDiameter()!=0)
				{
				ImageIcon tank = new ImageIcon("tankred" + angle + ".png");
				myBuffer.drawImage(tank.getImage(), (int)getX()-159, (int)getY()-163, null);
            buffer = myBuffer;
				}
}

            }
            

      
      public Graphics getGraphics(){
      return buffer;
      }
   }
