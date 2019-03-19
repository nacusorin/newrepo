package TemaLibrarieApp;

/**
 * @author Nacu Sorin-Constantin
 * @version 5.2 beta
 * @since 2019-02-20
 */

import javax.swing.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public final class CatalogArray implements CatalogInterfata {

    private Carti[] catalog = new Carti[10];

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogArray that = (CatalogArray) o;
        return Arrays.equals(catalog, that.catalog);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(catalog);
    }

    private int getArrayIndex(Carti[] array, Carti item) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void addCarti() {
        int nullCounter = 0;
        for (Carti item : catalog) {
            if (item == null) nullCounter++;
        }
        if (nullCounter > 0) {
            int tempAddAction = Integer.parseInt(JOptionPane.showInputDialog("\nTasteaza 1 pentru a adauga o nuvela" + "\nTasteaza 2 pentru a adauga un album de arta"));
            switch (tempAddAction) {
                case 1:
                    addNuvela();
                    break;
                case 2:
                    addAlbumArta();
                    break;
                default:
                    System.out.println("Actiune invalida !!.");
                    break;
            }
        } else System.out.println("Libraria este plina !.");
    }

    private void addNuvela() {
        Nuvele n = new Nuvele();

        String tempString = JOptionPane.showInputDialog("\nTasteaza numele, numarul de pagini si tipul nuvelei pe care vrei sa o adaugi." + "\nSepara datele doar prin virgula(,)" + "\nEx: nume,pagini,tip");
        String[] tempArray = tempString.split(",");

        n.setNume(tempArray[0]);
        n.setNumarDePagini(Integer.parseInt(tempArray[1]));
        n.setTipulnuvelei(tempArray[2]);

        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i] == null) {
                catalog[i] = n;
                System.out.println("\nCartea: " + n.toString() + " a fost adaugata in catalog.");
                break;
            }
        }
    }

    private void addAlbumArta() {
        AlbumeArta a = new AlbumeArta();

        String tempString = JOptionPane.showInputDialog("Tasteaza numele,numarul de pagini si calitatea hartiei albumului de arta pe care vrei sa il adaugi." + "\nNumele,numarul si calitatea trebuiesc separate doar prin virgula(,)" + "\nEx: nume,nr,calitate");
        String[] tempArray = tempString.split(",");

        a.setNume(tempArray[0]);
        a.setNumarDePagini(Integer.parseInt(tempArray[1]));
        a.setCalitatehartie(tempArray[2]);

        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i] == null) {
                catalog[i] = a;
                System.out.println("\nCartea: " + a.toString() + " a fost adaugata in catalog.");
                break;
            }
        }
    }

    public void listCatalog() {
        int catalogsize = 0;
        for (Carti item : catalog) {
            if (item != null) catalogsize++;
        }
        System.out.println("\nNumere de iteme in catalog: " + catalogsize);
        for (Carti item : catalog) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    public void removeCarti() {
        boolean bookExists = false;
        String tempName = JOptionPane.showInputDialog("Tasteaza numele cartii pe care vrei sa o stergi:");

        for (Carti item : catalog) {
            if (item != null) {
                if (item.getNume().equals(tempName)) {
                    bookExists = true;
                    System.out.println("\nCartea: " + item.toString() + " a fost stearsa din catalog :)");
                    catalog[getArrayIndex(catalog, item)] = null;
                }
            }
        }
        if (!bookExists) System.out.println("\nCartea nu este in catalog.");
    }

    public void saveCatalog() {
        PrintWriter printCatalog = null;
        try {
            printCatalog = new PrintWriter("src/resources/Catalog.txt");
        } catch (Exception e) {
            System.out.println("Crearea fisierului.");
        }
        for (Carti book : catalog) {
            if (book != null) {
                printCatalog.println(book.toStringForFile());
            }
        }
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

                if (tempArray[0].equals("Albume de arta: ")) {
                    a.setNume(tempArray[1]);
                    a.setNumarDePagini(Integer.parseInt(tempArray[2]));
                    a.setCalitatehartie(tempArray[3]);
                    for (int i = 0; i < catalog.length; i++) {
                        if (catalog[i] == null) {
                            catalog[i] = a;
                            break;
                        }
                    }
                } else if (tempArray[0].equals("Nuvele: ")) {
                    n.setNume(tempArray[1]);
                    n.setNumarDePagini(Integer.parseInt(tempArray[2]));
                    n.setTipulnuvelei(tempArray[3]);
                    for (int i = 0; i < catalog.length; i++) {
                        if (catalog[i] == null) {
                            catalog[i] = n;
                            break;
                        }
                    }
                }
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("Crearea fisierului .txt se va efectua la iesirea din aplicatie.");
        }
    }
}


