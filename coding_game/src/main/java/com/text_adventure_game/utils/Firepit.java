package com.text_adventure_game.utils;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.text_adventure_game.App;

public class Firepit {
  private static final Scanner scanner = new Scanner(System.in);
  private static boolean isLighted = true;
  private static AtomicInteger fireStrength = new AtomicInteger(20);
  private static ScheduledExecutorService scheduledExecutorService;

  private static final Runnable decreaseWood = () -> {
    int currentStrength = fireStrength.decrementAndGet();
    if(currentStrength <= 0){
      fireStrength.set(0);
      isLighted = false;
      if(scheduledExecutorService != null){
        scheduledExecutorService.shutdown();
      }
      System.out.println("Fire died...");
      System.out.print("--> ");
    }
  };

  public void look(){
    if(scheduledExecutorService == null || scheduledExecutorService.isShutdown()){
      scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
      scheduledExecutorService.scheduleAtFixedRate(decreaseWood, 2, 2, TimeUnit.SECONDS);
    }
    sideMenu();
  }
  private static void sideMenu(){
    boolean menuOpen = true;

    while(menuOpen){
      System.out.println("Inventory items: " + Inventory.items);
      System.out.println("You are looking at the firepit....");
      System.out.println("------------ Options -------------");
      System.out.println("1. Climb into the fire.");
      System.out.println("2. Add wood to the fire.");
      System.out.println("3. Put out the fire.");
      System.out.println("4. Light the fire.");
      System.out.println("5. Exit.");
      System.out.print("--> ");
      try {

      int choice = scanner.nextInt();
      handleChoicesWithCare(choice);
    }
    catch (Exception e) {
      System.out.println("Error: " + e);
      scanner.next();
    }
    }
    App.mainMenu();
  }


  private static void handleChoicesWithCare(int choice){
    switch (choice) {
      case 1 -> climbIntoFire();
      case 2 -> {

        Optional<Wood> foundWood = Inventory.items.stream().filter(item -> item instanceof Wood).map(item -> (Wood) item).findFirst();
        if(foundWood.isPresent()){
          Wood wood = foundWood.get();
          System.out.println("Before Strength: " + fireStrength.get());
          addWoodToFire(wood);
          Inventory.items.remove(wood);
          System.out.println("New wood strength "+ fireStrength.get());
        }
        else{
          System.out.println("You don't have any Wood in your inventory");
        }
      }
      case 3 -> putOutFire();
      case 4 -> lightFire();
      case 5 -> App.mainMenu();
      default -> {System.out.println("Invaild choice try again"); sideMenu();}
    }
  }

  private static void lightFire(){
    if(isLighted){
      System.out.println("Fire already lighted...");
      }
      else{
      Optional<Wood> foundWood = Inventory.items.stream().filter(item -> item instanceof Wood).map(item -> (Wood) item).findFirst();
      if(foundWood.isPresent()){
        Wood wood = foundWood.get();
        System.out.println("Using wood to light fire...");
        Inventory.items.remove(wood);
        isLighted = true;
      }
      else{
        System.out.println("You don't have any wood in your inventory");
      }
    }
  }

  private static void putOutFire(){
    if(isLighted){
      isLighted = false;
      System.out.println("Putting out the fire...");
    }
    else{
      System.out.println("Fire is already out...");
    }
  }

  private static void addWoodToFire(Wood wood){
    int woodStrength = wood.woodStrength();
    fireStrength.addAndGet(woodStrength);
  }


  private static void climbIntoFire(){
    System.out.println("You climb into the firepit");
    if(isLighted){
      System.out.println("The Fire is alight, and you die...");
      if (scheduledExecutorService != null) scheduledExecutorService.shutdown();
      System.exit(0);
    }
    else{
      ArrayList<Object> noteItems = new ArrayList<>();
      Wood wood = null;
      if(Inventory.checkInventoryWithValue(wood, "firepit")){
        System.out.println("You've already found the note");
      }
      wood = new Wood(10, "firepit");
      noteItems.add(wood);
      Note note = new Note("Go look at the painting to find the key", noteItems);
      Inventory.addItem(note);
      for (Object item : noteItems){
        Inventory.addItem(item);
      }
      System.out.println("You find a note, check inventory to read it");
    }
  }
}
