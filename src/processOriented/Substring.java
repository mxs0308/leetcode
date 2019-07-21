package processOriented;

import java.util.HashMap;
import java.util.Map;

public class Substring {

	public int lengthOfLongestSubstring(String s) {
		//窗口滑动
		int n = s.length(), ans = 0;   
		Map<Character, Integer> map = new HashMap<>();
		//i为开始位，j为结束位
		for (int j = 0, i = 0; j < n; j++) {           
			if (map.containsKey(s.charAt(j))) {           
				i = Math.max(map.get(s.charAt(j)), i);  //i往后跳，去掉重复
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);    
		} 
		return ans;
	}
	
	//Test
	public static void main(String[] args) {
		Substring test=new Substring();
		
		int m =test.lengthOfLongestSubstring("abcabcbb");
		System.out.println(m);
		
		m=test.lengthOfLongestSubstring("bbbbb");
		System.out.println(m);
		
		m=test.lengthOfLongestSubstring("pwwkew");
		System.out.println(m);
		
	}
}