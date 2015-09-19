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
							abbreviation);
					try {
						ArrayList<String> playerDKInfo = draftKingsMap
								.get(player.getFull_name());
						player.setDk_cost(Long.parseLong(playerDKInfo.get(0)));
						player.setDk_avg_points(Double.parseDouble(playerDKInfo
								.get(1)));
						player.setDk_cpp(player.getDk_cost()
								/ player.getDk_avg_points());
						players.add(player);
					} catch (NullPointerException e) {

					}
				}
			}
		}

		return players;
	}


	private static void print(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width - 1) + ".";
		else
			return s;
	}
}
