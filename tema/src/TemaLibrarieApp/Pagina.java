package TemaLibrarieApp;

/**
 * @author Nacu Sorin-Constantin
 * @version 5.2 beta
 * @since 2019-02-20
 */

public class Pagina {
    private String continut;
    private int numarPagina;

    /**
     * getter si setter pentru numar de pagina si continut
     * @return numar pagina si continut
     * @param # strings
     */
    public int getNumarPagina() {
        return numarPagina;
    }

    public void setNumarPagina(int numarPagina) {
        this.numarPagina = numarPagina;
    }

    public String getContinut() {
        return continut;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }
}
