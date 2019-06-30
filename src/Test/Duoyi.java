package Test;


public class Duoyi {

    public static void main(String[] args) {
      oddMagicSquare(3,1);
    }

    public static int[][] oddMagicSquare(int n,int start){
        if(n%2 == 0) {
            return null;
        }
        int[][] result = new int[n][n];
        int row = 0;
        int col = n/2;
        for(int i=start;i<=n*n+start-1;i++) {
            result[row][col] = i;
            int nextrow = (row+n-1)%n;
            int nextcol = (col+1)%n;
            if(result[nextrow][nextcol]!=0) {
                row = (row+1)%n;
            }else {
                row = nextrow;
                col = nextcol;
            }
        }
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
        return result;
    }
}
