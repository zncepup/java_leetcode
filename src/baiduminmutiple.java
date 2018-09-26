import java.util.ArrayList;
import java.util.List;

public class baiduminmutiple {
    public static int maxProduct(int numNodes, List<Integer> values,List<List<Integer>> edges){
        List<Integer> noleaf=new ArrayList<>();
        List<Integer> leaf=new ArrayList<>();
        int[] allnodes=new int[numNodes];
        for (int i = 0; i < edges.size(); i++) {
            allnodes[edges.get(i).get(0)-1]=1;
        }
        for (int i = 0; i < allnodes.length; i++) {
            if (allnodes[i]==1)
                noleaf.add(i+1);
            else
                leaf.add(i+1);
        }
        System.out.println(noleaf);
        System.out.println(leaf);
        int[][] quan=new int[noleaf.size()][leaf.size()];
        for (int i = 0; i < noleaf.size(); i++) {
            dfs(quan,noleaf.get(i),noleaf.get(i),values.get(noleaf.get(i)),leaf,noleaf,values,edges);
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <noleaf.size() ; i++) {
            for (int j = 0; j <leaf.size() ; j++) {
                for (int k = j+1; k <leaf.size() ; k++) {
                    if(quan[i][j]!=0&&quan[i][k]!=0){
                        int len=quan[i][j]*quan[i][k]/values.get(noleaf.get(i));
                        if(len>max)
                            max=len;
                    }
                }
            }
        }
        return max;
    }
    public static void dfs(int[][] quan,int first,int start,int chegnji,List<Integer> leaf,List<Integer> noleaf,List<Integer> values,List<List<Integer>> edges){
        if (leaf.lastIndexOf(start)!=-1)
        {
            quan[noleaf.lastIndexOf(first)][leaf.lastIndexOf(start)]=chegnji;
            return;
        }
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).get(0)==start){
                dfs(quan,first,edges.get(i).get(1),chegnji*values.get(i),leaf,noleaf,values,edges);
            }
        }
    }

    public static void main(String[] args) {
        int numnodes=4;
        List<Integer> values=new ArrayList<>();
        values.add(-1);
        values.add(2);
        values.add(3);
        values.add(2);
        int[][] edge={{1,2},{1,3},{3,4}};
        List<List<Integer>> edges=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Integer> x=new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                x.add(edge[i][j]);
            }
            edges.add(x);
        }
        System.out.println(edges);
        int res=maxProduct(numnodes,values,edges);
        System.out.println(res);
    }
}
