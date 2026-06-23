package com.text_adventure_game;
import java.io.IOException;
import java.util.ArrayList;

public class App{
  private static ArrayList<String> songs = new ArrayList<>();
  public static void main( String[] args ) throws IOException{
    System.out.println("App started");

    songs.add("C:\\Users\\DRA0016\\Text-Game-in-Java\\coding_game\\music\\Simon and Garfunkel - The Sound of Silence (1966).wav");
    songs.add("C:\\Users\\DRA0016\\Text-Game-in-Java\\coding_game\\music\\The Zombies - Time Of The Season (Lyric Video).wav");
    songs.add("C:\\Users\\DRA0016\\Text-Game-in-Java\\coding_game\\music\\Dire Straits - Romeo And Juliet.wav");
    songs.add("coding_game/music/Two Of Us (Remastered 2009).wav");

    Thread musicThread = new Thread(new MusicPlayer(songs));
    musicThread.setDaemon(true);
    musicThread.start();
    System.in.read();
    
  }
}
