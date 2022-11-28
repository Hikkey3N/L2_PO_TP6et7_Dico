public class Main {
    public static void main(String[] args) {

        DicoListe testDico = new DicoListe();
        testDico.associe("First", "1");
        testDico.associe("Second", "2");
        testDico.associe("Third", "3");
        testDico.associe("First", "2");
        testDico.associe("Second", "2");

        System.out.println(testDico.get("First"));
        System.out.println(testDico.get("First"));
        System.out.println(testDico.get("Second"));
        System.out.println(testDico.get("Third"));



    }
}