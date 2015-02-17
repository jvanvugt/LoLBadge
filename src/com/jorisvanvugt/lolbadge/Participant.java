package com.jorisvanvugt.lolbadge;

public class Participant {
	private String summonerName;
	private String teamName;
	private String rank;
	
	public Participant(String summonerName, String teamName, String rank) {
		this.summonerName = summonerName;
		this.teamName = teamName;
		this.rank = rank;
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
}
