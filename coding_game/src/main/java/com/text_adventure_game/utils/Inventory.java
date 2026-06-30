package com.text_adventure_game.utils;

import java.util.ArrayList;

public class Inventory {
  public static ArrayList<Object> items = new ArrayList<>();

  public static boolean checkInventory(Object object){
      return items.contains(object);
  }

  public static boolean checkInventoryWithValue(Object object, Object value){
    if(checkInventory(object)){
      for(Object obj : items){
        if(obj instanceof Wood wood && wood.foundfrom().equals(value)){
          return true;
        }
      }
    }
    return false;
  }

  public static void addItem(Object item){
    items.add(item);
  }
}
