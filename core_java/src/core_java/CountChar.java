package core_java;

import java.util.HashMap;

public class CountChar {
	public static void main(String[] args) {
		String s = "hello java hello python ";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (map.get(ch[i]) == null) {
				map.put(ch[i], 2);
			} else {
				int count = map.get(ch[i]);
				count++;
				map.put(ch[i], count);
			}

		}
		System.out.println(map);
	}
}
