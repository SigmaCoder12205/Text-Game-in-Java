package com.text_adventure_game.utils;

import java.util.ArrayList;

public class Inventory {
  public static ArrayList<Object> items = new ArrayList<>();

  public static boolean checkInventory(Class<?> type){
      return items.stream().anyMatch(type::isInstance);
  }

  public static boolean checkInventoryWithValue(Class<?> object, Object value){
    if(checkInventory(object)){
      for(Object obj : items){
        if(obj instanceof Wood wood && wood.foundfrom().equals(value)){
          return true;
        }
      }
    }
    return false;
  }

  public static void addMultiItems(ArrayList<Object> items){
    for (Object item : items){
      addItem(item);
    }
  }

  public static void addItem(Object item){
    items.add(item);
  }
}
