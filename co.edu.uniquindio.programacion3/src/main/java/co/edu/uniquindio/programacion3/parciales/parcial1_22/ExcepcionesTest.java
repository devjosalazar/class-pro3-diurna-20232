package co.edu.uniquindio.programacion3.parciales.parcial1_22;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class ExcepcionesTest {

    public static void main(String[] args) {
        revisonFlujoExcepciones();
    }

    private static void revisonFlujoExcepciones() {
        //bloque1
        //bloque2
        try {
            //bloque3
            //bloque4
            //bloque5
        }catch (NullPointerException e){
            try {
                //bloque6
                //bloque7
                //bloque8
            }catch (ArrayIndexOutOfBoundsException e1){
                //bloque9
                //bloque10
                try {
                    //bloque11
                }catch (NullPointerException e2){
                    //bloque12
                }
            }
        }
        catch (IllegalArgumentException e){
            try {
                //bloque13
            }
//            catch (IOException e3){
//                //bloque14
//            }
            finally {
                //bloque15
            }
        }
        catch (Exception e){
            //bloque16
            //bloque17
        }
    }
}
