import java.util.Scanner;

public class iqiyieat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int p=sc.nextInt();
        int[] liang=new int[n];
        for (int i = 0; i < n; i++) {
            liang[i]=sc.nextInt();
        }
        String tag;
        int i;
        while (m!=0){
            tag=sc.next();
            i=sc.nextInt();
            if (tag.equals("A"))
                liang[i-1]+=1;
            if (tag.equals("B"))
                liang[i-1]-=1;
            m--;
        }
        int num=liang[p-1];

        int l=0,r=liang.length-1;
        sort(liang,l,r);
        for (int i1=0;i1<liang.length;i1++)
        {
            if (num==liang[i1])
            {System.out.println(n-i1);break;}
        }
    }

    public static void sort(int[] a, int low, int high){
        int start = low;
        int end = high;
        int key = a[low];


        while(end>start){

            while(end>start&&a[end]>=key)
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }

            while(end>start&&a[start]<=key)
                start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }

        }

        if(start>low) sort(a,low,start-1);
        if(end<high) sort(a,end+1,high);
    }
}
