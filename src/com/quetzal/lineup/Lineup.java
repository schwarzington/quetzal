package com.quetzal.lineup;

import java.util.ArrayList;

import com.quetzal.player.Player;

public class Lineup {
	private Player qb, rb1, rb2, wr1, wr2, wr3, te, flex, dst;
	public Lineup(){
		Player dummyPlayer = new Player("Dummy", "Player", "NULL", "NONE", "ABB");
		dummyPlayer.setDk_cost((long) 0);
		dummyPlayer.setDk_cpp(0.00);
		dummyPlayer.setDk_avg_points(0.00);
		this.qb = dummyPlayer;
		this.rb1 = dummyPlayer;
		this.rb2 = dummyPlayer;
		this.wr1 = dummyPlayer;
		this.wr2 = dummyPlayer;
		this.wr3 = dummyPlayer;
		this.te = dummyPlayer;
		this.flex = dummyPlayer;
		this.dst = dummyPlayer;
		
	}
	public long lineupCost() {
		ArrayList<Player> lineup = new ArrayList<Player>();
		lineup.add(this.qb);
		lineup.add(this.rb1);
		lineup.add(this.rb2);
		lineup.add(this.wr1);
		lineup.add(this.wr2);
		lineup.add(this.wr3);
		lineup.add(this.te);
		lineup.add(this.flex);
		lineup.add(this.dst);
		long sum = (long)0;
		for(Player player : lineup){
			sum = sum + player.getDk_cost();
		}
		return sum;
	}
	public Player getQb() {
		return qb;
	}
	public void setQb(Player qb) {
		this.qb = qb;
	}
	public Player getRb1() {
		return rb1;
	}
	public void setRb1(Player rb1) {
		this.rb1 = rb1;
	}
	public Player getRb2() {
		return rb2;
	}
	public void setRb2(Player rb2) {
		this.rb2 = rb2;
	}
	public Player getWr1() {
		return wr1;
	}
	public void setWr1(Player wr1) {
		this.wr1 = wr1;
	}
	public Player getWr2() {
		return wr2;
	}
	public void setWr2(Player wr2) {
		this.wr2 = wr2;
	}
	public Player getWr3() {
		return wr3;
	}
	public void setWr3(Player wr3) {
		this.wr3 = wr3;
	}
	public Player getTe() {
		return te;
	}
	public void setTe(Player te) {
		this.te = te;
	}
	public Player getFlex() {
		return flex;
	}
	public void setFlex(Player flex) {
		this.flex = flex;
	}
	public Player getDst() {
		return dst;
	}
	public void setDst(Player dst) {
		this.dst = dst;
	}
	

}
