package com.tyss.bcits.datastructures;

import java.util.*;


public class Comparator {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter the number of players");
		int n = Integer.parseInt(scanner.nextLine());
		SortPlayer sort=new SortPlayer();
		TreeSet<Player> hash = new TreeSet<Player>(sort);

		for (int i = 1; i < n; i++) {
			System.out.println("enter the name of "+i+" th player");
			String name=scanner.nextLine();
			System.out.println("enter the score of "+i+" th player");
			int score=Integer.parseInt(scanner.nextLine());
			System.out.println(name+" "+score);
			Player play=new Player(name, score);


			hash.add(play);

		}
		for(Player play:hash)
		{
			System.out.println(play.getName()+"  "+play.getScore());
		}
	}
}


