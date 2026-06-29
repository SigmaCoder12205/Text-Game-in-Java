package com.text_adventure_game;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
      public void look(){
    // 1. Safeguard: Only start the background thread if it's not already running
    if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
      scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
      // Changed initial delay to 2 so it doesn't instantly drop to 19 the millisecond you open it
      scheduledExecutorService.scheduleAtFixedRate(decreaseWood, 2, 2, TimeUnit.SECONDS);
    }
    sideMenu();
  }

  private static void sideMenu(){
    boolean insideMenu = true;

    // 2. Added a while loop so players stay in the room until they explicitly type '5' to exit
    while (insideMenu) {
      System.out.println("\nYou are looking at the firepit....");
      System.out.println("Current Fire Strength: " + fireStrength.get() + (isLighted ? " (Burning)" : " (Ashes)"));
      System.out.println("------------ Options -------------");
      System.out.println("1. Climb into the fire.");
      System.out.println("2. Add wood to the fire.");
      System.out.println("3. Put out the fire.");
      System.out.println("4. Light the fire.");
      System.out.println("5. Exit to Main Menu.");
      System.out.print("--> ");

      try {
        int choice = scanner.nextInt();
        if (choice == 5) {
          insideMenu = false; // Breaks our local loop to return to main menu cleanly
        } else {
          handleChoicesWithCare(choice);
        }
      } catch (Exception e) {
        System.out.println("Error: " + e);
        scanner.next(); // Clear bad input
      }
    }

}
