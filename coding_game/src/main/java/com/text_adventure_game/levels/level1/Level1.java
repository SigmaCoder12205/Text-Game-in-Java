package com.text_adventure_game.levels.level1;

import java.util.Scanner;

public class Level1 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void start(){
      System.out.println("You enter the first room...");
      System.out.println("---------------------------");
      System.out.println("What would you like to do?");
      System.out.println("\n1. Inspect the firepit.");
      System.out.println(  "2. Inspect the painting.");
      System.out.println(  "3. Inspect the overall room.");
      System.out.println(  "4. Exit the room.");
      System.out.print(">: ");
      int choice = scanner.nextInt();
      MenuOptionsLevel1 optionsLevel1 = MenuOptionsLevel1.convertFromInt(choice);
      handleChoice(optionsLevel1);
    }
    private static void handleChoice(MenuOptionsLevel1 option){
      try {
        switch (option) {
          case LOOK_AT_FIREPIT: break;
          case LOOK_AT_PAINTING: break;
          case LOOK_AROUND: break;
          case EXIT_ROOM: break;
          default: break;
        }
      } catch (Exception e) {
        System.out.println("Error: " + e);
      }
    }

}
