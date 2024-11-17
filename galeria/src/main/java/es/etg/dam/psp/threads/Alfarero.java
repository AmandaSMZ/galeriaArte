package es.etg.dam.psp.threads;

import es.etg.dam.psp.Galeria;

public class Alfarero implements Runnable {
    private final Galeria exposicion;
    private final int numObras;

    public Alfarero(int numObras){
        this.exposicion = Galeria.getInstance();
        this.numObras = numObras;
    }

    @Override
    public void run() {
        for (int i=0; i<numObras;i++){
            try {
                exposicion.ponerObra(i);
            } catch (InterruptedException ex) {
                System.err.println("Error de ejecución en el Thread "+Thread.currentThread().getName());
                Thread.currentThread().interrupt(); 
            }
            
        }
    }
    
}
