package es.etg.dam.psp;

import es.etg.dam.psp.threads.Alfarero;
import es.etg.dam.psp.threads.Vendedor;

public class Main {
    public static void main(String[] args) {
    Thread alfarero = new Thread(new Alfarero(Galeria.NUMERO_OBRAS));
    Thread vendedor = new Thread(new Vendedor(Galeria.NUMERO_OBRAS));

    alfarero.start();
    vendedor.start();
        
        try {
            alfarero.join();
            vendedor.join();
            if (Galeria.getInstance().getObra() == 0){
                System.out.println("Se han vendido todas las obras");  
            }     
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
}