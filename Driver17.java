	// Torbert, 7.20.06

   import javax.swing.JFrame;
    public class Driver17
   {
       public static void main(String[] args)
      { 
         JFrame frame = new JFrame("Unit2, Lab17");
         frame.setSize(1280, 1025);    //makes the mouse location correct
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         PrizePanel p = new PrizePanel();
         frame.setContentPane(p);
         p.requestFocus();
         frame.setVisible(true);
         
      }
   }
