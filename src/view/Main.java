package view;

import pub_sub.Publisher;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		Publisher pub = new Publisher();
		pub.publishMessage();
		
	}

}
