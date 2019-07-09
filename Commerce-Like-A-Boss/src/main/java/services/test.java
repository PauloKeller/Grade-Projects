package services;

import model.Client;

public class test {
	
	public static Client getCLient() {
		Client client = new Client();
		client.setName("paulo");
		return client;
	}
	
	public static String hello() {
		return getCLient().getName();
	}

}
