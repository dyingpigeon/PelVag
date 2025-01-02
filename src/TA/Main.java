package TA;

public class Main {
    public static void main(String[] args) {
        Front fr = new Front();
        DataHandler HAND = new DataHandler();
        new DataController(fr.getTabHandler(), HAND);
    }
}
        