package com.text_adventure_game.utils;

import java.util.ArrayList;


public class Note {
  public static String context = "";
  public static ArrayList<Object> items = new ArrayList<>();

  Note(String context, ArrayList<Object> items){
    Note.context = context;
    Note.items = items;
  }

}
