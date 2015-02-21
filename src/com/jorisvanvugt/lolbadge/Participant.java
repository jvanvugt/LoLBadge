package com.jorisvanvugt.lolbadge;

public class Participant {
	private String summonerName;
	private String teamName;
	private String rank;
	private String fileName;
	
	public Participant(String summonerName, String teamName, String rank) {
		if(summonerName.startsWith("?"))
			summonerName = summonerName.substring(1);
		this.summonerName = summonerName;
		this.teamName = teamName;
		this.rank = (rank.startsWith("Unranked")) ? rank.split(" ")[0] : rank;
		// Make the filename latexfriendly
		this.fileName = summonerName
				.replace('Ð', 'D')
				.replace('ñ', 'n')
				.replace('é', 'e')
				.replace('í', 'i')
				.replace('ø', 'o')
				.replace('ï', 'i')
				.replace('ä', 'a')
				.replace(' ', '_');
	}
	
	public String getSummonerName() {
		return summonerName;
	}
	public String getRank() {
		return rank;
	}
	
	public String getTeamName() {
		return teamName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	
	public String getFileName() {
		return fileName;
	}
	
}
