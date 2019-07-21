package processOriented;

public class RegularExpression {
	
    public boolean isMatch(String s, String p) {
    	//动态规划
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenS+1][lenP+1];
        for(int i = 0; i<lenS; i++) {// 首先dp二维数组初始化为false
            for(int j = 0;j< lenP; j++) {
                dp[i][j] = false;
            }
        }
        dp[0][0] = true;// 表示S和P字符串均为空时当然相等，则dp[0][0] = true;
        for(int j = 0;j< lenP; j++) {
            if(p.charAt(j) == '*' && j > 0)
                dp[0][j+1] = dp[0][j-1];
        }
        for(int i = 0; i < lenS; i++) {
            for(int j = 0; j < lenP; j++) {
                if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') { //p[j]不为'*'时的状态转移；
                    dp[i+1][j+1] = dp[i][j];//继承上个状态

                } else if(p.charAt(j) == '*') { //p[j]为'*'时的状态转移；
                    dp[i+1][j+1] = ((dp[i][j-1] && (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.'))//匹配1个p[j-1]
                            || dp[i+1][j-1] //匹配0个p[j-1]
                            		|| (dp[i][j+1] && ((s.charAt(i) == p.charAt(j-1)) || p.charAt(j-1) == '.')));//匹配n个p[j-1]
                }               
            }
        }
        return dp[lenS][lenP];
    }
	
	//Test
	public static void main(String[] args) {
		RegularExpression test = new RegularExpression();
		
		boolean m=test.isMatch("aa", "a");
		System.out.println(m);
		
		m=test.isMatch("aa", "a*");
		System.out.println(m);
		
		m=test.isMatch("ab", ".*");
		System.out.println(m);
		
		m=test.isMatch("aab", "c*a*b");
		System.out.println(m);
		
		m=test.isMatch("mississippi",  "mis*is*p*.");
		System.out.println(m);
	}
}

