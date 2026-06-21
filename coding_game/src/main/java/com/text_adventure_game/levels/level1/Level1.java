package com.text_adventure_game.levels.level1;

import java.util.Scanner;

import com.text_adventure_game.PlayFile;

public class Level1 {
    private static final Scanner scanner = new Scanner(System.in);


    public static void start(){
      mainMenu();
      PlayFile.playFile("/home/ddogflyer/coding/textGAme/coding_game/music/The Sound of Silence (Electric Version).wav");
      int choice = scanner.nextInt();
      MenuOptionsLevel1 optionsLevel1 = MenuOptionsLevel1.convertFromInt(choice);
      handleChoice(optionsLevel1);
    }
    private static void handleChoice(MenuOptionsLevel1 option){

      try {
        switch (option) {
          case LOOK_AT_FIREPIT -> {
              System.out.println("\nLooking at Firepit (Enter to go back)...");
              PlayFile.playFile("/home/ddogflyer/coding/textGAme/coding_game/music/Wheatus - Teenage Dirtbag.wav");
              scanner.nextLine();
              start();
              }
          case LOOK_AT_PAINTING -> {
              System.out.println("\nLooking at the Painting (Enter to go back)...");
              PlayFile.playFile("/home/ddogflyer/coding/textGAme/coding_game/music/The Traveling Wilburys - End Of The Line (Official 4K Music Video).wav");
              scanner.nextLine();
              start();
              }
          case LOOK_AROUND -> {
              System.out.println("\nLooking Around (Enter to go back)...");
              PlayFile.playFile("/home/ddogflyer/coding/textGAme/coding_game/music/The Cars - You Might Think (Official Music Video).wav");
              scanner.nextLine();
              start();
              }
          case EXIT_ROOM -> {
              }
          default -> {
              }
        }
      } catch (Exception e) {
        System.out.println("Error: " + e);
      }
    }
    private static void mainMenu(){
      System.out.println("\n\n\n\n\n\n\nYou enter the first room...");
      System.out.println("---------------------------");
      System.out.println("What would you like to do?");
      System.out.println("\n1. Inspect the firepit.");
      System.out.println(  "2. Inspect the painting.");
      System.out.println(  "3. Inspect the overall room.");
      System.out.println(  "4. Exit the room.");
      System.out.print(">: ");
    }


  }
