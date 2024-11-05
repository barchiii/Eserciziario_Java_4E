package frontScreen;

import Mensola.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import utility.Tools;
import java.util.ArrayList;

import static utility.Tools.menu;

public class frontEnd {
    public static Libro leggiLibro(Scanner scanner) {
        Libro output = new Libro();

        System.out.println("inserire l'autore: ");
        output.autore = scanner.next();

        System.out.println("Inserire titolo: ");
        output.titolo = scanner.next();

        System.out.println("Numero di pagine: ");
        output.numeroPagine = Integer.parseInt(scanner.next());

        output.prezzoLibro = output.costoPerPagina * output.numeroPagine;

        Genere[] generi = Genere.values();
        String[] menuData = new String[generi.length + 1];
        menuData[0] = "Generi";
        for (int i = 0; i < generi.length; i++) {
            menuData[i + 1] = generi[i].toString();
        }
        int genereIndex;
        do {
            genereIndex = Tools.menu(menuData, scanner) - 1;
        } while (genereIndex == -1);
        output.tipologia = generi[genereIndex];

        while (true) {
            try {
                System.out.println("Inserisci la data di pubblicazione (dd-mm-yyyy): ");
                String dateInput = scanner.next();
                output.dataPubblicazione = LocalDate.parse(dateInput, output.formattazioneData);

                break;
            } catch (Exception e) {
                System.out.println("\t<ATTENZIONE> Valore data invalido.\n\tInserire una dato con formattazione specificata tra parentesi.");
            }
        }

        return output;
    }

    public static Libro leggiLibro(Scanner scanner, boolean soloAutoreTitolo){
        Libro output = new Libro();

        System.out.println("inserire l'autore: ");
        output.autore = scanner.next();

        System.out.println("Inserire titolo: ");
        output.titolo = scanner.next();

        if(soloAutoreTitolo)
            return output;

        System.out.println("Numero di pagine: ");
        output.numeroPagine = Integer.parseInt(scanner.next());

        output.prezzoLibro = output.costoPerPagina * output.numeroPagine;

        Genere[] generi = Genere.values();
        String[] menuData = new String[generi.length + 1];
        menuData[0] = "Generi";
        for (int i = 0; i < generi.length; i++) {
            menuData[i + 1] = generi[i].toString();
        }
        int genereIndex;
        do {
            genereIndex = Tools.menu(menuData, scanner) - 1;
        } while (genereIndex == -1);
        output.tipologia = generi[genereIndex];

        while (true) {
            try {
                System.out.println("Inserisci la data di pubblicazione (dd-mm-yyyy): ");
                String dateInput = scanner.next();
                output.dataPubblicazione = LocalDate.parse(dateInput, output.formattazioneData);

                break;
            } catch (Exception e) {
                System.out.println("\t<ATTENZIONE> Valore data invalido.\n\tInserire una dato con formattazione specificata tra parentesi.");
            }
        }

        return output;
    }

    public static void visualizza(int contatore, Libro[] mensola) {
        for (int i = 0; i < contatore; i++) {
            System.out.println("AUTORE: " + mensola[i].autore +
                    "\nTITOLO: " + mensola[i].titolo +
                    "\nN° PAGINE: " + mensola[i].numeroPagine +
                    "\nTIPOLOGIA: " + mensola[i].tipologia + "\n");
        }
    }
}