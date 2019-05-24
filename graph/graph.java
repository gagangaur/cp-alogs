import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0){
      int ver = sc.nextInt();
      int edg = sc.nextInt();
      ArrayList<ArrayList<Integer>> list = new ArrayList<>();
      for(int i=0;i<ver;i++){
        list.add(i,new ArrayList<Integer>());
      }
      for(int i=1;i<=edg;i++){
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        list.get(v1).add(v2);
        list.get(v2).add(v1);
      }
      boolean[] vis = new boolean[ver];
      System.out.println(list);
      new Traversal().dfs(0,list,vis);
      System.out.println();
      new Helper().reinitialize(vis, ver);
      new Traversal().iterativeDfs(0, list, vis);
      System.out.println();
      new Helper().reinitialize(vis, ver);
      new Traversal().BFS(0, list, vis);
      System.out.println();
    }
  }
}
class Traversal{
  void dfs(int src,ArrayList<ArrayList<Integer>> list,boolean[] vis){
    vis[src] = true;
    System.out.print(src+" ");
    ArrayList<Integer> temp = new ArrayList<Integer>();
    temp = list.get(src);
    for(int i=0;i<temp.size();i++){
        if (vis[temp.get(i)]==false){
          dfs(temp.get(i),list,vis);
        }
    }
  }
  void iterativeDfs(int src,ArrayList<ArrayList<Integer>> list,boolean[] vis){
    Stack<Integer> st = new Stack<>();
    st.push(src);
    while(st.empty() == false){
      int sr = st.pop();
      if(vis[sr]==false)
      System.out.print(sr+" ");
      vis[sr]=true;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp = list.get(sr);
        for(int i=temp.size()-1;i>=0;i--){
          if(vis[temp.get(i)]==false){
            st.push(temp.get(i));
          }
        }
    }
  }
  void BFS(int src,ArrayList<ArrayList<Integer>> list,boolean[] vis){
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(src);
    while(queue.size()!=0){
      int sr = queue.poll();
      if(vis[sr]==false){
      System.out.print(sr+" ");
    } 
    vis[sr]=true;
    ArrayList<Integer> temp = new ArrayList<>();
    temp = list.get(sr);
    for(int i=0;i<temp.size();i++) if(vis[temp.get(i)]==false) queue.add(temp.get(i));
    }
  }
}
class Helper{
  void reinitialize(boolean[] vis,int n){
    for(int i=0;i<n;i++) vis[i]=false;
  }
}