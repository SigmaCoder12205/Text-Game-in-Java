package com.text_adventure_game.utils;

import java.util.Scanner;

public class SecrectRoom {
  private static final Scanner scanner = new Scanner(System.in);

  public static void goIn() throws InterruptedException{
    System.out.println("You enter the secrect room...");
    System.out.println("1. Look around.");
    System.out.println("2. Search for more chests.");
    System.out.println("3. Climb up stairs.");
    System.out.println("4. Exit.");
    System.out.println("--> ");
    int choice = scanner.nextInt();
    handleChoices(choice);
  }
  private static void  handleChoices(int choice) throws InterruptedException{
    switch (choice) {
      case 1 -> {
        System.out.println("A man comes out from no where!");
        Thread.sleep(2000);
        System.out.println("he just offers you a bag.");
      }
      default -> {}
    }
  }
}
