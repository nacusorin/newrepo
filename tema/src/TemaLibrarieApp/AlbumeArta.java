package TemaLibrarieApp;

/**
 * A child class for the more specific {@link Carti} class.
 *
 * @author Nacu Sorin-Constantin
 * @version 5.2 beta
 * @since 2019-02-20
 */

public class AlbumeArta extends Carti {

    private String calitatehartie;

    public String getCalitatehartie() {
        return calitatehartie;
    }

    public void setCalitatehartie(String calitatehartie) {
        this.calitatehartie = calitatehartie;
    }

    @Override
    public String toStringForFile() {
        return "Albume de arta: " + getNume() + "-" + getNumarDePagini() + "-" + getCalitatehartie();
    }


    @Override
    public String toString() {
        return "Albumul de arta: " + super.getNume() + " cu numarul de pagini: " + super.getNumarDePagini() + " si calitatea hartiei: " + getCalitatehartie();
    }
}


