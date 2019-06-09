import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0){
      int ver = sc.nextInt();
      int edg = sc.nextInt();
      ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
      for(int i=0;i<=ver;i++){
        list.add(i,new ArrayList<Integer>());
      }
      for(int i=0;i<edg;i++){
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        list.get(v1).add(v2);
        list.get(v2).add(v1);
      }
      boolean result = new cycleDetect().isCyclic(list,ver);
      System.out.println(result);
      System.out.println(list);
    }
    sc.close();
  }
}
class cycleDetect{
  public boolean isCyclic(ArrayList<ArrayList<Integer>> list,int ver){
    int[] vis = new int[ver];
    new helper().initialize(vis);
    new helper().print(vis);
    for(int i = 0;i<list.size();i++){
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp = list.get(i);
      for(int j=0;j<temp.size();j++){
        
        int x = new DSU().find(vis,i);
        int y = new DSU().find(vis,temp.get(j));
        if(x==y){
          return true;
        }
        new DSU().union(vis,x,y);
      }
      new helper().print(vis);
    }
    return false;
  }
}
class DSU{
  public int find(int[] vis,int ind){
    if(vis[ind]==-1){
      return ind;
    }
    return find(vis,vis[ind]);
  }
  public void union(int[] vis,int x,int y){
    int xset = find(vis,x);
    int yset = find(vis,y);
    vis[xset] = yset;
  }
}
class helper{
  public void initialize(int[] vis){
    for(int i=0;i<vis.length;i++){
      vis[i]=-1;
    }
  }
  public void print(int[] vis){
    for(int i: vis){
      System.out.print(i+" ");
    }
    System.out.println();
  }
}