package com.text_adventure_game.utils;

import java.util.Scanner;

public class Firepit {
  private static final Scanner scanner = new Scanner(System.in);
  public void look(){
    sideMenu();
  }
  private static void sideMenu(){
    try (scanner) {
      System.out.println("You are looking at the firepit....");
      System.out.println("------------ Options -------------");
      System.out.println("1. Climb into the fire.");
      System.out.println("2. Add wood to the fire.");
      System.out.println("3. Put out the fire.");
      System.out.println("4. Light the fire.");
      System.out.print("--> ");
      int choice = scanner.nextInt();
      handleChoicesWithCare(choice);
    }
    catch (Exception e) {
      System.out.println("Error: " + e);
    }
  }
  private static void handleChoicesWithCare(int choice){
    switch (choice) {
      case 1 -> {}
      default -> {}
    }
  }
}
