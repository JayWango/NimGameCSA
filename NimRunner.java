public class NimRunner {
    public static void main(String[] args) {
        System.out.println("\nWelcome to the game of Nim!");
        Board.populate();
        Nim nim = new Nim();
        nim.play();
    }
}
