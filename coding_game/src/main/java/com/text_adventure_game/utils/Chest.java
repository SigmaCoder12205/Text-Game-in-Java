package com.text_adventure_game.utils;

import java.util.ArrayList;
import java.util.Scanner;

import com.text_adventure_game.App;

public class Chest {
  public static ArrayList<Object> items = new ArrayList<>();
  private static final Scanner scanner = new Scanner(System.in);

  Chest(ArrayList<Object> items){
    Chest.items = items;
  }
  public static void look(){
    System.out.println("The chest contains: ");
    if(items == null){
      System.out.println("Nothing...");
    }
    else{
      for (Object item : items){
        System.out.println("Item: " + item);
      }
    }

    System.out.println("What do you want to do with them?");
    System.out.println("1. Put them in your inventory.");
    System.out.println("2. Throw them at the wall.");
    System.out.println("3. Put them in the fire with the chest.");
    System.out.print("--> ");
    int choice = scanner.nextInt();
    handleChoice(choice);
  }
  public void addItem(Object item){
    items.add(item);
  }
  private static void handleChoice(int choice){
    switch (choice) {
      case 1 -> {
        Inventory.addMultiItems(items);
        App.mainMenu();
      }
      case 2 -> {
        System.out.println("You break the wall and find a secrect room");
        System.out.println("1. Go in.");
        System.out.println("2. Leave it.");
        System.out.println("--> ");
        int choice1 = scanner.nextInt();
        switch (choice1) {
          case 1 -> {SecrectRoom.goIn();}
          case 2 -> {App.mainMenu();}
          default -> {Firepit.increaseWoodStrength(20);}
        }
      }
      default -> {}
    }
  }
}
