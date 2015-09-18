package com.quetzal.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.quetzal.player.Player;
import com.quetzal.player.util.PlayerUtil;

public class Quetzal {
	public static void main(String[] args) throws IOException {
		ArrayList<String> positions = new ArrayList<String>();
		positions.add("QB1");
		positions.add("RB1");
		
		ArrayList<Player> allPlayers = PlayerUtil.populatePlayers();
		ArrayList<Player> allPlayersByPosition = PlayerUtil.populatePlayersByPosition(positions);
		for(int i=0; i <allPlayers.size(); i++){
			System.out.println(allPlayers.get(i).toString());
		}
		System.out.println("*********************************");
		for(int i=0; i <allPlayersByPosition.size(); i++){
			System.out.println(allPlayersByPosition.get(i).toString());
		}
	}
}
