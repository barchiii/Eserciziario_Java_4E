import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int [] arr = {1, 2, 3, 4};
        int a, b, somma = 0;
        boolean ripeti = false;

        Scanner kb = new Scanner(System.in);

        /* try
        {
            for (int i = 0; i <= arr.length; i++)
            {
                System.out.println(arr[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("Valori stampati"); */

        /* do {
            try
            {
                ripeti = false;

                System.out.println("Inserisci il primo numero: ");
                a = Integer.parseInt(kb.nextLine());

                System.out.println("Inserisci il secondo numero: ");
                b = Integer.parseInt(kb.nextLine());

            } catch (Exception e)
            {
                 //System.out.println(e.getMessage());

                System.out.println("Input errato");
                ripeti = true;
            }
        } while (ripeti); */

        do {
            try
            {
                ripeti = false;
                gestInteger(kb);
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
                ripeti = true;
            }
        } while(ripeti);

        System.out.println("Fine programma");
    }

    private static int gestInteger (Scanner kb) throws Exception {
        int num = 0;

        System.out.println("Inserisci numero: ");
        num = Integer.parseInt(kb.nextLine());

        if (num >= 0)
        {
            return num;
        }
        else
        {
            throw new Exception("Valore non valido");
        }
    }
}