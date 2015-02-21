package com.jorisvanvugt.lolbadge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class CMDCommand {
	
	private String command;
	
	public CMDCommand(String command){
		this.command = command;
	}
 
	public String run() {
		try{
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			StringBuilder output = new StringBuilder();
			while (true) {
			    line = r.readLine();
			    if (line == null)
			    	break;
			    output.append(line + "\n");
	        }
	        return output.toString();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return "";
	}
 
}