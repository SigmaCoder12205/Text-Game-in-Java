package com.text_adventure_game.utils;

import java.util.Scanner;

import com.text_adventure_game.App;

public class Painting {
  private static final Scanner scanner = new Scanner(System.in);
  public static void look() throws InterruptedException{
    System.out.println("You look at the paiting...");
    System.out.println("1. Take the painting off the wall");
    System.out.println("2. Just leave it and keep looking");
    int choice = scanner.nextInt();
    handleChoicesWithCare(choice);

  }
  private static void handleChoicesWithCare(int choice) throws InterruptedException{
    switch (choice) {
      case 1:
        RecreatRoom2.stepIn();
      break;
      case 2: App.mainMenu(); break;
      default: break;
    }
  }
}
