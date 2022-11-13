public class Main {
    static public void main(String[] args) throws Exception {
        // trzy osobne zdjęcia
        negatyw neg = new negatyw("1.jpg");
        negatyw n2 = new negatyw("2.jpg");
        negatyw n3 = new negatyw("3.jpg");
        // wykonanie wszystkich 3 na raz w innych wątkach
        neg.start();
        n2.start();
        n3.start();
        try {
            neg.join();
            n2.join();
            n3.join();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
