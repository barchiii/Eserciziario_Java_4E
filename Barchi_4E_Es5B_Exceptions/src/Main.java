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
                System.out.println("Inserisci primo numero: ");
                a = Integer.parseInt(kb.nextLine());

                System.out.println("Inserisci secondo numero: ");
                b = Integer.parseInt(kb.nextLine());

                dividi(a, b);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                ripeti = true;
            }
        } while (ripeti);
    }

    private static double dividi(int a, int b) throws Exception {
        double divisione = 0;

        if (b != 0)
        {
            divisione = (double)a / b;
            System.out.printf("Divisione: %.2f", divisione);
            return divisione;
        }
        else
        {
            throw new Exception("Impossibile dividere per 0");
        }
    }
}
