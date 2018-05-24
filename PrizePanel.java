	 //Name:    Date:
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   import java.lang.Object;
   public class PrizePanel extends JPanel
   {
      private static final int FRAME = 400;
      private static final Color BACKGROUND = new Color(204, 204, 204);
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Polkadot pd;
      private Ball ball;
      private Timer w;
      public ImageIcon t; 

      int hits = 0;
   	//constructor   
      public PrizePanel()
      {
         myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME,FRAME);
         int xPos = (int)(Math.random()*(FRAME-100) + 50);
         int yPos = (int)(Math.random()*(FRAME-100)+ 50);
         pd = new Polkadot();
   
      	 ball = new Ball(pd.getX(), pd.getY(), 5, Color.BLACK, 1);
         addKeyListener(new Key());
         setFocusable(true);
      	
         w = new Timer(0, new Listener());
         w.start();

      
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

								 
         		}
            if(e.getKeyCode() == KeyEvent.VK_UP && pd.getY() > pd.getRadius()){
                pd.setX(pd.getX()+ Math.cos((double)(pd.getAngle())/64 * (2 * Math.PI))*10);                  // move horizontally
         pd.setY(pd.getY()+ Math.sin((double)(pd.getAngle())/64 * (2 * Math.PI))*10);
         }  
            if(e.getKeyCode() == KeyEvent.VK_DOWN && pd.getY() < FRAME - pd.getRadius()){
                pd.setX(pd.getX()+ Math.cos((double)(pd.getAngle())/64 * (2 * Math.PI))*(-10));                  // move horizontally
        
         pd.setY(pd.getY()+ Math.sin((double)(pd.getAngle())/64 * (2 * Math.PI))*(-10));
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
   }
   }
