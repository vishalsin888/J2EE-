package javaBasic;

import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {

		String str = "This is a java lecture";
		StringTokenizer stoken = new StringTokenizer(str," ");
		while (stoken.hasMoreElements()) {
			System.out.println(stoken.nextToken());
			
		}
		
		String[] strArr = str.split(" ");
		for (String strs : strArr) {
			System.out.println(strs);
		}
	}

}
