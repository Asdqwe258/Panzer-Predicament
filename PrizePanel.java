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
      private Polkadot pd, pd2;
      private Ball ball, ball2, ball3, ball4, ball5, ball6, ball7, ball8, ball9, ball10;
   
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
         pd2 = new Polkadot();
         ball6 = new Ball(100, 100, 0, Color.BLACK, 0);
         ball6.setdx(0);
         ball6.setdy(0);
         ball7 = new Ball(100, 100, 0, Color.BLACK, 0);
         ball7.setdx(0);
         ball7.setdy(0);
         ball8 = new Ball(100, 100, 0, Color.BLACK, 0);
         ball8.setdx(0);
         ball8.setdy(0);
         ball9 = new Ball(100, 100, 0, Color.BLACK, 0);
         ball9.setdx(0);
         ball9.setdy(0);
         ball10 = new Ball(100, 100, 0, Color.BLACK, 0);
         ball10.setdx(0);
         ball10.setdy(0);
         ball6.setfirenum(1);
         ball7.setfirenum(1);
         ball8.setfirenum(1);
         ball9.setfirenum(1);
         ball10.setfirenum(1);
      
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
            ball6.move(FRAME, FRAME);
            ball7.move(FRAME, FRAME);
            ball8.move(FRAME, FRAME);
            ball9.move(FRAME, FRAME);
            ball10.move(FRAME, FRAME);
            ball.draw(myBuffer, pd.getAngle());
            ball2.draw(myBuffer, pd.getAngle());
            ball3.draw(myBuffer, pd.getAngle());
            ball4.draw(myBuffer, pd.getAngle());
            ball5.draw(myBuffer, pd.getAngle());
            ball6.draw(myBuffer, pd2.getAngle());
            ball7.draw(myBuffer, pd2.getAngle());
            ball8.draw(myBuffer, pd2.getAngle());
            ball9.draw(myBuffer, pd2.getAngle());
            ball10.draw(myBuffer, pd2.getAngle());
            pd.draw(myBuffer, pd.getAngle());
            pd2.draw(myBuffer, pd2.getAngle());
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
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
               if(ball.getfirenum()==1)
               {        
                 
                  ball.setX(pd.getX());
                  ball.setY(pd.getY());
                  ball.setcount(0);
                  ball.setDiameter(5);
                  ball.setdy(5);
                  ball.setdx(5);
                  ball.setfirenum(0);
               }
               else if(ball2.getfirenum()==1)
               {   
                  
                  ball2.setX(pd.getX());
                  ball2.setY(pd.getY());
                  ball2.setcount(0);
                  ball2.setDiameter(5);
                  ball2.setdy(5);
                  ball2.setdx(5);
                  ball2.setfirenum(0);	  
               }
               else if(ball3.getfirenum()==1)
               {  
                  ball3.setX(pd.getX());
                  ball3.setY(pd.getY());
                  ball3.setcount(0);
                  ball3.setDiameter(5);
                  ball3.setdy(5);
                  ball3.setdx(5);
                  ball3.setfirenum(0); 
               }
                  
               else if(ball4.getfirenum()==1)
               {                   
                  ball4.setX(pd.getX());
                  ball4.setY(pd.getY());
                  ball4.setcount(0);
                  ball4.setDiameter(5);
                  ball4.setdy(5);
                  ball4.setdx(5);
                  ball4.setfirenum(0); 
                  	 
               }
               else if(ball5.getfirenum()==1)
               { 
                  ball5.setX(pd.getX());
                  ball5.setY(pd.getY());
                  ball5.setcount(0);
                  ball5.setDiameter(5);
                  ball5.setdy(5);
                  ball5.setdx(5);
                  ball5.setfirenum(0); 
               }
            
            				 
            }
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
               if(ball6.getfirenum()==1)
               {        
                 
                  ball6.setX(pd2.getX());
                  ball6.setY(pd2.getY());
                  ball6.setcount(0);
                  ball6.setDiameter(5);
                  ball6.setdy(5);
                  ball6.setdx(5);
                  ball6.setfirenum(0);
               }
               else if(ball7.getfirenum()==1)
               {   
                  
                  ball7.setX(pd2.getX());
                  ball7.setY(pd2.getY());
                  ball7.setcount(0);
                  ball7.setDiameter(5);
                  ball7.setdy(5);
                  ball7.setdx(5);
                  ball7.setfirenum(0);	  
               }
               else if(ball8.getfirenum()==1)
               {  
                  ball8.setX(pd2.getX());
                  ball8.setY(pd2.getY());
                  ball8.setcount(0);
                  ball8.setDiameter(5);
                  ball8.setdy(5);
                  ball8.setdx(5);
                  ball8.setfirenum(0); 
               }
                  
               else if(ball9.getfirenum()==1)
               {                   
                  ball9.setX(pd2.getX());
                  ball9.setY(pd2.getY());
                  ball9.setcount(0);
                  ball9.setDiameter(5);
                  ball9.setdy(5);
                  ball9.setdx(5);
                  ball9.setfirenum(0); 
                  	 
               }
               else if(ball10.getfirenum()==1)
               { 
                  ball10.setX(pd2.getX());
                  ball10.setY(pd2.getY());
                  ball10.setcount(0);
                  ball10.setDiameter(5);
                  ball10.setdy(5);
                  ball10.setdx(5);
                  ball10.setfirenum(0); 
               }
            
            				 
            }
            if(e.getKeyCode() == KeyEvent.VK_UP && pd.getY() > pd.getRadius()){
               pd.setX(pd.getX()+ Math.sin((double)(pd.getAngle()-1)/64 * (-2 * Math.PI))*(-10));   // move horizontally
               pd.setY(pd.getY()+ Math.cos((double)(pd.getAngle()-1)/64 * (-2 * Math.PI))*(-10)); //move vertically
            }  
            if(e.getKeyCode() == KeyEvent.VK_DOWN && pd.getY() < FRAME - pd.getRadius()){
               pd.setX(pd.getX()+ Math.sin((double)(pd.getAngle()-1)/64 * (-2 * Math.PI))*(10)); // move horizontally
            
               pd.setY(pd.getY()+ Math.cos((double)(pd.getAngle()-1)/64 * (-2 * Math.PI))*(10)); //move vertically
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT && pd.getX() > pd.getRadius())
               pd.setAngle( pd.getAngle() - 1); 
         
            if(e.getKeyCode() == KeyEvent.VK_RIGHT && pd.getX() < FRAME - pd.getRadius()){
               pd.setAngle( pd.getAngle() + 1);
            }  
            
            if(e.getKeyCode() == KeyEvent.VK_W && pd2.getY() > pd2.getRadius()){
               pd2.setX(pd2.getX()+ Math.sin((double)(pd2.getAngle()-1)/64 * (-2 * Math.PI))*(-10));   // move horizontally
               pd2.setY(pd2.getY()+ Math.cos((double)(pd2.getAngle()-1)/64 * (-2 * Math.PI))*(-10)); //move vertically
            }  
            if(e.getKeyCode() == KeyEvent.VK_S && pd2.getY() < FRAME - pd2.getRadius()){
               pd2.setX(pd2.getX()+ Math.sin((double)(pd2.getAngle()-1)/64 * (-2 * Math.PI))*(10)); // move horizontally
               pd2.setY(pd2.getY()+ Math.cos((double)(pd2.getAngle()-1)/64 * (-2 * Math.PI))*(10)); //move vertically
            }
            if(e.getKeyCode() == KeyEvent.VK_A && pd2.getX() > pd2.getRadius())
               pd2.setAngle( pd2.getAngle() - 1); 
          
            if(e.getKeyCode() == KeyEvent.VK_D && pd2.getX() < FRAME - pd2.getRadius()){
               pd2.setAngle( pd2.getAngle() + 1);
                              
                
            }                  
                               
            
         }
      
      
      
         private double distance(double x1, double y1, double x2, double y2)
         {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
         }
      }
   }
