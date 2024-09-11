package view;

import controller.AeroportoThread;

import java.util.concurrent.Semaphore;

public class Principal {
    public static Semaphore semaforoDecolagem = new Semaphore(2);
    public static Semaphore semaforoNorte = new Semaphore(1);
    public static Semaphore semaforoSul = new Semaphore(1);

    public static void main(String[] args) {
        Thread aeroportoThread = new AeroportoThread(1, semaforoDecolagem, semaforoNorte, semaforoSul);
        Thread aeroportoThread2 = new AeroportoThread(2, semaforoDecolagem, semaforoNorte, semaforoSul);
        Thread aeroportoThread3 = new AeroportoThread(3, semaforoDecolagem, semaforoNorte, semaforoSul);
        Thread aeroportoThread4 = new AeroportoThread(4, semaforoDecolagem, semaforoNorte, semaforoSul);
        Thread aeroportoThread5 = new AeroportoThread(5, semaforoDecolagem, semaforoNorte, semaforoSul);
        Thread aeroportoThread6 = new AeroportoThread(6, semaforoDecolagem, semaforoNorte, semaforoSul);
        Thread aeroportoThread7 = new AeroportoThread(7, semaforoDecolagem, semaforoNorte, semaforoSul);
        Thread aeroportoThread8 = new AeroportoThread(8, semaforoDecolagem, semaforoNorte, semaforoSul);
        Thread aeroportoThread9 = new AeroportoThread(9, semaforoDecolagem, semaforoNorte, semaforoSul);
        Thread aeroportoThread10 = new AeroportoThread(10, semaforoDecolagem, semaforoNorte, semaforoSul);
        Thread aeroportoThread11 = new AeroportoThread(11, semaforoDecolagem, semaforoNorte, semaforoSul);
        Thread aeroportoThread12 = new AeroportoThread(12, semaforoDecolagem, semaforoNorte, semaforoSul);

        aeroportoThread.start();
        aeroportoThread2.start();
        aeroportoThread3.start();
        aeroportoThread4.start();
        aeroportoThread5.start();
        aeroportoThread6.start();
        aeroportoThread7.start();
        aeroportoThread8.start();
        aeroportoThread9.start();
        aeroportoThread10.start();
        aeroportoThread11.start();
        aeroportoThread12.start();
    }
}
