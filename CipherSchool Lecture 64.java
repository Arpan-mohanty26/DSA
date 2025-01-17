
//lecture64
package dp;
public class EditDistance {
    static int edit(String s1, String s2, int m, int n) {
        if (m == 0) return m;
        if (n == 0) return n;
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return edit(s1, s2, m - 1, n - 1);
        }
        //if last characters are not equal

        int replace = 1 + edit(s1, s2, m - 1, n - 1);
        int insert = 1 + edit(s1, s2, m, n - 1);
        int delete = 1 + edit(s1, s2, m - 1, n);
   return Math.min(replace,Math.min(insert,delete));
    }

static int editM(String s1,String s2,int m,int n,int dp[][]){
        if(n==0)return n;
        if(m==0)return m;
        if(s1.charAt(m-1)== s2.charAt(n-1)){
            return edit(s1,s2,m-1,n-1);
        }
        //if last characters are not equal
    int replace = 1 + editM(s1,s2,m-1,n-1,dp);
        int insert = 1+editM(s1,s2,m,n-1,dp);
        int delete = 1+editM(s1,s2,m-1,n,dp);
        return Math.min(replace ,Math.min(insert,delete));
        dp[m][n] =Math.min(replace,Math.min(insert,delete));
        return dp[m][n];

        static int editT(String s1,String s2,int m,int n){
            if(m==0)return m;
            if(n==0)return n;

            int dp[][] = new int [m+1][n+1];
            for(int i=0;i<m+1;i++){
                for(int j=0;j<n+1;j++){
                    if (i == 0) {
                        dp[i][j]=j;
                    }
                    else if(j==0){
                        dp[i][j]=i;
                    }
                    else if(s1.charAt(i-1)==s2.charAt(j-1))//if last character are equal
                    {
                        dp[i][j] =dp[i-1][j-1];

                    }
                    else{//when last character not equal
                        dp[i][j] =dp[i-1][j-1].Math.min(dp[i][j-1],dp[i-1][j]);

                    }
                }
            }
    }
    return dp[m][n];
}
public static void main(String args[]){
    String s1 = "abc";
    String s2 = "abd";
    int m = s1.length();
    int n = s2.length();
    System.out.println(edit(s1,s2,m,n));
    int dp[][] = new int [m+1] [n+1];
    System.out.println(editM(s1,s2,m,n,dp));
}
}
