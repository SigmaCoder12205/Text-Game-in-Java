package com.text_adventure_game.utils;

import java.util.ArrayList;
import java.util.Scanner;

import com.text_adventure_game.App;

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
        ArrayList<Object> noteItems = new ArrayList<>();
        Note note = new Note("Go inspect painting to find key", noteItems);
        Inventory.addItem(note);
        Wood wood = new Wood(10, "secrectRoom");
        Inventory.addItem(wood);
        System.out.println("Items have been added to inventory");
        goIn();
      }
      case 2 -> {System.out.println("Do not be so greedy says an old man"); System.out.println("He pulls out a sword and kills you"); System.exit(0);}
      case 3 -> {SecreatRoomUpstairs.walkUp();}
      case 4 -> {App.mainMenu();}
      default -> {}
    }
  }
}
