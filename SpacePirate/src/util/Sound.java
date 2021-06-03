//package util;
//
//import javax.sound.sampled.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import javax.swing.*;
//
//public class Sound {
//
//    private Clip clip;
//    public boolean playing;
//    public void playSound(String soundName) {
//        try {
//            Clip clip = AudioSystem.getClip();
//            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName + ".wav").getAbsoluteFile());
//            clip.open(audioInputStream);
//          //  clip.start();
////            playing = true;
//         //   clip.loop(Clip.LOOP_CONTINUOUSLY);
//
////            String[] options = {"play sound", "stop sound"};
////
////            int jOptionPaneChoice = JOptionPane.showOptionDialog(null, "Set sound on/off",
////                    "Sound",
////                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
////            System.out.println(jOptionPaneChoice);
////
////
////            if (jOptionPaneChoice == 1) {
////                clip.stop();
////            }
//
//            final JToggleButton startStop = new JToggleButton("Start");
//            startStop.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent ae) {
//                    if (startStop.isSelected()) {
//                        clip.loop(-1);
//                        clip.start();
//                        startStop.setText("Stop");
//                    } else {
//                        clip.stop();
//                        startStop.setText("Start");
//
//                    }
//                }
//            });
//           // clip.loop(-1);
//            JOptionPane.showMessageDialog(null, startStop);
//
//
//
//
//        }
//        catch(Exception ex)
//        {
//            System.out.println("Error with playing sound.");
//            ex.printStackTrace();
//        }
//    }
//
////    public void stop() {
////        clip.stop();
////        playing = false;
////}
//
//
//
//
//}
//
