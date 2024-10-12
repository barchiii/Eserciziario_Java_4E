import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int a, b;
        double divisione;
        boolean ripeti = false;
        Scanner kb = new Scanner(System.in);

        /* do {
            try
            {
                ripeti = false;

                System.out.println("Inserisci primo numero: ");
                a = Integer.parseInt(kb.nextLine());

                System.out.println("Inserisci secondo numero: ");
                b = Integer.parseInt(kb.nextLine());

                divisione = a / b;

                System.out.printf("Divisione: %f", divisione);
            } catch(ArithmeticException e)
            {
                System.out.println(e.getMessage());
                ripeti = true;
            }
        } while(ripeti);*/


        do {
            try {
                ripeti = false;
                dividi(kb);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                ripeti = true;
            }
        } while (ripeti);
    }

    private static double dividi(Scanner kb) throws Exception {
        int n1, n2;
        double divisione = 0;

        System.out.println("Inserisci n1: ");
        n1 = Integer.parseInt(kb.nextLine());

        System.out.println("Inserisci n2: ");
        n2 = Integer.parseInt(kb.nextLine());

        if (n2 != 0)
        {
            divisione = n1 / n2;
            System.out.printf("Divisione: %f", divisione);

            return divisione;
        }
        else
        {
            throw new Exception("Impossibile dividere per 0");
        }
    }
}