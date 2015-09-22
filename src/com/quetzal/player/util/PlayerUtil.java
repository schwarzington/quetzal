package com.quetzal.player.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.quetzal.player.Player;

public class PlayerUtil {
	private final static String DEPTH_CHART_URL = "http://fftoolbox.scout.com/football/depth-charts.cfm";
	private final static String HISTORICAL_HEAD_TO_HEAD_URL = "http://fftoolbox.scout.com/football/head-to-head-stats.cfm?player_id=";

	public static ArrayList<Player> populatePlayers(ArrayList<String> positions)
			throws IOException {
		boolean allTrue = "ALL".equals(positions.get(0));
		ArrayList<Player> players = new ArrayList<Player>();
		Document doc = Jsoup.connect(DEPTH_CHART_URL).get();
		Elements teams = doc.select("div.team");
		HashMap<String, ArrayList<String>> draftKingsMap = DraftKingsUtil
				.getDraftKings();
		for (Element team : teams) {
			String teamHold = team.select("h3 > a").first().text();
			String abbreviation = team.select("h3 > a").first().attr("href")
					.split("=")[1];
			for (Element playerHTML : team.select("ul > li")) {
				String playerId = playerHTML.select("a").attr("href").split("=")[1];
				String[] playerArray = playerHTML.text().split(" ");
				String surname = "";
				try {
					surname = playerArray[3];
				} catch (Exception e) {

				}

				if (positions.contains(playerHTML.text().split(" ")[0])
						|| allTrue) {
					Player player = new Player(playerArray[1], playerArray[2]
							+ surname.trim(), playerArray[0], teamHold,
							abbreviation, playerId);
					try {
						ArrayList<String> playerDKInfo = draftKingsMap
								.get(player.getFull_name());
						player.setDk_cost(Long.parseLong(playerDKInfo.get(0)));
						player.setDk_avg_points(Double.parseDouble(playerDKInfo
								.get(1)));
						player.setDk_cpp(player.getDk_cost()
								/ player.getDk_avg_points());
						player.setOpponentAbb(playerDKInfo.get(2));
						player.setHistorical_avg_vs_opp(getHistoricalAvgVsOpp(player.getPlayer_id(), player.getOpponentAbb()));
						players.add(player);
					} catch (NullPointerException e) {

					}
				}
			}
		}
		
		//This is a special section for the Defenses
		if(positions.contains("DST") || positions.get(0) == "ALL")
		{
			String[] teamNames = {"Ravens", "Cardinals", "Bills", "Falcons", "Bengals", "Panthers", "Browns", "Bears", "Broncos", "Cowboys", "Texans", "Lions", "Colts", "Packers", "Jaguars", "Vikings", "Chiefs", "Saints", "Dolphins", "Giants", "Patriots", "Eagles", "Jets", "Rams", "Raiders", "49ers", "Steelers", "Seahawks", "Chargers", "Buccaneers", "Titans", "Redskins"};
			for(int i = 0; i < teamNames.length; i++){
				Player player = new Player(teamNames[i], "", "DST", teamNames[i],teamNames[i], "0000");
				try {
					ArrayList<String> playerDKInfo = draftKingsMap
							.get(player.getFull_name());
					player.setDk_cost(Long.parseLong(playerDKInfo.get(0)));
					player.setDk_avg_points(Double.parseDouble(playerDKInfo
							.get(1)));
					player.setDk_cpp(player.getDk_cost()
							/ player.getDk_avg_points());
					player.setOpponentAbb(playerDKInfo.get(2));
					players.add(player);
				} catch (NullPointerException e) {

				}
			}
		}
		return players;
	}
	
	private static double getHistoricalAvgVsOpp(String id, String opponent) throws IOException{
		Document doc = Jsoup.connect(HISTORICAL_HEAD_TO_HEAD_URL + id + "&opponent=" + opponent).get();
		Elements statrows = doc.select("tr.statsline");
		Double total = 0.00;
		int count = 0;
		for(Element row: statrows){
			total += Double.parseDouble(row.select("td.r").text());
			count++;
		}
		return total / count;
		
	}

}
