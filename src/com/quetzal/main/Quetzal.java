package com.quetzal.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Quetzal {
	public static void main(String[] args) throws IOException {
		String url = "http://fftoolbox.scout.com/football/depth-charts.cfm";
		print("Fetching %s...", url);

		Document doc = Jsoup.connect(url).get();
		Elements teams = doc.select("div.team");

		print("\nTeams: (%d)", teams.size());
		for (Element team : teams) {
			for (Element player : team.select("ul > li")) {
				print("Position: " + player.text().split(" ")[0]
						+ " Player Name: " + player.text().split(" ")[1] + " "
						+ player.text().split(" ")[2]);
			}
		}
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
