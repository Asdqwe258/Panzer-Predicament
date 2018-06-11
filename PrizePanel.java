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
      private Polkadot pd; //player1
      private Polkadot p2;//player2
       private Ball ball, ball2, ball3, ball4, ball5, ball6, ball7, ball8, ball9, ball10; //instantiates all the ammo

      private Timer w;
      private Timer w2;
      public ImageIcon t;//Image icon for tank1
      public ImageIcon t2;//Image icon for tank2 
      public int firec=1;
      int hits = 0;
      int hits2 = 0;
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
         pd = new Polkadot(1);//initializes player1
         ball = new Ball(100, 100, 0, Color.BLACK, 0);//intializes player1's ammo
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
            
            
         
         p2 = new Polkadot(2); //initializes player2
         ball6 = new Ball(100, 100, 0, Color.BLACK, 0);//initializes player2's ammo
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
            
            ball6.move(FRAME, FRAME);
            ball7.move(FRAME, FRAME);
            ball8.move(FRAME, FRAME);
            ball9.move(FRAME, FRAME);
            ball10.move(FRAME, FRAME);
            ball6.draw(myBuffer, pd.getAngle());
            ball7.draw(myBuffer, pd.getAngle());
            ball8.draw(myBuffer, pd.getAngle());
            ball9.draw(myBuffer, pd.getAngle());
            ball10.draw(myBuffer, pd.getAngle());
            p2.draw(myBuffer, p2.getAngle());
            
            ball6.draw(myBuffer, pd.getAngle());
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
                  ball.setdy((-30)*(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball.getdy());
						System.out.println((Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball.setdx((30)*((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball.getdx());
						System.out.println((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball.setfirenum(0);
               }
               else if(ball2.getfirenum()==1)
               {   
					   
                  ball2.setAngle(pd.getAngle());
                  ball2.setX(pd.getX());
                  ball2.setY(pd.getY());
                  ball2.setcount(0);
                  ball2.setDiameter(5);
                  ball2.setdy((-30)*(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball2.getdy());
						System.out.println((Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball2.setdx((30)*((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball2.getdx());
						System.out.println((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball2.setfirenum(0);
	  
               }
               else if(ball3.getfirenum()==1)
               {  
                  ball3.setAngle(pd.getAngle());
                  ball3.setX(pd.getX());
                  ball3.setY(pd.getY());
                  ball3.setcount(0);
                  ball3.setDiameter(5);
                  ball3.setdy((-30)*(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball3.getdy());
						System.out.println((Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball3.setdx((30)*((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball3.getdx());
						System.out.println((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball3.setfirenum(0);

               }
                  
               else if(ball4.getfirenum()==1)
               {                   
                  ball4.setAngle(pd.getAngle());
                  ball4.setX(pd.getX());
                  ball4.setY(pd.getY());
                  ball4.setcount(0);
                  ball4.setDiameter(5);
                  ball4.setdy((-30)*(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball4.getdy());
						System.out.println((Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball4.setdx((30)*((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball4.getdx());
						System.out.println((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball4.setfirenum(0);
                  	 
               }
               else if(ball5.getfirenum()==1)
               { 
                  ball5.setAngle(pd.getAngle());
                  ball5.setX(pd.getX());
                  ball5.setY(pd.getY());
                  ball5.setcount(0);
                  ball5.setDiameter(5);
                  ball5.setdy((-30)*(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball5.getdy());
						System.out.println((Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball5.setdx((30)*((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball5.getdx());
						System.out.println((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball5.setfirenum(0);
 
               }
               }
               if(e.getKeyCode() == KeyEvent.VK_R)
               {
  if(ball6.getfirenum()==1)
               {        
					   ball6.setAngle(p2.getAngle());
                  ball6.setX(p2.getX());
                  ball6.setY(p2.getY());
                  ball6.setcount(0);
                  ball6.setDiameter(5);
                  ball6.setdy((-30)*(Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball6.getdy());
						System.out.println((Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball6.setdx((30)*((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball6.getdx());
						System.out.println((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball6.setfirenum(0);
               }
               else if(ball7.getfirenum()==1)
               {   
					   
                  ball7.setAngle(p2.getAngle());
                  ball7.setX(p2.getX());
                  ball7.setY(p2.getY());
                  ball7.setcount(0);
                  ball7.setDiameter(5);
                  ball7.setdy((-30)*(Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball7.getdy());
						System.out.println((Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball7.setdx((30)*((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball7.getdx());
						System.out.println((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball7.setfirenum(0);
               }
               else if(ball8.getfirenum()==1)
               {  
                  ball8.setAngle(p2.getAngle());
                  ball8.setX(p2.getX());
                  ball8.setY(p2.getY());
                  ball8.setcount(0);
                  ball8.setDiameter(5);
                  ball8.setdy((-30)*(Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball8.getdy());
						System.out.println((Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball8.setdx((30)*((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball8.getdx());
						System.out.println((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball8.setfirenum(0);
               }
                  
               else if(ball9.getfirenum()==1)
               {                   
                  ball9.setAngle(p2.getAngle());
                  ball9.setX(p2.getX());
                  ball9.setY(p2.getY());
                  ball9.setcount(0);
                  ball9.setDiameter(5);
                  ball9.setdy((-30)*(Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball9.getdy());
						System.out.println((Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball9.setdx((30)*((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball9.getdx());
						System.out.println((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball9.setfirenum(0);
                  	 
               }
               else if(ball10.getfirenum()==1)
               { 
                  ball10.setAngle(p2.getAngle());
                  ball10.setX(p2.getX());
                  ball10.setY(p2.getY());
                  ball10.setcount(0);
                  ball10.setDiameter(5);
                  ball10.setdy((-30)*(Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball10.getdy());
						System.out.println((Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball10.setdx((30)*((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball10.getdx());
						System.out.println((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball10.setfirenum(0);
                   
               }

            
					}               
            
								 
         		
			 
         		
               
            if(e.getKeyCode() == KeyEvent.VK_UP && pd.getY() > pd.getRadius()){//moves tank1 foreward
                pd.setX(pd.getX()+ Math.sin((double)(pd.getAngle()-1)/64 * (-2 * Math.PI))*(-10));   // move horizontally
         pd.setY(pd.getY()+ Math.cos((double)(pd.getAngle()-1)/64 * (-2 * Math.PI))*(-10)); //move vertically
         }  
            if(e.getKeyCode() == KeyEvent.VK_DOWN && pd.getY() < FRAME - pd.getRadius()){//moves tank1 backwards
                pd.setX(pd.getX()+ Math.sin((double)(pd.getAngle()-1)/64 * (-2 * Math.PI))*(10)); // move horizontally
        
         pd.setY(pd.getY()+ Math.cos((double)(pd.getAngle()-1)/64 * (-2 * Math.PI))*(10)); //move vertically
           }
            if(e.getKeyCode() == KeyEvent.VK_LEFT && pd.getX() > pd.getRadius())//rotates tank1 to the left
               pd.setAngle( pd.getAngle() - 1); 

               
            if(e.getKeyCode() == KeyEvent.VK_RIGHT && pd.getX() < FRAME - pd.getRadius()){//rotates tank1 to the right
                               pd.setAngle( pd.getAngle() + 1);
                              
                               
                               
            }
            
            if(e.getKeyCode() == KeyEvent.VK_W && p2.getY() > p2.getRadius()){ //moves tank2 forewards
                p2.setX(p2.getX()+ Math.sin((double)(p2.getAngle()-1)/64 * (-2 * Math.PI))*(-10));   // move horizontally
         p2.setY(p2.getY()+ Math.cos((double)(p2.getAngle()-1)/64 * (-2 * Math.PI))*(-10)); //move vertically
         }  
         
            if(e.getKeyCode() == KeyEvent.VK_S && p2.getY() < FRAME - p2.getRadius()){//moves tank2 backwards
                p2.setX(p2.getX()+ Math.sin((double)(p2.getAngle()-1)/64 * (-2 * Math.PI))*(10)); // move horizontally
        
         p2.setY(p2.getY()+ Math.cos((double)(p2.getAngle()-1)/64 * (-2 * Math.PI))*(10));//move vertically 
           }
           
            if(e.getKeyCode() == KeyEvent.VK_A && p2.getX() > p2.getRadius()) //rotates tank2 to the left
               p2.setAngle( p2.getAngle() - 1); 

               
            if(e.getKeyCode() == KeyEvent.VK_D && p2.getX() < FRAME - p2.getRadius()){//rotates tank2 to the right
                               p2.setAngle( p2.getAngle() + 1);
                              
                               
                               
            }

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
