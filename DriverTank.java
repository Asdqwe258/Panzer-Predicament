//Kevin, Chris, Andrew
//6-12-18
//Period 5

   import javax.swing.JFrame;
    public class DriverTank
   {
       public static void main(String[] args)
      { 
         JFrame frame = new JFrame("Unit2, Lab17");
         frame.setSize(1280, 1025);    //makes the mouse location correct
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Map map = new Map(6,6);
         map.generateBarrier(2,1,0);
         map.generateBarrier(2,2,0);
         map.generateBarrier(2,2,1);
         map.generateBarrier(2,3,0);
         TankPanel p = new TankPanel(map);
         frame.setContentPane(p);
         p.requestFocus();
         frame.setVisible(true);
         
      }
   }
