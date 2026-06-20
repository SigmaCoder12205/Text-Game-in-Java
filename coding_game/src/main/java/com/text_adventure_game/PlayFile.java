package com.text_adventure_game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayFile {
  public void playFile(String path){
    try {
        File file = new File(path);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

        System.in.read();
        clip.close();
        audioStream.close();

    } catch (Exception e) {
      System.out.println("Error: " + e);
    }
  }
}
