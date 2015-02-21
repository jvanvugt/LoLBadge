package com.jorisvanvugt.lolbadge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CSVReader {
	
	public ArrayList<Participant> read(String filePath){
		ArrayList<Participant> participants = new ArrayList<Participant>(); 
		try {
			Files.readAllLines(Paths.get(filePath)).forEach(line -> {
				String[] values = line.split(",");
				participants.add(new Participant(values[0], values[3], values[1] + " " + values[2]));
			}
			);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return participants;
	}
}
