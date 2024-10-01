import static utility.Tools.*;

import java.util.Random;
import java.util.Scanner;

/* programma che genera numeri casuali senza ripetizioni */

public class Main {
    public static void main(String[] args) {
        final String[] opzioni = {"NUMERI RANDOM OPZIONI",  //menu
                "Inserimento",
                "Visualizzazione",
                "Ricerca",
                "Fine"};
        Scanner scanner = new Scanner(System.in);

        int scelta, inputNumero;
        /* costanti */
        final int QUANTINUMERI = 10;
        final int MINRANGE = 0, MAXRANGE = 20;
        /* creazione vettori */
        int[] arrRan = null;

        do {
            scelta = Menu(opzioni, scanner);
            switch (scelta) {
                case 1:
                    arrRan = generaRandom(QUANTINUMERI, MINRANGE, MAXRANGE); //generazione numeri casuali
                    System.out.println("Numeri generati");
                    Wait(2);
                    break;
                case 2:
                    stampa(arrRan);
                    System.out.println("Premi qualsiasi tasto per continuare");
                    scanner.nextLine();
                    break;
                case 3:
                    do {
                        System.out.println("Inserisci il numero da cercare");
                        inputNumero = Integer.parseInt(scanner.nextLine());
                        if(inputNumero < MINRANGE || inputNumero > MAXRANGE){
                            System.out.println("Il numero non è compreso nell'intervallo");
                            ClrScr();
                        }
                    }while(inputNumero < MINRANGE || inputNumero > MAXRANGE);
                    int pos = cercaPos(arrRan, inputNumero) + 1;
                    if (pos < 0)
                        System.out.println("Il numero non è presente");
                    else
                        System.out.println("Il numero è presente nella posizione " + pos);
                    Wait(3);
                    break;
                default:
                    System.out.println("Fine programma");
            }
        } while (scelta != opzioni.length - 1); //finisce quando non viene scelta l'ultima opzione
    }

    /* metodo che ritorna un vettore di numeri random */
    private static int[] generaRandom(int dimArr, int numMin, int numMax) {
        Random random = new Random();
        int num;

        int[] arr = new int[dimArr];
        boolean[] checkRipetizioni = new boolean[numMax - numMin]; //array booleano che segna le ripetizioni

        for (int i = 0; i < arr.length && i < numMax - numMin; i++){
            do {
                num = random.nextInt(numMin, numMax) + 1;
            } while(checkRipetizioni[num + numMin - 1]); //ripete il ciclo se già selezionato

            arr[i] = num;
            checkRipetizioni[num + numMin - 1] = true;
        }

        return arr;
    }

    /* metodo stampa */
    private static void stampa(int[] array) {
        if(array == null){
            System.out.println("Non sono ancora stati estratti dei numeri");
            return;
        }
        System.out.println("ARRAY NUMERI RANDOM:");
        for (int num : array)
            System.out.print(num + "\t");
        System.out.println();
    }

    /* metodo di ricerca */
    private static int cercaPos(int[] arrRan, int num){
        if(arrRan != null){
            for(int i = 0; i < arrRan.length; i++){
                if(num == arrRan[i])
                    return i;
            }
        }

        return -1;
    }
}