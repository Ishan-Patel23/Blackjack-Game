package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println("House Holds: \n" + this.game.getHouseCards().toString());
        System.out.println("You hold: \n" + this.game.getYourCards().toString());
    }

  @Override
    public boolean hitMe() {
        System.out.println("Another Card? (y/n)");
        String userChoice = user.nextLine();
        boolean hit = false;
        while(!userChoice.equals("y") && !userChoice.equals("n")){
            System.out.println("Another Card? (y/n)");
            userChoice = user.nextLine();
        }
        if(userChoice.equals("y") ){
            hit = true;
        }
        else{
            hit =  false;
        }
        return hit;
    }

  @Override
    public void gameOver() {
       this.display();
        int yourScore = game.score(game.getYourCards());
        int houseScore = game.score(game.getHouseCards());
        System.out.println("House Score: " + houseScore + ", Your Score: " + yourScore);
        if( (yourScore > houseScore || houseScore > 21) && (yourScore <= 21)){
            System.out.println("You Win!");
        }else{
            System.out.println("House Wins!");
        }
       System.out.println("Thanks for playing!");

    }

}