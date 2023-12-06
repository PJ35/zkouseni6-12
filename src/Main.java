import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> cisla = new ArrayList<>();
        final String SOUBOR = "vstup.txt";
        cisla = nactiCislaZeSouboru(SOUBOR, cisla);
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            cisla.add(random.nextInt());
        }
        zapisCislaDoSouboru(SOUBOR, cisla);
    }

    public static List<Integer> nactiCislaZeSouboru(String SOUBOR, List<Integer> cisla) {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(SOUBOR)))) {
            while (sc.hasNextInt()){
                cisla.add(sc.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Soubor "+SOUBOR+" nenalezen!\n"+e.getLocalizedMessage());
        }
        return cisla;
    }

    public static void zapisCislaDoSouboru(String SOUBOR, List<Integer> cisla) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(SOUBOR/*, true*/)))) {
            for (int cislo : cisla) {
                writer.println(cislo);
            }
        } catch (IOException e) {
            System.err.println("Chyba při zápisu souboru: "+SOUBOR+"!\n"+e.getLocalizedMessage());
        }
    }
}
