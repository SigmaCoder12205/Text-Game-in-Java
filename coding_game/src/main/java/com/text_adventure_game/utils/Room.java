package com.text_adventure_game.utils;
import java.util.ArrayList;
import java.util.Scanner;

import com.text_adventure_game.App;

public class Room {
  private static final Scanner scanner = new Scanner(System.in);

  public void lookAround() throws InterruptedException{
    putItemsInChest();
    System.out.println("You look around and find a chest");
    System.out.println("\n1. Open chest");
    System.out.println("2. Keep looking around");
    System.out.println("3. Exit.");
    System.out.print("--> ");
    int choice = scanner.nextInt();
    handleChoices(choice);
  }

  private static void putItemsInChest(){

    Wood wood1 = new Wood(10, "room");
    Wood wood2 = new Wood(10, "room");
    ArrayList<Object> noteItems = new ArrayList<>();
    ArrayList<Object> itemsToAdd = new ArrayList<>();
    Note note = new Note("Go to painting to find key", noteItems);
    itemsToAdd.add(wood1);
    itemsToAdd.add(wood2);
    itemsToAdd.add(note);
    Chest chest = new Chest(itemsToAdd);
  }

  private static void handleChoices(int choice) throws InterruptedException{
    switch (choice) {
      case 1 -> {
        System.out.println("You find a chest!");
        Chest.look();
      }
      case 2 -> {
        System.out.println("You find a monster and the monster kills you");
        System.exit(0);
      }
      case 3 -> App.mainMenu();
      default -> {}
    }
  }
}
