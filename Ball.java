 import java.awt.*;
   public class Ball extends Polkadot
   {
      private double dx;       // pixels to move each time step() is called.
      private double dy;
      private int count = 0;
    // constructors
   
      public Ball(double x, double y, double dia, Color c, int a)
      {
         super(x, y, dia, c, a);
         dx = 0;
         dy = 3;
      }
      
     //modifier methods 
      public void setdx(double x)        
      {
         dx = x;
      }
      public void setdy(double y)
      {
         dy = y;
      }
      
      //accessor methods
      public double getdx()             
      {
         return dx;
      }
      public double getdy()
      {
         return dy;
      }
      
     //instance methods
      public void move(double rightEdge, double bottomEdge)
      {
         setX(getX()+ Math.cos(super.getAngle()*64)*dx);                  // move horizontally
         setY(getY()+ Math.sin(super.getAngle()*64)*dy);
        	if(count>5)
      	{
      	setDiameter(0);
      	count= 0;
      	}
         if(getX() >= rightEdge - getRadius())  //hit right edge
         {
            setX(rightEdge - getRadius());
            dx = dx * -1; 
            count++;
         }
         if(getX() <= getRadius())
         {
            setX(getRadius());
            dx = dx * -1;
            count++;
         }
         if(getY() <= getRadius())
         {
            setY(getRadius());
            dy = dy * -1;
            count++;
         }
         if(getY() >= bottomEdge - getRadius())
         {
            setY(bottomEdge - getRadius());
            dy = dy * -1;
            count++;
         }
         
      }
   }