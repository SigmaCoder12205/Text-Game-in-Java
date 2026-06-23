package com.text_adventure_game;
import java.util.ArrayList;
/*
COme on and work on mainMenu boi
*/

public class App{
  private static final ArrayList<String> songs = new ArrayList<>();
  public static void main( String[] args ) {


    System.out.println("--- ALl that shit ---");
    System.out.println("1. Option 1");
    System.out.println("2. Option 2");
    System.out.println("3. Option 3");
  }
  private static void mainMenu(){
    startMusic();
    System.out.println("------------ Main Menu  --------------");
    System.out.println("1. Inspect Firepit");
    System.out.println("2. Look around");
  }
  private static void startMusic() {

      songs.add("coding_game/music/Simon and Garfunkel - The Sound of Silence (1966).wav");
      songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/The Zombies - Time Of The Season (Lyric Video).wav");
      songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/Dire Straits - Romeo And Juliet.wav");
      songs.add("/home/ddogflyer/coding/textGAme/coding_game/music/Two Of Us (Remastered 2009).wav");

      Thread musicThread = new Thread(new MusicPlayer(songs));
      musicThread.setDaemon(true);
      musicThread.start();
      try {
          musicThread.join();
      } catch (InterruptedException e) {
          System.out.println("Error: " + e);
      }



  }
}
