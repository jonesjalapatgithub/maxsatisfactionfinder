package com.jones.maxsatisfaction.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ReadData {

	static Scanner scan = new Scanner(System.in);
	
	@Value("${filelocation.path}")
	private String filelocation;

	public static int captureTime() {
		boolean validData = false;
		int number = 0;
		do {
			System.out.println("Enter the time needed for eating an item below : ");
			try {
				number = scan.nextInt();// tries to get data. Goes to catch if
										// invalid data
				validData = true;// if gets data successfully, sets boolean to
									// true
			} catch (InputMismatchException e) {
				// executes when this exception occurs
				System.out.println("Input has to be a number. ");
			}
		} while (validData == false);// loops until validData is true
		return number;
	}

	
	public  Map<Integer, Integer> readFile() throws IOException {
		String delimiter = " ";
		Map<Integer, Integer> map = new HashMap<>();
		try (Stream<String> lines = Files.lines(Paths.get(filelocation))) {
			lines.filter(line -> line.contains(delimiter))
					.forEach(line -> map.putIfAbsent(Integer.parseInt(line.split(delimiter)[0]),
							Integer.parseInt(line.split(delimiter)[1])));
			
		}
		
		return map;
	}

}
