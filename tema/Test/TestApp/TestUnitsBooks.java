package TestApp;

/**
 * @author Nacu Sorin-Constantin
 * @version 5.2 beta
 * @since 2019-02-20
 */
import TemaLibrarieApp.Carti;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUnitsBooks {

    /**
     * test simplu pentru a verifica afisarea in consola a textului
     */
    @Test
    public void test() {
        System.out.println("Test!!");
    }

    /**
     * test pentru verificarea adaugarii unui item in lista
     */
    @Test
    public void addItemInArray() {

        Carti b = new Carti("name", 100);
        Carti[] newArray = new Carti[0];
        Carti[] tempArray = new Carti[newArray.length + 1];
        int i;
        for (i = 0; i < tempArray.length; i++) ;
        tempArray[newArray.length] = b;
        newArray = tempArray;
        assertEquals(1, newArray.length);
        assertEquals(newArray[0], b);

    }

    /**
     * test pentru verificarea stergerii unui item dintr-o anumita lista
     */
    @Test
    public void removeItemFromArray() {
        Carti[] newArray = new Carti[]{
                new Carti("Alaska", 112),
                new Carti("Sarpe", 99),
                new Carti("SYSKEY", 9999)
        };
        Carti[] tempArray = new Carti[newArray.length - 1];
        int x = 0;
        for (Carti carti : newArray) {
            if (!carti.getNume().equals("Alaska")) {

                x++;
            }
        }
        newArray = tempArray;
        assertEquals(2, newArray.length);
    }


}

