import java.lang.Thread;
class MultiThread extends Thread{
  MultiThread(){
    start();
  }
  public void run(){
    try{
      for(int i=0;i<5;i++)
      System.out.println("Thread "+Thread.currentThread().getId()+" is running "+(i+1)+" inside the FIRST FOR ");
      Thread.sleep(1000);
      for(int i=0;i<5;i++)
      System.out.println("Thread "+Thread.currentThread().getId()+" is running "+(i+1)+" inside the SECOND FOR ");
    }
    catch(Exception e){
      System.out.println("Exception Caught");
    }
  }
}
class Main {
  public static void main(String[] args) {
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