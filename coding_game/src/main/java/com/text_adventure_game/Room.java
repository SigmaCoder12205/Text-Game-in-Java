package com.text_adventure_game;

public abstract class Room {
  private Firepit firepit;
  private Painting painting;
  private Key key;

  public abstract void enter();
  public abstract void leave();
  public abstract void lookAround();
}
