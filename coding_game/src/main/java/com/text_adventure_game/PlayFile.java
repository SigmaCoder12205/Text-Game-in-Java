package com.text_adventure_game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayFile {
  static Clip clip;
  static AudioInputStream audioStream;
  static boolean isOpen = false;
  public static void playFile(String path){
    try {
        isOpen = true;

        File file = new File(path);

        audioStream = AudioSystem.getAudioInputStream(file);

        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

        System.in.read();

        clip.close();
        audioStream.close();

    } catch (Exception e) {
      System.out.println("Error: " + e);
    }
  }
  public static void stopSong(){
    if(isOpen){
      clip.stop();
      isOpen = false;
    }
  }
}
