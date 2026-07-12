package com.text_adventure_game.utils;

import java.util.Random;
import java.util.Scanner;

import com.text_adventure_game.App;

public class RecreatRoom2 {
  private static final Scanner scanner = new Scanner(System.in);
  private static final Random rand = new Random();
  private static final int randomPainting = rand.nextInt(6);
  public static void stepIn() throws InterruptedException{
    System.out.println("As you step in you find 5 paintings and one of them holds the key");
    System.out.println("Which do you choose?");
    System.out.println(randomPainting);
    System.out.println("Painting 1");
    System.out.println("Painting 2");
    System.out.println("Painting 3");
    System.out.println("Painting 4");
    System.out.println("Painting 5");
    System.out.print("-> ");
    int choice = scanner.nextInt();
    if(choice == randomPainting){
      System.out.println("You chose the right painting and you get the key");
      Key key = new Key("RecreatRoom2");
      Inventory.addItem(key);
      App.mainMenu();
    }
    else{
      System.out.println("You chose the wrong painting and you die");
      System.exit(0);
    }
  }
}
