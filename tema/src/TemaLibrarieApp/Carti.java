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

    public Carti(){ }

    public Carti(String nume,int numarDePagini){
        this.nume=nume;
        this.numarDePagini=numarDePagini;
    }

    /**
     * metoda getter pentru returnarea numelui cartii
     * @return numele cartii
     */
    public String getNume() {
        return nume;
    }

    /**
     * metoda setter ce seteaza numele cartii
     * @param nume carte de tip string
     */
    public void setNume(String nume) {
        this.nume = nume;

    }


    public int getNumarDePagini() {
        return numarDePagini;
    }

    public void setNumarDePagini(int numarDePagini) throws CustomException {
        if(numarDePagini<50) throw new CustomException("Pagini mai multe!");
        else this.numarDePagini = numarDePagini;
    }


    public List<Pagina> getPagini() {
        return pagini;
    }

    public void setPagini(List<Pagina> pagini) {
        this.pagini = pagini;
    }

    /**
     * metoda folosita pentru a salva carti si va fi volosita
     * pentru popularea listei catalogului
     * @return o reprezentare specifica instantei @Carti
     */
    public String toStringForFile() {
        return getNume() + "-" + getNumarDePagini();

    }

    /**
     *
     * @return  elementele cartii (reprezentare a instantei Carti)
     */
    @Override
    public String toString() {
        return "Numele cartii: " + getNume() + "Numar de pagini: " + getNumarDePagini();
    }

}