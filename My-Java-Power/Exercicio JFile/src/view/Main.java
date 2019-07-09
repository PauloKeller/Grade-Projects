package view;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		Scanner scanner = new Scanner(new File("sample3.data"));
		//get integer
		int i = scanner.nextInt();
		
		scanner.close();
	}

}
