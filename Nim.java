import java.util.Scanner;

public class Nim {
    public void play() {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.print("Enter name of Player 1: ");
        String name1 = sc.nextLine();
        System.out.println("Welcome, " + name1 + "!\n");

        System.out.print("Enter name of Player 2: ");
        String name2 = sc.nextLine();
        System.out.println("Welcome, " + name2 + "!\n");

        Player player1 = new Player(name1);
        Player player2 = new Player(name2);

        int firstMove = (int) (Math.random() * 2 + 1);
        //lastMove bool keeps track of who made the last move; true = player 1, false = player 2
        boolean lastMove = false;
        boolean playAgain = true;

        //Print out current number of board pieces
        //Continue playing game and subtract pieces from board until one piece is left, indicating the loser / winner
        while (playAgain == true) {
            while (Board.getBoardPieces() > 1) {
                System.out.println("There are currently " + Board.getBoardPieces() + " pieces remaining.");
                int min = 1;
                int max = Board.getBoardPieces() / 2;
                int piecesToRemove = 0;
    
                if (firstMove == 1) {
                    lastMove = true;
                    System.out.print(player1.getName() + ", please choose between " + min + " and " + max + " pieces to remove: ");
                    piecesToRemove = sc.nextInt();
                    while (piecesToRemove < min || piecesToRemove > max) {
                        System.out.println("Invalid input. Please try again.");
                        System.out.print(player1.getName() + ", please choose between " + min + " and " + max + " pieces to remove: ");
                        piecesToRemove = sc.nextInt();
                    }
                    System.out.println("\n" + player1.getName() + " has chosen to remove " + piecesToRemove + " pieces.\n");
                    Board.removeBoardPieces(piecesToRemove);
                    firstMove = 2;
                }
    
                else {
                    lastMove = false;
                    System.out.print(player2.getName() + ", please choose between " + min + " and " + max + " pieces to remove: ");
                    piecesToRemove = sc.nextInt();
                    while (piecesToRemove < min || piecesToRemove > max) {
                        System.out.println("Invalid input. Please try again.");
                        System.out.print(player1.getName() + ", please choose between " + min + " and " + max + " pieces to remove: ");
                        piecesToRemove = sc.nextInt();
                    }
                    System.out.println("\n" + player2.getName() + " has chosen to remove " + piecesToRemove + " pieces.\n");
                    Board.removeBoardPieces(piecesToRemove);
                    firstMove = 1;
                }
            }
            //Print out winner or loser; winner has lastMove == true, loser has lastMove == false
            if (lastMove) {
                System.out.println("Congratulations " + player1.getName() + ", you won this round!");
                player1.addScore();
            }
            else {
                System.out.println("Congratulations " + player2.getName() + ", you won this round!");
                player2.addScore();
            }
    
            //Print current score
            System.out.println("Score: " + player1.getName() + " - " + player1.getScore() + " || " + player2.getName() + " - " + player2.getScore() + "\n");

            //Ask if players want to play again
            System.out.print("Would you like to play again? (y/n): ");
            String userInput = sc2.nextLine();
            while (userInput != "y" || userInput!= "n") {
                if (userInput.equals("y")) {
                    playAgain = true;
                    Board.populate();
                    break;
                }
                else if (userInput.equals("n")) {
                    System.out.println("Thanks for playing!\n\n\n");
                    playAgain = false;
                    break;
                }
                else {
                    System.out.println("Incorrect input. Please try again.");
                    System.out.print("Would you like to play again? (y/n): ");
                    userInput = sc.nextLine();
                }
            }
        }
        sc.close();
        sc2.close();
    }
}