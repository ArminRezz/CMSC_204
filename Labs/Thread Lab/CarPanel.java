import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;
	
	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
	}
	public void startAnimation()
	   {
	      class AnimationRunnable implements Runnable
	      {
	         public void run()
	         {
	            try
	            {
	               while(true)
	            //for(int i=0;i<200;i++)
	               {
	            	   direction = carQueue.deleteQueue();
	            	   int deltay,x1=x,y1=y;
	            	   int deltax=deltay=10;
	            	   switch(direction) {
		            	   case 0:
		            		   y1=y1-deltay;
		            		   break;
		            	   case 1:
		            		   y1=y1+deltay;
		            		   break;
		            	   case 2:
		            		   x1=x1+deltax;
		            		   break;
		            	   case 3:
		            		   x1=x1-deltax;
		            		   break;
	            	   }
	            	   if(x1<0||x1>300) {
	            		   deltax=deltax*-1;
	            	   }
	            	   if(y1<0||y1>400) {
	            		  deltay=deltay*-1;
	            	   }
	            	   switch(direction) {
	            	   case 0:
	            		   y=y-deltay;
	            		   break;
	            	   case 1:
	            		   y=y+deltay;
	            		   break;
	            	   case 2:
	            		   x=x+deltax;
	            		   break;
	            	   case 3:
	            		   x=x-deltax;
	            		   break;
            		   }
	            	   repaint();
	            	   Thread.sleep(delay*1000);
	            	   
	               }
	            }
	            catch (InterruptedException exception)
	            {
	            	
	            }
	            finally
	            {
	            	
	            }
	         }
	      }
	      
	      Runnable r = new AnimationRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2,x,y);    
   }
}