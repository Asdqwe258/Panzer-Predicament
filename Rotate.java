import java.awt.*;
import javax.swing.*;
public class Rotate extends JPanel{
Image image;
private int angleChange;
private int angle = 180;
public Rotate(Image i, int x){
super();
image = i;
angleChange = x;
}
public void paintComponent(Graphics g){

         Graphics2D g2d=(Graphics2D)g; 
         g2d.translate(angle + angleChange, 0); 
         g2d.rotate((angle - angleChange) / 10);  
         g2d.drawImage(image, 0, 0, 200, 200, this);
         angle -= angleChange;
    }
    
    public int getAngle() {
    return angle;
}

   }