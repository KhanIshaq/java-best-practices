package chapter6;

public class Puzzler {

	public static void main(String[] args) {
		short i = 1, j = 0;
		while(i!=0) {
			i>>>=1; // >>> doesn't do sign extension
			j++;
		}
		System.out.println(j);
	}
}
