package edu.utdallas.cs3354.team15.foundation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CribbageGame {
    boolean playerHasWon;
    Deck starterDeck;
    int numPlayers;
    ArrayList<Player> playerList;

    public CribbageGame(){
        playerHasWon=false;
        starterDeck = new Deck();
        numPlayers = 0;
        playerList = new ArrayList<Player>();
    }

    public void startGame(){
        int dealerIndex = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the Number of Players (2 or 3)");
        numPlayers = input.nextInt();

        if(numPlayers==2){
            //cutting the deck and determining start card
            Player player1 = new Player();
            Player player2 = new Player();
            boolean dealerSelected=false;
            while(!dealerSelected){
                System.out.println("Player 1, Please Enter A Number Between 1-52 To Cut The Deck: ");
                int index = input.nextInt()-1;
                int p1rank = starterDeck.cut(index).getRank();
                System.out.println("Player 1, the rank of your card is: " + p1rank);
                System.out.println("Player 2, Please Enter A Number Between 1-51 To Cut The Deck: ");
                index = input.nextInt()-1;
                int p2rank = starterDeck.cut(index).getRank();
                System.out.println("Player 2, the rank of your card is: " + p2rank);

                //lowest card becomes dealer
                if(p1rank < p2rank){
                    System.out.println("Player 1 will start as the dealer");
                    dealerIndex=0; //player 1 becomes dealer
                    dealerSelected=true;
                    player1.setDealer(true);
                }
                else if(p2rank < p1rank){
                    System.out.println("Player 2 will start as the dealer");
                    dealerIndex=1; //player 2 becomes dealer
                    dealerSelected=true;
                    player2.setDealer(true);
                }
                else{
                    System.out.println("Your cards are of the same rank, try again...");
                    starterDeck = new Deck(); //reset deck
                    continue;
                }
            }

            playerList.add(player1);
            playerList.add(player2);
        }
        else if(numPlayers==3){
            //cutting the deck and determining start card
            Player player1 = new Player();
            Player player2 = new Player();
            Player player3 = new Player();
            boolean dealerSelected=false;
            while(!dealerSelected){
                System.out.println("Player 1, Please Enter A Number Between 1-52 To Cut The Deck: ");
                int index = input.nextInt()-1;
                int p1rank = starterDeck.cut(index).getRank();
                System.out.println("Player 1, the rank of your card is: " + p1rank);
                System.out.println("Player 2, Please Enter A Number Between 1-51 To Cut The Deck: ");
                index = input.nextInt()-1;
                int p2rank = starterDeck.cut(index).getRank();
                System.out.println("Player 2, the rank of your card is: " + p2rank);
                System.out.println("Player 3, Please Enter A Number Between 1-50 To Cut The Deck: ");
                index = input.nextInt()-1;
                int p3rank = starterDeck.cut(index).getRank();
                System.out.println("Player 3, the rank of your card is: " + p3rank);
                
                boolean minfound = false;
                int min = Math.min(p1rank, Math.min(p2rank, p3rank));
                if (min == p1rank && p1rank != p2rank && p1rank != p3rank){
                    minfound = true;
                }
                else if(min == p2rank && p2rank != p1rank && p2rank != p3rank){
                    minfound = true;
                }
                else if(min == p3rank && p3rank != p1rank && p3rank != p2rank){
                    minfound = true;
                }

                //lowest card becomes dealer
                if(minfound){
                    if(min == p1rank){//player 1 becomes dealer
                        System.out.println("Player 1 will start as the dealer");
                        dealerIndex=0;
                        dealerSelected=true;
                        player1.setDealer(true);
                    }
                    else if(min == p2rank){//player 2 becomes dealer
                        System.out.println("Player 2 will start as the dealer");
                        dealerIndex=1;
                        dealerSelected=true;
                        player2.setDealer(true);
                    }
                    else{//player 3 becomes dealer
                        System.out.println("Player 3 will start as the dealer");
                        dealerIndex=0; //player 3 becomes dealer
                        dealerSelected=true;
                        player3.setDealer(true);
                    }
                }
                else{
                    System.out.println("Minimum rank not found, try again...");
                    starterDeck = new Deck(); //reset deck
                    continue;
                }
            }

            playerList.add(player1);
            playerList.add(player2);
            playerList.add(player3);
        }
        else{
            System.out.println("Error: Bad Input");
            return;
        }

        //input.close();

        while(!playerHasWon){
            Round gameRound = new Round(playerList);
            System.out.println("Round Started");
            if(gameRound.executeTheDeal()){
                playerHasWon = true;
                continue;
            }
            if(gameRound.executeThePlay()){
                playerHasWon = true;
                continue;
            }
            if(gameRound.executeTheShow()){
                playerHasWon = true;
                continue;
            }
        }

        for(int k = 0; k<playerList.size(); k++){
            if(playerList.get(k).getPoints() >= 121){
                int displayNumber = k+1;
                System.out.println("Player" + displayNumber + " Has Won The Game!");
                System.out.println("Thank You For Playing!");
            }
        }
    
        return;
    }

}
