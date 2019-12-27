package com.bcits.uncheckedexception.customunchecked;

public class TestD {
	public static void main(String[] args) {
		System.out.println("main started");
		Election e1 = new Election();

		try {
			e1.vote(12);
		} catch (AgeLimitException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main ended");
	}
}
