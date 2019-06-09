import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int ver = sc.nextInt();
            int edg = sc.nextInt();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for(int i=0;i<=ver;i++){
                list.add(i,new ArrayList<Integer>());
            }
            for(int i=0;i<edg;i++){
              int v1 = sc.nextInt();
              int v2 = sc.nextInt();
              list.get(v1).add(v2);
              list.get(v2).add(v1);
            }
            System.out.println(list+" "+list.size());
            // boolean result = new DetectCycle().BFS_isCyclic(list, ver);
            boolean result1 = new DetectCycle().DFS_isCyclic(list, ver);
            if(result1==false){
              System.out.println("Loop Exsists");
            }
            else{
              System.out.println("Loop donot exsists");
            }
        }
        sc.close();
    }
}
class DetectCycle{
  public boolean BFS_isCyclic(ArrayList<ArrayList<Integer>> list,int ver){
    int[] vis = new int[ver+1];
    new Helper().initialization(vis);
    // new Helper().print(vis);
    Queue<Integer> q = new LinkedList<Integer>();
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    tmp = list.get(0);
    for(int i : tmp){
      q.add(i);
      vis[i]=0;
    }
    // q.add(0);
    // vis[0]=0;
    while(q.size()!=0){
      int pop = q.poll();
      vis[pop]=1;
      ArrayList<Integer> arr = new ArrayList<Integer>();
      arr = list.get(pop);
      for(int i: arr){
        if(vis[i]==0){
          return false;
        }
        else{
          if (vis[i]==1);
        else{
          q.add(i);
          vis[i]=0;}
        }
      }
    }
    return true;
  }

  public boolean DFS_isCyclic(ArrayList<ArrayList<Integer>> list,int ver){
    int[] vis = new int[ver+1];
    // Helper().initialization(vis);
    Stack<Integer> s = new Stack<Integer>();
    ArrayList<Integer> tmp = new ArrayList<>();
    tmp=list.get(0);
    for(int i : tmp){
      s.push(i);
    }
    while(!s.isEmpty()){
      int pop = s.pop();
      vis[pop]=1;
      ArrayList<Integer> arr = new ArrayList<>();
      arr = list.get(pop);
      for(int i : arr){
        if(vis[i]==1);
        else if(vis[i])
      }
    }
    return true;
  }
}
class Helper{
  public void initialization(int[] arr){
    for(int i=0;i<arr.length;i++){
      arr[i]=-1;
    }
  }
  public void print(int[] arr){
    for(int i:arr){
      System.out.print(i+" ");
    }
    System.out.println();
  }
}