package com.text_adventure_game.utils;
import java.util.Scanner;

public class Room {
  private static final Scanner scanner = new Scanner(System.in);
  public void lookAround(){
    System.out.println("You look around and find a chest");
    System.out.println("\n1. Open chest");
    System.out.println("2. Keep looking around");
    System.out.print("--> ");
    int choice = scanner.nextInt();
    handleChoices(choice);
  }
  private static void handleChoices(int choice){
    switch (choice) {
      case 1 -> {}
      case 2 -> {}
      default -> {}
    }
  }
}
