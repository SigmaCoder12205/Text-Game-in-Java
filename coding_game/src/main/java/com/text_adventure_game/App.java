package com.text_adventure_game;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import com.text_adventure_game.utils.Firepit;
import com.text_adventure_game.utils.Inventory;
/*
COme on and work on mainMenu boi
*/

public class App{
  private static final Set<String> songs = new LinkedHashSet<>();
  private static final Scanner scanner = new Scanner(System.in);
  private static final Firepit  firepit = new Firepit();
  private static Thread musicThread;
  private static final Inventory inventory = new Inventory();

  public static void main( String[] args ) {
    mainMenu();
  }
  private static void handleChoicesWithCare(int choice){
    switch (choice) {
      case 1 -> firepit.look();
      case 4 -> System.exit(0);
      default -> {
          }
    }
  }
  public static void mainMenu(){
      try (scanner) {
          startMusic();
          System.out.println("------------ Main Menu  --------------");
          System.out.println("1. Inspect Firepit");
          System.out.println("2. Look around");
          System.out.println("3. Inspect Painting");
          System.out.println("4. Exit");
          System.out.print("--> ");
          int choice = scanner.nextInt();
          handleChoicesWithCare(choice);
      }
  }
  private static void startMusic() {
     if (musicThread != null && musicThread.isAlive()) {
        return;
     }

    songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/ABBA - Does Your Mother Know.wav");
    songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/Bobby McFerrin - Don't Worry Be Happy (Official Music Video).wav");
    songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/Brain Stew.wav");
    songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/Dire Straits - Romeo And Juliet.wav");
    songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/Green Day - Basket Case (Lyrics).wav");
    songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/Inxs - New sensation.wav");
    songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/Simon and Garfunkel - The Sound of Silence (1966).wav");
    songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/The Cars - You Might Think (Official Music Video).wav");
    songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/The Proclaimers - I'm Gonna Be (500 Miles) (Official Music Video).wav");
    songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/The Traveling Wilburys - End Of The Line (Official 4K Music Video).wav");
    songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/The Zombies - Time Of The Season (Lyric Video).wav");
    songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/Two Of Us (Remastered 2009).wav");
    songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/Wheatus - Teenage Dirtbag.wav");
    musicThread = new Thread(new MusicPlayer(songs));
    musicThread.start();

  }
}
