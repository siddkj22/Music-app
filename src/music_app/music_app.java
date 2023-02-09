package music_app;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.sound.midi.*;



public class music_app implements KeyListener {
	
	public void frame(){
		JFrame a = new JFrame();
		JTextArea c = new JTextArea();
		JButton b = new JButton("save");
		
		c.addKeyListener(this);
		
		a.getContentPane().add(c);
		a.getContentPane().add(BorderLayout.SOUTH, b);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setSize(500,500);
		System.out.print("ok");
		a.setVisible(true);
		
	}
	
	public void play(int notes){
		try{
		Sequencer player = MidiSystem.getSequencer();
		player.open();
		Sequence Seq = new Sequence(Sequence.PPQ,4);
		Track track = Seq.createTrack();
		
		
		ShortMessage a = new ShortMessage();
		a.setMessage(144,1,notes,100);
		MidiEvent noteOn = new MidiEvent(a , 1);
		track.add(noteOn);
		
		ShortMessage b = new ShortMessage();
		b.setMessage(128,1,44,100);
		MidiEvent noteOff = new MidiEvent(b,1);
		track.add(noteOff);
		
		player.setSequence(Seq);
		
		player.start();
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		
	}


	public void keyPressed(KeyEvent arg0) {
		//play(note);
		
	}




	public void keyReleased(KeyEvent arg0) {
		int note = (int)(Math.random()*120);
		play(note);
		
	}




	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	
	public static void main(String[] args){
		music_app app = new music_app();
		app.frame();
	}


}
