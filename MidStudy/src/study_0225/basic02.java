package study_0225;

public class basic02 {

	public static void main(String[] args) {
		System.out.println(func1(36));

	}
	private static int func1(int index) {
		int ret=0;
		for(int i=1;i<=index;i++) {
			if(i*i==index) return 1;
			else ret =0;
		}
		return ret;	
	}
}

