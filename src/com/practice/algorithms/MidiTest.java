package com.practice.algorithms;

import java.util.Random;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class MidiTest {
  public static void main(String args[]) {
    int channel = 10; // 0 is a piano, 9 is percussion, other channels are for other instruments

    int volume = 80; // between 0 et 127
    int duration = 200; // in milliseconds

    try {
        Synthesizer synth = MidiSystem.getSynthesizer();
        synth.open();
        MidiChannel[] channels = synth.getChannels();
        
        Instrument[] instruments = synth.getAvailableInstruments();
        for(int i=0; i < instruments.length;i++) {
          System.out.println(i + " " + instruments[i].getName());
        }
        
        int totalDevices = 100;
        int deviceId = 74;
        Random random = new Random();
        for(int i= 100; i < 300; i++, deviceId +=0) {
          int noteValue = random.nextInt(120);
          channels[1].programChange(0, deviceId);
          channels[1].noteOn( noteValue++, volume );
          Thread.sleep( 500 );
          noteValue = random.nextInt(120);
          //channels[1].noteOff( noteValue+1 );
          channels[1].allNotesOff();
          channels[1].programChange(0, deviceId);
          channels[1].noteOn( noteValue++, volume );
          Thread.sleep( 500 );
          //channels[1].noteOff( noteValue+1 );
          noteValue = random.nextInt(120);
          channels[1].allNotesOff();
          channels[1].programChange(0, deviceId);
          channels[1].noteOn( noteValue++, volume );
          Thread.sleep( 500 );
          //channels[1].noteOff( noteValue+1 );
          noteValue = random.nextInt(120);
          channels[1].allNotesOff();
          channels[1].programChange(0, deviceId);
          channels[1].noteOn( noteValue++, volume );
          Thread.sleep( 500 );
          //channels[1].noteOff( noteValue+1 );
          channels[1].allNotesOff();
          //if(noteValue >= 120) {
            //noteValue = 40;
          //}
        }
        // --------------------------------------
        // Play a few notes.
        // The two arguments to the noteOn() method are:
        // "MIDI note number" (pitch of the note),
        // and "velocity" (i.e., volume, or intensity).
        // Each of these arguments is between 0 and 127.
        /*
        channels[channel].noteOn( 60, volume ); // C note
        Thread.sleep( duration );
        channels[channel].noteOff( 60 );
        channels[channel].noteOn( 62, volume ); // D note
        Thread.sleep( duration );
        channels[channel].noteOff( 62 );
        channels[channel].noteOn( 64, volume ); // E note
        Thread.sleep( duration );
        channels[channel].noteOff( 64 );

        Thread.sleep( 500 );

        // --------------------------------------
        // Play a C major chord.
        channels[channel].noteOn( 60, volume ); // C
        channels[channel].noteOn( 64, volume ); // E
        channels[channel].noteOn( 67, volume ); // G
        Thread.sleep( 3000 );
        channels[channel].allNotesOff();
        Thread.sleep( 500 );
        */


        synth.close();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
  }
}
