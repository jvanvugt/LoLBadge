package com.jorisvanvugt.lolbadge;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class BadgeCreator {

	public void createBadges(ArrayList<Participant> participants) {
		for (Participant p : participants) {
			try {
				ImageIO.write(new LoLBadge(p).toImage(), "png", new File("badges\\" + p.getFileName() + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		System.out.println("Reading file");
		ArrayList<Participant> participants = new CSVReader().read("res\\badge_list.csv");
		System.out.println("Creating badges");
		new BadgeCreator().createBadges(participants);
		System.out.println("Creating PDF");
		new PDFCreator().createPDF(participants);
		System.out.println("Done!");
	}
}
