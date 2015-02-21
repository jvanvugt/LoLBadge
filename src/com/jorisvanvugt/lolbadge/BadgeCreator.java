package com.jorisvanvugt.lolbadge;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class BadgeCreator {

	public void createBadges(ArrayList<Participant> participants) {
		for (Participant p : participants) {
			try {
				ImageIO.write(new LoLBadge(p).toImage(), "png", new File("badges\\" + p.getSummonerName().replace(' ', '_') + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		ArrayList<Participant> participants = new ArrayList<Participant>();
		participants.add(new Participant("Joris", "Duurt Kor", "Platinum IV"));
		participants.add(new Participant("Rahazan", "Duurt Lan", "Bronze VI"));
		participants.add(new Participant("ProperChaos", "TeamO", "Diamond I"));
		participants.add(new Participant("Combustion Man", "Team Tango", "Silver III"));
		participants.add(new Participant("Fight4MyLife", "Team Tango", "Gold V"));
		
		new BadgeCreator().createBadges(participants);
		new PDFCreator().createPDF(participants);
	}

}
