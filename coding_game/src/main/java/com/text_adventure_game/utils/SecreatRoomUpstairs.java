package com.text_adventure_game.utils;

public class SecreatRoomUpstairs {
  public static void walkUp() throws InterruptedException{

  if(Inventory.checkInventory(Key.class)){
    System.out.println("The old man knows you have the key and let's you out");
    Thread.sleep(600);
    System.out.print(".");
    Thread.sleep(600);
    System.out.print(".");
    Thread.sleep(600);
    System.out.print(".");
    Thread.sleep(600);
    System.out.println("The end..........");
    System.exit(0);
  }

    System.out.println("As you walk up you look at the paintings on the wall");
    System.out.println("it looks like some of them are jumping out at you");
    System.out.println("wAit THeY aRE!!!!!!!");
    System.out.println("One of the paintings pulls you in and gives you a sword");
    System.out.println("And you fight off all the paintings and make it up stairs");
    System.out.println("By the time you make it up stairs the old man is waiting for you");
    System.out.println();
  }
}
