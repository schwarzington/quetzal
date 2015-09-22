package com.quetzal.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.quetzal.lineup.Lineup;
import com.quetzal.player.Player;
import com.quetzal.player.util.PlayerUtil;

public class Quetzal {
public static void main(String[] args) throws IOException {
	ArrayList<String> positions = new ArrayList<String>();
		positions.add("QB1");
		ArrayList<Player> allPlayers = PlayerUtil.populatePlayers(positions);
		Collections.sort(allPlayers, Player.CostPerPointComparator);
		for(int i=0; i <allPlayers.size(); i++){
			System.out.println(allPlayers.get(i).toString());
		}
		Lineup line = new Lineup();
		System.out.print(line.lineupCost());

	}
}
