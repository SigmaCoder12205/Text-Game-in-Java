package com.text_adventure_game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class MusicPlayer implements Runnable{
  private final List<String> songs;

  public MusicPlayer(Set<String> songs){
    this.songs = new ArrayList<>(songs);

    Collections.shuffle(this.songs);
  }
  @Override
  public void run(){
    while(true){
      for(String song : songs){
        playSong(song);
      }
      Collections.shuffle(songs);
    }
  }
  private void playSong(String path){
    try{
    File file = new File(path);
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file); Clip clip = AudioSystem.getClip()) {
            clip.open(audioStream);
            clip.start();

            while (clip.getFramePosition() < clip.getFrameLength()) {
                Thread.sleep(100);
            }
        } catch (UnsupportedAudioFileException e) {
          System.out.println("Error" + e);
        }
    }
    catch (IOException | InterruptedException | LineUnavailableException e){
      System.out.println("Error" + e);
    }
  }
  }
