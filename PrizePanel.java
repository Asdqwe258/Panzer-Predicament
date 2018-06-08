	 //Name:    Date:
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   import java.lang.Object;
   public class PrizePanel extends JPanel
   {
      private static final int FRAME = 1000; //size of map
      private static final Color BACKGROUND = new Color(204, 204, 204);
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Polkadot pd;
       private Ball ball, ball2, ball3, ball4, ball5;

      private Timer w;
      public ImageIcon t; 
      public int firec=1;
      int hits = 0;
   	//constructor   
      public PrizePanel()
      {
         myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME,FRAME);
       
       
   
         addKeyListener(new Key());
         setFocusable(true);
      	
         w = new Timer(0, new Listener());
         w.start();
         pd = new Polkadot();
         ball = new Ball(100, 100, 0, Color.BLACK, 0);
         ball.setdx(0);
         ball.setdy(0);
         ball2 = new Ball(100, 100, 0, Color.BLACK, 0);
         ball2.setdx(0);
         ball2.setdy(0);
         ball3 = new Ball(100, 100, 0, Color.BLACK, 0);
         ball3.setdx(0);
         ball3.setdy(0);
         ball4 = new Ball(100, 100, 0, Color.BLACK, 0);
         ball4.setdx(0);
         ball4.setdy(0);
         ball5 = new Ball(100, 100, 0, Color.BLACK, 0);
         ball5.setdx(0);
         ball5.setdy(0);
         	ball.setfirenum(1);
         	ball2.setfirenum(1);
         	ball3.setfirenum(1);
         	ball4.setfirenum(1);
         	ball5.setfirenum(1);
      
      }
      public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);

      }
      private class Listener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            myBuffer.setColor(BACKGROUND);
            myBuffer.fillRect(0, 0, FRAME, FRAME);
                   
             ball.move(FRAME, FRAME);
            ball2.move(FRAME, FRAME);
            ball3.move(FRAME, FRAME);
            ball4.move(FRAME, FRAME);
            ball5.move(FRAME, FRAME);
            ball.draw(myBuffer, pd.getAngle());
            ball2.draw(myBuffer, pd.getAngle());
            ball3.draw(myBuffer, pd.getAngle());
            ball4.draw(myBuffer, pd.getAngle());
            ball5.draw(myBuffer, pd.getAngle());
            pd.draw(myBuffer, pd.getAngle());
            ball.draw(myBuffer, pd.getAngle());
            myBuffer.setColor(Color.BLACK);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 24));
            myBuffer.drawString("Count: " + hits, FRAME - 150, 25);
            repaint();
         }
      }   
      private class Key extends KeyAdapter
      {
      

         public void keyPressed(KeyEvent e)
         {
                     if(e.getKeyCode() == KeyEvent.VK_SPACE)
               {
  if(ball.getfirenum()==1)
               {        
					   ball.setAngle(pd.getAngle());
                  ball.setX(pd.getX());
                  ball.setY(pd.getY());
                  ball.setcount(0);
                  ball.setDiameter(5);
                  ball.setdy((-10)*(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball.setdx((10)*(Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball.setfirenum(0);
               }
               else if(ball2.getfirenum()==1)
               {   
					   
                  ball2.setX(pd.getX());
                  ball2.setY(pd.getY());
                  ball2.setcount(0);
                  ball2.setDiameter(5);
                  ball2.setdy(-2);
                  ball2.setfirenum(0);	  
               }
               else if(ball3.getfirenum()==1)
               {  
                  ball3.setX(pd.getX());
                  ball3.setY(pd.getY());
                  ball3.setcount(0);
                  ball3.setDiameter(5);
                  ball3.setdy(-2);
                  ball3.setfirenum(0); 
               }
                  
               else if(ball4.getfirenum()==1)
               {                   
                  ball4.setX(pd.getX());
                  ball4.setY(pd.getY());
                  ball4.setcount(0);
                  ball4.setDiameter(5);
                  ball4.setdy(-2);
                  ball4.setfirenum(0); 
                  	 
               }
               else if(ball5.getfirenum()==1)
               { 
                  ball5.setX(pd.getX());
                  ball5.setY(pd.getY());
                  ball5.setcount(0);
                  ball5.setDiameter(5);
                  ball5.setdy(-2);
                  ball5.setfirenum(0); 
               }
            
								 
         		}
            if(e.getKeyCode() == KeyEvent.VK_UP && pd.getY() > pd.getRadius()){
                pd.setX(pd.getX()+ Math.sin(Math.toRadians(pd.getAngle()-1)*5.625 )*(10));   // move horizontally
         pd.setY(pd.getY()+ Math.cos(Math.toRadians(pd.getAngle()-1)*5.625 )*(-10)); //move vertically
         }  
            if(e.getKeyCode() == KeyEvent.VK_DOWN && pd.getY() < FRAME - pd.getRadius()){
                pd.setX(pd.getX()+ Math.sin(Math.toRadians(pd.getAngle()-1)*5.625 )*(-10)); // move horizontally
        
         pd.setY(pd.getY()+ Math.cos(Math.toRadians(pd.getAngle()-1)*5.625 )*(10)); //move vertically
           }
            if(e.getKeyCode() == KeyEvent.VK_LEFT && pd.getX() > pd.getRadius())
               pd.setAngle( pd.getAngle() - 1); 

               
            if(e.getKeyCode() == KeyEvent.VK_RIGHT && pd.getX() < FRAME - pd.getRadius()){
                               pd.setAngle( pd.getAngle() + 1);
                              
                               
                               
            }
      }
 
      
   	
      private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
      }
		private void move(double speed){
		//	if(isInWall)
		}
		private boolean isInWall(Map map, double x, double y){
		for(int k = 0; k < map.getMapData().length; k++){
			for(int i = 0; x < map.getMapData()[0].length; x++){
				for(int o = 0; o < 2; o++){
					if(map.getBarrier(k,i,o)){
						if(o == 0){
							if((x > k*(FRAME / map.getMapData().length) + (FRAME / map.getMapData().length) && x < k*(FRAME / map.getMapData().length) + 20 + (FRAME / map.getMapData().length)) && (y > i*(FRAME / map.getMapData()[0].length) && y < i*(FRAME / map.getMapData()[0].length) + (FRAME / map.getMapData()[0].length))){
							return true;
							}
						}
						if(o == 1){
							if((y > i*(FRAME / map.getMapData()[0].length) + (FRAME / map.getMapData()[0].length) && y < i*(FRAME / map.getMapData()[0].length) + 20 + (FRAME / map.getMapData()[0].length)) && (x > k*(FRAME / map.getMapData().length) && x < k*(FRAME / map.getMapData().length) + (FRAME / map.getMapData().length))){
   						return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	}
}
		
		
	
	
   
	
