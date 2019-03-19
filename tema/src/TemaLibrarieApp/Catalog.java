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

    private List<Carti> catalog = new ArrayList<>();
    private Carti[] catalogArray = new Carti[10];

    public List<Carti> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<Carti> catalog) {
        this.catalog = catalog;
    }

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

    private void addNuvela() {
        log.info("adding novel");
        Nuvele n = new Nuvele();
        String tempString = JOptionPane.showInputDialog("\nTasteaza numele, numarul de pagini si tipul nuvelei pe care vrei sa o adaugi." + "\nSepara datele doar prin virgula(,)" + "\nEx: nume,pagini,tip");
        String[] tempArray = tempString.split(",");
        n.setNume(tempArray[0]);
        n.setNumarDePagini(Integer.parseInt(tempArray[1]));
        n.setTipulnuvelei(tempArray[2]);
        catalog.add(n);
        log.info("\nCartea: " + n.toString() + " a fost adaugata cu succes in catalog:)");
    }

    private void addAlbumeArta() {
        AlbumeArta a = new AlbumeArta();
        String tempString = JOptionPane.showInputDialog("Tasteaza numele,numarul de pagini si calitatea hartiei albumului de arta pe care vrei sa il adaugi." + "\nNumele,numarul si calitatea trebuiesc separate doar prin virgula(,)" + "\nEx: nume,nr,calitate");
        String[] tempArray = tempString.split(",");
        a.setNume(tempArray[0]);
        a.setNumarDePagini(Integer.parseInt(tempArray[1]));
        a.setCalitatehartie(tempArray[2]);
        catalog.add(a);
        System.out.println("\nCartea: " + a.toString() + " a fost adaugata cu succes in catalog:)");
    }

    public void listCatalog() {
        System.out.println("\nNumarul de iteme din catalog:" + catalog.size());
        for (Carti item : catalog) System.out.println(item);
    }

    public void removeCarti() {
        Iterator<Carti> it = catalog.iterator();
        boolean bookExists = false;
        String tempString = JOptionPane.showInputDialog("Tasteaza numele, numarul de pagini si calitatea hartiei sau tipul nuvelei pe care vrei sa-l stergi" + "\nNumele, numarul de pagini si calitatea hartiei sau tipul nuvelei trebuiesc separate doar prin virgula(,)" + "\nEx: Nume,numar de pagini,calitate hartie sau tipul nuvelei");
        String[] tempArray = tempString.split(",");
        AlbumeArta a = new AlbumeArta();
        Nuvele n = new Nuvele();
        a.setNume(tempArray[0]);
        a.setNumarDePagini(Integer.parseInt(tempArray[1]));
        a.setCalitatehartie(tempArray[2]);
        n.setNume(tempArray[0]);
        n.setNumarDePagini(Integer.parseInt(tempArray[1]));
        n.setTipulnuvelei(tempArray[2]);
        while (it.hasNext()) {
            Carti book = it.next();
            if (book.hashCode() == a.hashCode() || book.hashCode() == n.hashCode()) {
                it.remove();
                bookExists = true;
                System.out.println("\nCartea: " + book.toString() + " a fost stearsa cu succes din catalog:)");
            }
        }
        if (!bookExists) System.out.println("\nCartea nu se afla in catalog :(");
    }

    public void saveCatalog() {
        PrintWriter printCatalog = null;
        try {
            printCatalog = new PrintWriter("src/resources/Catalog.txt");
        } catch (Exception e) {
            System.out.println("Crearea fisierlui ");
        }
        for (Carti book : catalog) {
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
                    catalog.add(a);
                } else if (tempArray[0].equals("Nuvele ")) {
                    n.setNume(tempArray[1]);
                    n.setNumarDePagini(Integer.parseInt(tempArray[2]));
                    n.setTipulnuvelei(tempArray[3]);
                    catalog.add(n);
                }


            }
            scan.close();
        } catch (Exception e) {
            System.out.println("Fisierul .txt va fi creat la iesirea din aplicatie:)");
        }


    }
    private Set<Carti> catalogul = new HashSet<>();

    public Set<Carti> getCatalogul() {
        return catalogul;
    }

    public void setCatalogul(Set<Carti> catalog) {
        this.catalogul = catalog;
    }

}
