import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.etg.dam.psp.Galeria;
import es.etg.dam.psp.threads.Alfarero;
import es.etg.dam.psp.threads.Vendedor;

public class GaleriaTest {

    @BeforeEach 
    public void reiniciarGaleria(){
        Galeria.getInstance().reiniciarExposicion();
    }

    @Test
    public void testSingletonGaleria() {
        Galeria galeria1 = Galeria.getInstance();
        Galeria galeria2 = Galeria.getInstance();

        // Verificar que ambas referencias apunten al mismo objeto
        assertSame(galeria1, galeria2, "La galería debe ser un Singleton.");
    }


    @Test
    public void testCoordinacion(){
    Thread alfarero = new Thread(new Alfarero(1));
    Thread vendedor = new Thread(new Vendedor(1));

    alfarero.start();
    vendedor.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {

        }

        assertTrue(Galeria.getInstance().getObra() == 0);
    }


}
