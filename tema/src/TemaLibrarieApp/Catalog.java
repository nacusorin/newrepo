package TemaLibrarieApp;

/**
 * <h><hCatalog/>
 * @author Nacu Sorin-Constantin
 * @version 5.2 beta
 * @since 2019-02-20
 */

import org.apache.log4j.Logger;

import javax.swing.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;


public final class Catalog implements CatalogInterfata {

    private static final Logger log = Logger.getLogger(String.valueOf(Catalog.class));

    private List<Carti> catalogul = new ArrayList<>();


    public List<Carti> getCatalogul() {
        return catalogul;
    }

    public void setCatalogul(List<Carti> catalog) {
        this.catalogul = catalog;
    }

    /**
     * intreaba userul ce tip de carte ar vrea sa introduca
     * am folosit {@link JOptionPane(Object)}
     */
    public void addCarti() {
        log.info("adding book");
        int actiuneAditionala = Integer.parseInt(JOptionPane.showInputDialog("\nTasteaza 1 pentru a adauga o nuvela" + "\nTasteaza 2 pentru a adauga un album de arta"));
        switch (actiuneAditionala) {
            case 1:
                addNuvela();
                break;
            case 2:
                addAlbumeArta();
                break;
            default:
                log.error("Actiune invalida!!!");
                break;
        }
    }

    /**
     * metoda folosita pentru a introdu o nuvela
     */
    private void addNuvela() {
        log.info("adding novel");
        Nuvele n = new Nuvele();
        String tempString = JOptionPane.showInputDialog("\nTasteaza numele, numarul de pagini si tipul nuvelei pe care vrei sa o adaugi." + "\nSepara datele doar prin virgula(,)" + "\nEx: nume,pagini,tip");
        String[] tempArray = tempString.split(",");
        n.setNume(tempArray[0]);
        try {
            n.setNumarDePagini(Integer.parseInt(tempArray[1]));
        } catch (CustomException e) {
            log.warn("Error{}",e);
        }
        n.setTipulnuvelei(tempArray[2]);
        catalogul.add(n);
        log.info("\nCartea aceasta: " + n.toString() + " a fost adaugata cu succes in catalog:)");
    }

    /**
     * metoda folosita pentru a adauga un album de arta de la tastatura
     */
    private void addAlbumeArta() {
        log.info("adding ArtAlbum");
        AlbumeArta a = new AlbumeArta();
        String tempString = JOptionPane.showInputDialog("Tasteaza numele,numarul de pagini si calitatea hartiei albumului de arta pe care vrei sa il adaugi." + "\nNumele,numarul si calitatea trebuiesc separate doar prin virgula(,)" + "\nEx: nume,nr,calitate");
        String[] tempArray = tempString.split(",");
        a.setNume(tempArray[0]);
        try {
            a.setNumarDePagini(Integer.parseInt(tempArray[1]));
        } catch (CustomException e) {
            log.warn("Error",e);
        }
        a.setCalitatehartie(tempArray[2]);
        catalogul.add(a);
        log.info("\nCartea: " + a.toString() + " a fost adaugata cu succes in catalog:)");
    }

    public void listCatalog() {
        log.info("\nNumarul de iteme din catalog:" + catalogul.size());
        for (Carti item : catalogul) log.info(item);
    }

    public void removeCarti() {
        Iterator<Carti> it = catalogul.iterator();
        boolean bookExists = false;
        String tempString = JOptionPane.showInputDialog("Tasteaza numele, numarul de pagini si calitatea hartiei sau tipul nuvelei pe care vrei sa-l stergi" + "\nNumele, numarul de pagini si calitatea hartiei sau tipul nuvelei trebuiesc separate doar prin virgula(,)" + "\nEx: Nume,numar de pagini,calitate hartie sau tipul nuvelei");
        String[] tempArray = tempString.split(",");
        AlbumeArta a = new AlbumeArta();
        Nuvele n = new Nuvele();
        a.setNume(tempArray[0]);
        try {
            a.setNumarDePagini(Integer.parseInt(tempArray[1]));
        } catch (Exception e) {
            log.warn("Error",e);
        }
        a.setCalitatehartie(tempArray[2]);
        n.setNume(tempArray[0]);
        try {
            n.setNumarDePagini(Integer.parseInt(tempArray[1]));
        } catch (CustomException e) {
            log.warn("Error {}",e);
        }
        n.setTipulnuvelei(tempArray[2]);
        while (it.hasNext()) {
            Carti book = it.next();
            if (book.hashCode() == a.hashCode() || book.hashCode() == n.hashCode()) {
                it.remove();
                bookExists = true;
                log.info("\nCartea: " + book.toString() + " a fost stearsa cu succes din catalog:)");
            }
        }
        if (!bookExists) log.info("\nCartea nu se afla in catalog :(");
    }

    public void saveCatalog() {
        PrintWriter printCatalog = null;
        try {
            printCatalog = new PrintWriter("src/resources/Catalog.txt");
        } catch (Exception e) {
            log.info("Crearea fisierlui ");
        }
        for (Carti book : catalogul) {
            assert printCatalog != null;
            printCatalog.println(book.toStringForFile());
        }
        assert printCatalog != null;
        printCatalog.close();
    }

    public void loadCatalog() {
        Scanner scan;
        File file = new File("src/resources/Catalog.txt");
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String tempLine = scan.nextLine();
                String[] tempArray = tempLine.split("-");
                AlbumeArta a = new AlbumeArta();
                Nuvele n = new Nuvele();

                if (tempArray[0].equals("Albume de Arta ")) {
                    a.setNume(tempArray[1]);
                    a.setNumarDePagini(Integer.parseInt(tempArray[2]));
                    a.setCalitatehartie(tempArray[3]);
                    catalogul.add(a);
                } else if (tempArray[0].equals("Nuvele ")) {
                    n.setNume(tempArray[1]);
                    n.setNumarDePagini(Integer.parseInt(tempArray[2]));
                    n.setTipulnuvelei(tempArray[3]);
                    catalogul.add(n);
                }


            }
            scan.close();
        } catch (Exception e) {
            log.info("Fisierul .txt va fi creat la iesirea din aplicatie:)");
        }


    }
    private Set<Carti> catalog1 = new HashSet<>();

    public Set<Carti> getCatalog1() {
        return catalog1;
    }

    public void setCatalog1(Set<Carti> catalog) {
        this.catalog1 = catalog;
    }

}
