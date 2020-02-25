package study_0225;

public class basic01 {

	public static void main(String[] args) {
		System.out.println(func4(1024));

	}
	private static int func4(int index) {
		int max=1;
		while(max<index) {
			max*=2;
		}
		return max;
	}
}

