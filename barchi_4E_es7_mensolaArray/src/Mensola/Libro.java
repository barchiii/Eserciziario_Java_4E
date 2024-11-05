package Mensola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Libro {
    public String autore;
    public String titolo;
    public int numeroPagine;
    public final double costoPerPagina = 0.05;
    public double prezzoLibro;
    public Genere tipologia;
    public LocalDate dataPubblicazione;
    public final DateTimeFormatter formattazioneData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString() {
        return String.format("Autore : %s; Titolo : %s; Numero di pagine : %d; Prezzo : %f; Genere : %s; Data : %s\n",
                autore, titolo, numeroPagine, numeroPagine * costoPerPagina, tipologia.toString(), dataPubblicazione.format(formattazioneData));
    }

    @Override
    public boolean equals(Object object) {
        Libro book = (Libro) object;
        if (this.autore.equals(book.autore) && this.titolo.equals(book.titolo)) {
            return true;
        }
        return false;
    }
}
