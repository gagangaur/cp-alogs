import java.lang.Thread;
import java.io.*;
class MultiThread extends Thread{
  MultiThread(){
    start();
  }
    public static void usingBufferedWritter(String Thread) throws IOException
    {
        String fileContent = "This is written by Thread"+Thread;
     
        BufferedWriter writer = new BufferedWriter(new FileWriter("E:/cpalgos/Threading/write.txt",true));
        writer.write(fileContent+"\n");
        writer.close();
    }
  public void run(){
    try{
      for(int i=0;i<5;i++)
    //   System.out.println("Thread "+Thread.currentThread().getId()+" is running "+(i+1)+" inside the FIRST FOR ");
    {
        Long thread = Thread.currentThread().getId();
        String THREAD = Long.toString(thread);
        usingBufferedWritter(THREAD);
    }
      Thread.sleep(1000);
      for(int i=0;i<5;i++)
      {
        Long thread = Thread.currentThread().getId();
        String THREAD = Long.toString(thread);
        usingBufferedWritter(THREAD);
    }
}
    catch(Exception e){
      System.out.println("Exception Caught");
    }
  }
}
class Main {
  public static void main(String[] args)  throws IOException {
    int n = 1;
    while(n-->0){
      MultiThread thread1 = new MultiThread();
      MultiThread thread2 = new MultiThread();
      try{
      // thread.join();
      }
      catch(Exception e){
        System.out.println("Exception Caught");
      }
    }
  }
}