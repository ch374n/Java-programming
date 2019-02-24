
public class RunLengthEncoding {
	public static void main(String[] args) {
		String s = "cccchhetaannnn";
		String d = encode(s);
		System.out.println("original : " + s + " encoded : " + d);
		s = decode(d);
		System.out.println("encoded : " + d + " decoded : " + s);
	}
	public static String encode(String s) {
		int start = 0, count = 0, end = 0;
		String sb = "";
		while(start < s.length()) {
			count = 0;
			char curr = s.charAt(start);			
			while(end < s.length() && s.charAt(end) == curr) {
					count++;
					end++;
			}
			sb += count + "" + curr;
			start = end;
		}
		return sb;
	}
	public static String decode(String s) {
			int start = 0, end = 1;
			String sb = "";
			while(start < s.length()) {
				char curr = s.charAt(end);
				if(Character.isDigit(s.charAt(end))) {
					end++;
				}
				String num = s.substring(start, end);
				int count = Integer.parseInt(num);
				for(int i = 0; i < count; i++) {
					sb += curr;
				}
				start = end + 1;
				end = start + 1;
			}
			return sb;
	}
}