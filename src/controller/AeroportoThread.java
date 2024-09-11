package controller;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class AeroportoThread extends Thread {
    private final int threadId;
    private final Semaphore semaforoDecolagem;
    private final Semaphore semaforoNorte;
    private final Semaphore semaforoSul;

    private Boolean hasDeparted = false;

    public AeroportoThread(int threadId, Semaphore semaforoDecolagem, Semaphore semaforoNorte, Semaphore semaforoSul) {
        this.threadId = threadId;
        this.semaforoDecolagem = semaforoDecolagem;
        this.semaforoNorte = semaforoNorte;
        this.semaforoSul = semaforoSul;
    }

    @Override
    public void run() {
        while (!hasDeparted) {
            permissao_decolagem();
        }
    }

    public void permissao_decolagem() {
        try {
            semaforoDecolagem.acquire();
            boolean permissaoDecolagem = semaforoNorte.tryAcquire();
            if (permissaoDecolagem) {
                System.out.println("Avião " + threadId + " obteve permissão para decolar na Asa Norte");
                decolar(true, false);
            }
            else {
                boolean permissaoDecolagemSul = semaforoSul.tryAcquire();
                if (permissaoDecolagemSul) {
                    System.out.println("Avião " + threadId + " obteve permissão para decolar na Asa Sul");
                    decolar(false, true);
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforoDecolagem.release();
        }
    }

    public void decolar(boolean permissaoDecolagem, boolean permissaoDecolagemSul) throws InterruptedException {
        System.out.println("Avião " + threadId + " começou a manobrar");
        Thread.sleep(ThreadLocalRandom.current().nextInt(300, 701)); // manobra
        System.out.println("Avião " + threadId + " começou a taxiar");
        Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1001)); // taxiar
        System.out.println("Avião " + threadId + " começou a decolar");
        Thread.sleep(ThreadLocalRandom.current().nextInt(600, 801)); // decolagem
        System.out.println("Avião " + threadId + " começou a se afastar");
        Thread.sleep(ThreadLocalRandom.current().nextInt(300, 801)); // afastamento
        hasDeparted = true;

        if (permissaoDecolagem) semaforoNorte.release();
        else if (permissaoDecolagemSul) semaforoSul.release();
    }

}
