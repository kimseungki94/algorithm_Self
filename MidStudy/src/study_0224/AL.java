package study_0224;

import java.awt.Window.Type;
import java.util.ArrayList;

public class AL {

	public static void main(String[] args) {
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		for (int i = 0; i < 24; i++) {
			arraylist.add(1);
		}
			int count = 0;
			arraylist.set(0, 0);
			while(true) {
			for (int i = 0; i < arraylist.size(); i++) {
				
				
				if(arraylist.get(i)==1 && count==2) {
					arraylist.set(i, 0);
					count=0;
				}
				if(arraylist.get(i)==1) {
					count++;
				}
				
			}
			if(count>10000) {
				break;
			}
			System.out.println(arraylist.toString());
			}
			
	}

}
