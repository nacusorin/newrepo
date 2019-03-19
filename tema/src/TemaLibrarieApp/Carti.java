package TemaLibrarieApp;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Book</h1>
 * A class that serves as a parent class for the more specific {@link Nuvele} and {@link AlbumeArta} classes.
 *
 * @author Nacu Sorin-Constantin
 * @version 5.2 beta
 * @since 2019-02-20
 */

public class Carti {
    private String nume;
    private int numarDePagini;
    private List<Pagina> pagini = new ArrayList<>(numarDePagini);

    public String getNume() {
        return nume;
    }

    public Carti(){ }

    public Carti(String nume,int numarDePagini) throws CustomException{
        if (numarDePagini <=50){
            throw new CustomException("Cartea trebuie sa aiba mai mult de 50 de pagini, in cazul asta are: " + numarDePagini);
        }
        else {
            this.nume=nume;
            this.numarDePagini=numarDePagini;
            System.out.println("OK");

        }

    }

    public void setNume(String nume) {
        this.nume = nume;

    }

    public int getNumarDePagini() {
        return numarDePagini;
    }

    public void setNumarDePagini(int numarDePagini) {
        this.numarDePagini = numarDePagini;
    }

    public List<Pagina> getPagini() {
        return pagini;
    }

    public void setPagini(List<Pagina> pagini) {
        this.pagini = pagini;
    }

    public String toStringForFile() {
        return getNume() + "-" + getNumarDePagini();

    }

    @Override
    public String toString() {
        return "Numele cartii: " + getNume() + "Numar de pagini: " + getNumarDePagini();
    }
}