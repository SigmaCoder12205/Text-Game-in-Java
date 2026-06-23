package com.text_adventure_game;

import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class MusicPlayer implements Runnable{
  private final ArrayList<String> songs;

  public MusicPlayer(ArrayList<String> songs){
    this.songs = songs;
  }
  @Override
  public void run(){
    while(true){
      for(String song : songs){
        playSong(song);
      }
    }
  }
  private void playSong(String path){
    try{
    File file = new File(path);
    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    Clip clip =  AudioSystem.getClip();
    clip.open(audioStream);
    System.out.println("Playing "+ path);
    clip.start();

    while (clip.getFramePosition() < clip.getFrameLength()) {
        Thread.sleep(100);
    }
    clip.close();
    audioStream.close();
    }
    catch (Exception e){
      e.printStackTrace();
    }

  }
  }
