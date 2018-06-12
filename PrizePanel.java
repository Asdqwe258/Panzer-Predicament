//Kevin, Chris, Andrew
//6-12-18
//Period 5
//This class is the main driver of the game, it is responsible for making everything move and interact.
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   import java.lang.Object;
   public class PrizePanel extends JPanel
   {
      private static final int FRAME = 1500; //size of map
      private static final Color BACKGROUND = new Color(204, 204, 204);
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Map map;
      private Polkadot pd; //player1
      private Polkadot p2;//player2
       private Ball ball, ball2, ball3, ball4, ball5, ball6, ball7, ball8, ball9, ball10; //instantiates all the ammo
       private boolean[] inputArray = new boolean[8];//W,S,A,D,Up,Down,Left,Right
       private int tick = 0;

      private Timer w;
      private Timer w2;
      public ImageIcon t;//Image icon for tank1
      public ImageIcon t2;//Image icon for tank2 
      public int firec=1;
      int hits = 0;
      int hits2 = 0;
   	//constructor   
      public PrizePanel(Map m)
      {
         myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME,FRAME);
         map = m;
       
   
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
            
            tick++;
            if(tick > 10000){
            tick = 0;
            }
            
            if(inputArray[0]){// executes commands based on if a button is pressed or not
            move(2,p2.getX(),p2.getY(),p2.getAngle(),1);
            }
            if(inputArray[1]){
            move(2,p2.getX(),p2.getY(),p2.getAngle(),-1);
            }
            if(inputArray[2] && tick % 10 == 0){
            p2.setAngle(p2.getAngle() - 1);
            }
            if(inputArray[3] && tick % 10 == 0){
            p2.setAngle(p2.getAngle() + 1);
            }
            if(inputArray[4]){
            move(1,pd.getX(),pd.getY(),pd.getAngle(),1);
            }
            if(inputArray[5]){
            move(1,pd.getX(),pd.getY(),pd.getAngle(),-1);
            }
            if(inputArray[6] && tick % 10 == 0){
            pd.setAngle( pd.getAngle() - 1);
            }
            if(inputArray[7] && tick % 10 == 0){
            pd.setAngle( pd.getAngle() + 1);
            } 
                   
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
	    
            collide(ball6, pd);//checks if a ball has collided with a tank
            collide(ball7, pd);
            collide(ball8, pd);
            collide(ball9, pd);
            collide(ball10, pd);
            collide(ball, p2);
            collide(ball2, p2);
            collide(ball3, p2);
            collide(ball4, p2);
            collide(ball5, p2);
            collide(ball, pd);
            collide(ball2, pd);
            collide(ball3, pd);
            collide(ball4, pd);
            collide(ball5, pd);
            collide(ball6, p2);
            collide(ball7, p2);
            collide(ball8, p2);
            collide(ball9, p2);
            collide(ball10, p2);

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

            
             myBuffer.setFont(new Font("Monospaced", Font.BOLD, 50));
            myBuffer.drawString("Player 1: " + pd.getScore(), FRAME - 400, 120);
            myBuffer.drawString("Player 2: " + p2.getScore(), 25 , 120);

            
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
                  ball.setX(pd.getX()+170*(Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));//makes the ball spawn in front of instead of inside the tank.
                  ball.setY(pd.getY()+170*-(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball.setcount(0);
                  ball.setDiameter(5);
                  ball.setdy((-2)*(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball.getdy());
						System.out.println((Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball.setdx((2)*((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball.getdx());
						System.out.println((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball.setfirenum(0);
               }
               else if(ball2.getfirenum()==1)
               {   
					   
                  ball2.setAngle(pd.getAngle());
                  ball2.setX(pd.getX()+170*(Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball2.setY(pd.getY()+170*-(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball2.setcount(0);
                  ball2.setDiameter(5);
                  ball2.setdy((-2));
						System.out.println(ball2.getdy());
						System.out.println((Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball2.setdx((2)*((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball2.getdx());
						System.out.println((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball2.setfirenum(0);
	  
               }
               else if(ball3.getfirenum()==1)
               {  
                  ball3.setAngle(pd.getAngle());
                  ball3.setX(pd.getX()+170*(Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball3.setY(pd.getY()+170*-(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball3.setcount(0);
                  ball3.setDiameter(5);
                  ball3.setdy((-2)*(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball3.getdy());
						System.out.println((Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball3.setdx((2)*((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball3.getdx());
						System.out.println((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball3.setfirenum(0);

               }
                  
               else if(ball4.getfirenum()==1)
               {                   
                  ball4.setAngle(pd.getAngle());
                  ball4.setX(pd.getX()+170*(Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball4.setY(pd.getY()+170*-(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball4.setcount(0);
                  ball4.setDiameter(5);
                  ball4.setdy((-2)*(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball4.getdy());
						System.out.println((Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball4.setdx((2)*((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball4.getdx());
						System.out.println((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball4.setfirenum(0);
                  	 
               }
               else if(ball5.getfirenum()==1)
               { 
                  ball5.setAngle(pd.getAngle());
                  ball5.setX(pd.getX()+170*(Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball5.setY(pd.getY()+170*-(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball5.setcount(0);
                  ball5.setDiameter(5);
                  ball5.setdy((-2)*(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball5.getdy());
						System.out.println((Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball5.setdx((2)*((Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI)))));
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
                  ball6.setX(p2.getX()+170*(Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball6.setY(p2.getY()+170*-(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball6.setcount(0);
                  ball6.setDiameter(5);
                  ball6.setdy((-2)*(Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball6.getdy());
						System.out.println((Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball6.setdx((2)*((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball6.getdx());
						System.out.println((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball6.setfirenum(0);
               }
               else if(ball7.getfirenum()==1)
               {   
					   
                  ball7.setAngle(p2.getAngle());
                  ball7.setX(p2.getX()+170*(Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball7.setY(p2.getY()+170*-(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball7.setcount(0);
                  ball7.setDiameter(5);
                  ball7.setdy((-2)*(Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball7.getdy());
						System.out.println((Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball7.setdx((2)*((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball7.getdx());
						System.out.println((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball7.setfirenum(0);
               }
               else if(ball8.getfirenum()==1)
               {  
                  ball8.setAngle(p2.getAngle());
                  ball8.setX(p2.getX()+170*(Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball8.setY(p2.getY()+170*-(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball8.setcount(0);
                  ball8.setDiameter(5);
                  ball8.setdy((-2)*(Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball8.getdy());
						System.out.println((Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball8.setdx((2)*((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball8.getdx());
						System.out.println((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball8.setfirenum(0);
               }
                  
               else if(ball9.getfirenum()==1)
               {                   
                  ball9.setAngle(p2.getAngle());
                  ball9.setX(p2.getX()+170*(Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball9.setY(p2.getY()+170*-(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball9.setcount(0);
                  ball9.setDiameter(5);
                  ball9.setdy((-2)*(Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball9.getdy());
						System.out.println((Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball9.setdx((2)*((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball9.getdx());
						System.out.println((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball9.setfirenum(0);
                  	 
               }
               else if(ball10.getfirenum()==1)
               { 
                  ball10.setAngle(p2.getAngle());
                  ball10.setX(p2.getX()+170*(Math.sin((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball10.setY(p2.getY()+170*-(Math.cos((pd.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball10.setcount(0);
                  ball10.setDiameter(5);
                  ball10.setdy((-2)*(Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						System.out.println(ball10.getdy());
						System.out.println((Math.cos((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
						ball10.setdx((2)*((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI)))));
						System.out.println(ball10.getdx());
						System.out.println((Math.sin((p2.getAngle()-1)/64.0 * (2 * Math.PI))));
                  ball10.setfirenum(0);
                   
               }

            
					}               
            
								 
         		
			 
         		
               
            if(e.getKeyCode() == KeyEvent.VK_UP && pd.getY() > pd.getRadius()){//moves tank1 foreward
            inputArray[4] = true;
             }  
            if(e.getKeyCode() == KeyEvent.VK_DOWN && pd.getY() < FRAME - pd.getRadius()){//moves tank1 backwards
            inputArray[5] = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT && pd.getX() > pd.getRadius())//rotates tank1 to the left
            inputArray[6] = true;

               
            if(e.getKeyCode() == KeyEvent.VK_RIGHT && pd.getX() < FRAME - pd.getRadius()){//rotates tank1 to the right
            inputArray[7] = true;
                            
                              
                               
                               
            }
            
            if(e.getKeyCode() == KeyEvent.VK_W && p2.getY() > p2.getRadius()){ //moves tank2 forewards
            inputArray[0] = true;
             }  
         
            if(e.getKeyCode() == KeyEvent.VK_S && p2.getY() < FRAME - p2.getRadius()){//moves tank2 backwards
            inputArray[1] = true;
            }
           
            if(e.getKeyCode() == KeyEvent.VK_A && p2.getX() > p2.getRadius()) //rotates tank2 to the left
            inputArray[2] = true;
               

               
            if(e.getKeyCode() == KeyEvent.VK_D && p2.getX() < FRAME - p2.getRadius()){//rotates tank2 to the right
            inputArray[3] = true;
                              
                              
                               
                               
            }

      }
      public void keyReleased(KeyEvent e){
       if(e.getKeyCode() == KeyEvent.VK_UP && pd.getY() > pd.getRadius()){//moves tank1 foreward
            inputArray[4] = false;
             }  
            if(e.getKeyCode() == KeyEvent.VK_DOWN && pd.getY() < FRAME - pd.getRadius()){//moves tank1 backwards
            inputArray[5] = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT && pd.getX() > pd.getRadius())//rotates tank1 to the left
            inputArray[6] = false;
              
            if(e.getKeyCode() == KeyEvent.VK_RIGHT && pd.getX() < FRAME - pd.getRadius()){//rotates tank1 to the right
            inputArray[7] = false;
                             
                              
                               
                               
            }
            
            if(e.getKeyCode() == KeyEvent.VK_W && p2.getY() > p2.getRadius()){ //moves tank2 forewards
            inputArray[0] = false;
             }  
         
            if(e.getKeyCode() == KeyEvent.VK_S && p2.getY() < FRAME - p2.getRadius()){//moves tank2 backwards
            inputArray[1] = false;
            }
           
            if(e.getKeyCode() == KeyEvent.VK_A && p2.getX() > p2.getRadius()) //rotates tank2 to the left
            inputArray[2] = false;
               
            if(e.getKeyCode() == KeyEvent.VK_D && p2.getX() < FRAME - p2.getRadius()){//rotates tank2 to the right
            inputArray[3] = false;
                             
                              
                            
      }
      }
 }
 
      
   	
      private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
      }
      private void move(int k, double x, double y, int angle, double speed){//this moves the tank, but moves it in the opposite direction if the next position would be in a wall.
			if(!isInWall(x + Math.sin(Math.toRadians((angle-1)*5.625))*(-speed),y + Math.cos(Math.toRadians((angle-1)*5.625))*(-speed))){
            if(k == 1){
                pd.setX(x + Math.sin(Math.toRadians((angle-1)*5.625))*(speed));   // move horizontally
                pd.setY(y + Math.cos(Math.toRadians((angle-1)*5.625))*(-speed)); //move vertically
            }
            if(k == 2){
                p2.setX(x + Math.sin(Math.toRadians((angle-1)*5.625))*(speed));   // move horizontally
                p2.setY(y + Math.cos(Math.toRadians((angle-1)*5.625))*(-speed)); //move vertically
            }
         }


               
		}
	private boolean isInWall(double x, double y){//this non-functional piece of code checks if a certain position is in the same position of an active wall.
		for(int k = 0; k < map.getMapData().length; k++){
			for(int i = 0; x < map.getMapData()[0].length; x++){
				for(int o = 0; o < 2; o++){
					if(map.getBarrier(k,i,o)){
						if(o == 0){
							if((x > k*(FRAME / map.getMapData().length) + (FRAME / map.getMapData().length) && x < k*(FRAME / map.getMapData().length) + 30 + (FRAME / map.getMapData().length)) && (y > i*(FRAME / map.getMapData()[0].length) && y < i*(FRAME / map.getMapData()[0].length) + (FRAME / map.getMapData()[0].length))){
							return true;
							}
						}
						if(o == 1){
							if((y > i*(FRAME / map.getMapData()[0].length) + (FRAME / map.getMapData()[0].length) && y < i*(FRAME / map.getMapData()[0].length) + 30 + (FRAME / map.getMapData()[0].length)) && (x > k*(FRAME / map.getMapData().length) && x < k*(FRAME / map.getMapData().length) + (FRAME / map.getMapData().length))){
   						return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
    private void collide(Ball b, Polkadot p)
      {
         double d = distance(b.getX(), b.getY(), p.getX(), p.getY());
         if( d <= b.getRadius() + p.getRadius())
         {
            p.addScore();
            p.jump(400, 400);
            hits += 1;
         }  
      }


            
  

   }
