package TemaLibrarieApp;

/**
 * A child class for the more specific {@link Carti} class.
 *
 * @author Nacu Sorin-Constantin
 * @version 5.2 beta
 * @since 2019-02-20
 */

public class Nuvele extends Carti {

    private String tipulnuvelei;

    public String getTipulnuvelei() {
        return tipulnuvelei;
    }

    public void setTipulnuvelei(String tipulnuvelei) {
        this.tipulnuvelei = tipulnuvelei;
    }

    @Override
    public String toStringForFile() {
        return "Nuvela-" + getNume() + "-" + getNumarDePagini() + "-" + getTipulnuvelei();
    }

    @Override
    public String toString() {
        return "Nuvela " + super.getNume() + " cu numarul de pagini " + super.getNumarDePagini() + " si tipul " + getTipulnuvelei();
    }
}
