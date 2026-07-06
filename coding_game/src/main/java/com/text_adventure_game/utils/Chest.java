package com.text_adventure_game.utils;

import java.util.ArrayList;

public class Chest {
  public static ArrayList<Object> items = new ArrayList<>();

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
  }
  public void addItem(Object item){

  }
}
