package TemaLibrarieApp;
/**
 * @author Nacu Sorin-Constantin
 * @version 5.2 beta
 * @since 2019-02-20
 */


import javax.swing.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Librarie {
    /**
     * logger
     */
    private static final Logger log = Logger.getLogger(String.valueOf(Librarie.class));

    public static void main(String[] args) throws CustomException {
        BasicConfigurator.configure();
        log.debug("Debug");
        log.info("Library works");
        log.warn("Caution!");
        log.error("Ceva nu bate!");
        log.fatal("ERROR!!!");


        Catalog cata = new Catalog();
        int action;
        cata.loadCatalog();

        do {
            action = Integer.parseInt(JOptionPane.showInputDialog("                   Salutare!" + "\n\nTasteaza 1 pentru a adauga o carte" + "\n\nTasteaza 2 pentru a sterge o carte" + "\n\nTasteaza 3 pentru a vedea catalogul" + "\n\nTasteaza 0 pentru iesire"));
            switch (action) {
                case 1:
                    cata.addCarti();
                    break;
                case 2:
                    cata.removeCarti();
                    break;
                case 3:
                    cata.listCatalog();
                    break;
                case 0:
                    log.info("\nIesire din catalog");
                    cata.saveCatalog();
                    break;
                default:
                    log.info("\nActiune nevalida");
                    break;
            }

        } while (action != 0);


    }


}
