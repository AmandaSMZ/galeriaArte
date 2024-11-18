package es.etg.dam.psp;

public class Galeria {
    public static final int NUMERO_OBRAS_SIMULTANEAS = 1;
    public static final int NUMERO_OBRAS = 10;
    private static Galeria exposicion;
    private int obra = 0;

    private Galeria(){}

    public static synchronized Galeria getInstance() {
        if (exposicion == null) {
            exposicion = new Galeria();
        }
        return exposicion;
    }


    public synchronized void ponerObra(int numObra) throws InterruptedException {
        while (this.obra >= NUMERO_OBRAS_SIMULTANEAS) {
            wait();
        }
        this.obra++;
        System.out.println("El alfarero ha puesto en exposición la obra "+numObra);
        notify();
    }
    
    public synchronized void venderObra(int numObra) throws InterruptedException {
        while (this.obra == 0) {
            wait();
        }
        this.obra--;
        System.out.println("El vendedor ha vendido la obra "+numObra);
        notify();
    }

    public int getObra(){
        return obra;
    }
    //Solo para pruebas
    public void reiniciarExposicion(){
        obra = 0;
    }
}
