package com.quetzal.player.util;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.quetzal.player.Player;

public class PlayerUtil {
	private final static String DEPTH_CHART_URL = "http://fftoolbox.scout.com/football/depth-charts.cfm";

	public static ArrayList<Player> populatePlayers()
			throws IOException {
		ArrayList<Player> players = new ArrayList<Player>();
		Document doc = Jsoup.connect(DEPTH_CHART_URL).get();
		Elements teams = doc.select("div.team");
		for (Element team : teams) {
			String teamHold = team.select("h3 > a").first().text();
			String abbreviation = team.select("h3 > a").first().attr("href").split("=")[1];
			for (Element playerHTML : team.select("ul > li")) {
				Player player = new Player(playerHTML.text().split(" ")[1], playerHTML.text().split(" ")[2], playerHTML.text().split(" ")[0], teamHold, abbreviation);
				players.add(player);
			}
		}

		return players;
	}
	
	public static ArrayList<Player> populatePlayersByPosition(ArrayList<String> positions)
			throws IOException {
		ArrayList<Player> players = new ArrayList<Player>();
		Document doc = Jsoup.connect(DEPTH_CHART_URL).get();
		Elements teams = doc.select("div.team");
		for (Element team : teams) {
			String teamHold = team.select("h3 > a").first().text();
			String abbreviation = team.select("h3 > a").first().attr("href").split("=")[1];
			for (Element playerHTML : team.select("ul > li")) {
				if(positions.contains(playerHTML.text().split(" ")[0])){
					Player player = new Player(playerHTML.text().split(" ")[1], playerHTML.text().split(" ")[2], playerHTML.text().split(" ")[0], teamHold, abbreviation);
					players.add(player);
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
