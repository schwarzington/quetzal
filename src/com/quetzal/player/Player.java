package com.quetzal.player;

public class Player {
	private String first_name, last_name, position, dk_cost, fd_cost, team, teamAbb;
	public Player(String first, String last, String pos, String team_name, String abbreviation){
		this.first_name = first.trim();
		this.last_name = last.trim();
		this.position = pos.trim();
		this.team = team_name.trim();
		this.teamAbb = abbreviation.trim();
	}
	
	public String toString(){
		return "Player Name: " + first_name + " " + last_name + " plays " + position + " for the " + team + " (" + teamAbb + ")"; 
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDk_cost() {
		return dk_cost;
	}
	public void setDk_cost(String dk_cost) {
		this.dk_cost = dk_cost;
	}
	public String getFd_cost() {
		return fd_cost;
	}
	public void setFd_cost(String fd_cost) {
		this.fd_cost = fd_cost;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	

}
