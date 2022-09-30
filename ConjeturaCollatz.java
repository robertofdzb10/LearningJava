import java.util.ArrayList;
import java.util.Scanner;

public class ConjeturaCollatz{
    public static void main(String[] args) {
        int numero = 1;
        ArrayList<Integer> listaOk = new ArrayList<Integer>();
        try (Scanner teclado = new Scanner( System.in )) {
            int numIntroducido;
            System.out.print("Introduce un número: ");
            numIntroducido =teclado.nextInt();
            while (numero <= numIntroducido ){
                System.out.println( "Número comprobado: " + numero );
                ConjeturaCollatzCalculo( numero );
                listaOk.add(numero);
                System.out.println( "Porcentaje de numeros que encajan en la conjetura: " + listaOk.size()/numero*100 + "%" );
                numero++;
            } 
        }
        catch(Exception e){
            System.out.println("Por favor, ingrese un dato valido");
        }
            /* try y catch para gestionar posibles excepciones causadas por la entrada por teclado */
    }

    public static boolean numeroPar ( int numero ) {
        if (numero % 2 == 0){
            return true;
        } else {
            return false;
        }
    }

    public static int CollatzUnaVez( int numero ) {
        if (numeroPar(numero)){
            numero = numero / 2;
        } else {
            numero = numero * 3 + 1;
        }
        return numero;
    }

    public static boolean ConjeturaCollatzCalculo( int numero ) {
        if ( numero == 1){
            return true;
        } else {
            numero = CollatzUnaVez( numero );
            System.out.println( "Calculos: " + numero );
            ConjeturaCollatzCalculo( numero );
            return false;
        }
    }
}

/* Static le perteence a toda la clase, a diferencia del resto de métodos, que son distintos 
 * para cada objeto de la clase */