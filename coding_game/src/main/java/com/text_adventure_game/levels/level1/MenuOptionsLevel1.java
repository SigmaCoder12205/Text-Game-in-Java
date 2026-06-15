package com.text_adventure_game.levels.level1;

public enum MenuOptionsLevel1 {
  LOOK_AT_FIREPIT,
  LOOK_AT_PAINTING,
  LOOK_AROUND,
  EXIT_ROOM,
  INVAILD;

  public static MenuOptionsLevel1 convertFromInt(int choice){
    return switch (choice){
      case 1 -> LOOK_AT_FIREPIT;
      case 2 -> LOOK_AT_PAINTING;
      case 3 -> LOOK_AROUND;
      case 4 -> EXIT_ROOM;
      default -> INVAILD;
    };
  }
}
