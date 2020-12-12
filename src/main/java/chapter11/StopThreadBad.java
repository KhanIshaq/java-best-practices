package chapter11;

import java.util.concurrent.TimeUnit;

// Broken! - How long would you expect this program to run?
   public class StopThreadBad {
       private static boolean stopRequested;
       public static void main(String[] args)
               throws InterruptedException {
           Thread backgroundThread = new Thread(() -> {
               int i = 0;
               while (!stopRequested) {
            	   System.out.println(i);
            	   i++;
               }
           });
           backgroundThread.start();
           TimeUnit.SECONDS.sleep(1);
           stopRequested = true;
       }
}