package com.text_adventure_game.utils;

import java.util.ArrayList;

public class Inventory {
  public static ArrayList<Object> items = new ArrayList<>();

    public Inventory() {
      items.add(new Wood(5));
    }
    public static boolean checkInventory(Object object){
      return items.contains(object);
    }
}
