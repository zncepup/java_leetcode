public class rotate_image {
    public static void rotate(int [][] matrix){
        int n=matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j <n-i-1 ; j++) {
                int begin=matrix[i][j];
//                System.out.println(begin);
                int temp=swap(matrix,i,j,begin);
//                System.out.println(temp);
                int next_i=j;int next_j=n-i-1;
                while (!(next_i==i&&next_j==j)){
                    temp=swap(matrix,next_i,next_j,temp);
                    int t=next_i;
                    next_i=next_j;
                    next_j=n-t-1;
                }
            }
        }
    }
    public static int swap(int[][] nums,int i,int j,int temp){
        int res=nums[j][nums.length-i-1];
        nums[j][nums.length-i-1]=temp;
        return res;
    }

    public static void main(String[] args) {
//        int[][] tes={{1,2,3},{4,5,6},{7,8,9}};
        int[][] tes={{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(tes);
        for (int i = 0; i <tes.length ; i++) {
            for (int j = 0; j < tes.length; j++) {
                System.out.print(tes[i][j]);
            }System.out.println();
        }

    }
}
