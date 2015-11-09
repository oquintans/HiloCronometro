/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometro;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oquintansocampo
 */
public class Cronometro extends Thread {

    int sec = 0, min = 0, ho = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cronometro crono = new Cronometro();
        crono.start();
    }

    @Override
    public void run() {
        try {
            while (ho < 24) {
                if (min < 59) {
                    if (sec < 59) {
                        sleep(1000);
                        sec++;
                        this.tiempo(sec, min, ho);

                    } else {
                        sleep(1000);
                        min++;
                        sec = 0;
                        this.tiempo(sec, min, ho);
                    }
                } else {
                    sleep(1000);
                    ho++;
                    min = 0;
                    sec = 0;
                    this.tiempo(sec, min, ho);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tiempo(int s, int m, int h) {
        if (s < 10 && m < 10 && h < 10) {
            //0x:0x:0x
            System.out.println("0" + ho + ":0" + min + ":0" + sec);
        } else if (s < 10 && m >= 10 && h >= 10) {
            //xx:xx:0x
            System.out.println(ho + ":" + min + ":0" + sec);
        } else if (s < 10 && m < 10 && h >= 10) {
            //xx:0x:0x
            System.out.println(ho + ":0" + min + ":0" + sec);
        } else if (s < 10 && m >= 10 && h < 10) {
            //0x:xx:0x
            System.out.println("0" + ho + ":" + min + ":0" + sec);
        } else if (s >= 10 && m >= 10 && h >= 10) {
            //xx:xx:xx
            System.out.println(ho + ":" + min + ":" + sec);
        } else if (s >= 10 && m < 10 && h < 10) {
            //0x:0x:xx
            System.out.println("0" + ho + ":0" + min + ":" + sec);
        } else if (s >= 10 && m >= 10 && h < 10) {
            //0x:xx:xx
            System.out.println("0" + ho + ":" + min + ":" + sec);
        } else if (s >= 10 && m < 10 && h >= 10) {
            //xx:0x:xx
            System.out.println(ho + ":0" + min + ":" + sec);
        }
    }
}
