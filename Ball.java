 import java.awt.*;
   public class Ball extends Polkadot
   {
      private double dx;       // pixels to move each time step() is called.
      private double dy;
      private int count = 0;

		private int firec = 0;
    // constructors
   
      public Ball(double x, double y, double dia, Color c, int a)
      {
         super(x, y, dia, c, a);
         dx = 0;
         dy = 0;
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
       public void setcount(int x)
   	{
   	count = x;
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
      		public int getfirenum()
		{
return firec;
}
		public void setfirenum(int c)
		{
firec=c;
}
     //instance methods
      public void move(double rightEdge, double bottomEdge) //Moves the ball, and makes sure that it doesn't move past the boundary
      {
         setX(getX()- Math.sin((super.getAngle()-1)/64.0 * (-2 * Math.PI))* Math.abs(-dx));  
			//System.out.println("super" +super.getAngle());                // move horizontally
         setY(getY()- Math.cos((super.getAngle()-1)/64.0 * (-2 * Math.PI))* Math.abs(dy));
            	if(count==6)
      	{
      	setDiameter(0);
			this.setX(100);
			this.setY(100);
			this.setdx(0);
			this.setdy(0);
      	count = 0;
			firec=1;
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
