public class Main {
    public static void main(String[] args) {


        //  int rimuoviElementi = 0;
        int[] vettore = {1, 2, 1, 3, 7, 1, 10};
        int[] myVett = null;
        int[] arrayNuovo = null;
        int numeroRicercato = 1;

        //ritorna un nuovo vettore che rimuove tutte le

        /*myVett = removeNum(vettore,17);
        if(myVett != null)
        {
            for (int i : myVett)
            {
                System.out.println("\n" + i);
            }
        }

        else
            System.out.println("Non è stato rimosso nessun elemento");

*/

        arrayNuovo = findAll(vettore, 1);

        if (arrayNuovo != null)
        {
            vettore[0]=5;
            if(goal(arrayNuovo, vettore, 1))
                System.out.println("Il metodo funziona");

            else
                System.out.println("Il metodo non funziona");
        }

        else
            System.out.println("Il numero non esiste nell'array");


    }

    private static int[] removeNum(int[] vettore, int numeroRicercato)
    {
        int rimuoviElementi = 0;
        int countVett = 0;
        for (int i = 0; i < vettore.length; i++)
        {
            if (vettore[i] == numeroRicercato)
                rimuoviElementi++;

        }
        if (rimuoviElementi != 0)
        {
            int[] newVett = new int[vettore.length - rimuoviElementi];
            for (int i = 0; i < vettore.length; i++)
            {
                if (vettore[i] != numeroRicercato)
                {
                    newVett[countVett] = vettore[i];
                    countVett++;
                }
            }

            return newVett;

        }

        else
            return null;

    }


    private static int[] findAll(int[] vettore, int numeroRicercato)
    {

        int lunghezza = 0;
        int cont = 0;
        int[] arrayNuovo = null;

        for (int i = 0; i < vettore.length; i++)
        {
            if (vettore[i] == numeroRicercato)
                lunghezza++;
        }

        if (lunghezza != 0)
        {
            arrayNuovo = new int[lunghezza];

            for (int i = 0; i < vettore.length; i++)
            {
                if (vettore[i] == numeroRicercato)
                {
                    arrayNuovo[cont] = i;
                    cont++;
                }
            }

            return arrayNuovo;
        }
        else
            return null;

    }

    private static boolean goal(int[] arrayNuovo, int[] vettore, int numeroRicercato)
    {

        boolean goal = true;
        for (int i = 0; i < arrayNuovo.length && goal; i++)
        {
            goal = (vettore[arrayNuovo[i]] == numeroRicercato);

        }
        return goal;
    }
}