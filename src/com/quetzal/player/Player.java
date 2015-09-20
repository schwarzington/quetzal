package com.quetzal.player;

import java.util.Comparator;

public class Player implements Comparable<Player> {
	private String first_name, last_name, position, fd_cost, team, teamAbb,
			full_name;
	private Double dk_avg_points, dk_cpp;
	private Long dk_cost;

	public static final Comparator<Player> CostPerPointComparator = new Comparator<Player>() {
		@Override
		public int compare(Player o1, Player o2) {
			Double player1;
			Double player2;
			
			try {
				player1 = o1.getDk_cpp();
				if(player1 < 0.00){
					player1 = 0.00;
				}
			} catch(NullPointerException e){
				player1 = 0.00;
			}
			
			try {
				player2 = o2.getDk_cpp();
				if(player2 < 0.00){
					player2 = 0.00;
				}
			} catch(NullPointerException e){
				player2 = 0.00;
			}
			return player1.compareTo(player2);
		}
	};

	public Player(String first, String last, String pos, String team_name,
			String abbreviation) {
		this.first_name = first.trim();
		this.last_name = last.trim();
		this.position = pos.trim();
		this.team = team_name.trim();
		this.teamAbb = abbreviation.trim();
		this.full_name = first_name + " " + last_name;
	}

	public Double getDk_cpp() {
		return dk_cpp;
	}

	public void setDk_cpp(Double dk_cpp) {
		this.dk_cpp = dk_cpp;
	}

	public Long getDk_cost() {
		return dk_cost;
	}

	public Double getDk_avg_points() {
		return dk_avg_points;
	}

	public void setDk_avg_points(Double dk_avg_points) {
		this.dk_avg_points = dk_avg_points;
	}

	public void setDk_cost(Long dk_cost) {
		this.dk_cost = dk_cost;
	}

	public String getTeamAbb() {
		return teamAbb;
	}

	public void setTeamAbb(String teamAbb) {
		this.teamAbb = teamAbb;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String toString() {
		return first_name + " " + last_name + " plays " + position
				+ " for the " + team + " (" + teamAbb
				+ ") at a DraftKings cost of " + dk_cost + " averaging "
				+ dk_avg_points + " at a Cost Per Point " + dk_cpp;
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

	@Override
	public int compareTo(Player player) {
		// TODO Auto-generated method stub
		if (this.equals(player)) {
			return 1;
		} else {
			return 0;
		}
	}

}
