package edu.utdallas.cs3354.team15.foundation;

import java.util.ArrayList;
import java.util.Scanner;

public class Round {
    private Card starterCard;
    private ArrayList<Player> players;
    private Deck deck;
    private Crib crib;

    public Round(ArrayList<Player> p) {
        starterCard = null;
        players = p;
        deck = new Deck();
        crib = new Crib();
    }

    public boolean executeTheDeal() {
        int dealerIndex = findDealer();
        int firstPlayerIndex = findFirstPlayer();
        int currentPlayerIndex = firstPlayerIndex;
        int playerCounter = currentPlayerIndex;
        int displayPlayervalue = firstPlayerIndex + 1;
        int deckSize = deck.getSize();
        Scanner input = new Scanner(System.in);

        System.out.println("THE DEAL");

        // discarding to crib
        for (int i = 0; i < players.size(); i++) {
            // iterates thru all players, starting with first nondealer index, use
            // i%(players.size()) to get current index
            if (players.size() == 2) {// 2 players, each discards 2 to crib
                Hand h = new Hand();
                for (int j = 0; j < 6; j++) {
                    h.addCard(deck.drawCard());
                }
                players.get(currentPlayerIndex).setHand(h);
                displayPlayervalue = currentPlayerIndex + 1;
                System.out.print("Player" + displayPlayervalue + ", ");
                players.get(currentPlayerIndex).displayCurrentHand();
                System.out.println("Please select a card to discard to the crib (Enter a number between 1 and 6): ");
                crib.addCard(h.selectCard(input.nextInt() - 1));

                System.out.print("Player" + displayPlayervalue + ", after discarding your first card, ");
                players.get(currentPlayerIndex).displayCurrentHand();
                System.out.println("Please select a card to discard to the crib (Enter a number between 1 and 5): ");
                crib.addCard(h.selectCard(input.nextInt() - 1));

                players.get(currentPlayerIndex).resetHand();
            } else {// 3 players, each discards 1 to crib
                Hand h = new Hand();
                for (int j = 0; j < 5; j++) {
                    h.addCard(deck.drawCard());
                }
                players.get(currentPlayerIndex).setHand(h);
                displayPlayervalue = currentPlayerIndex + 1;
                System.out.print("Player" + displayPlayervalue + ", ");
                players.get(currentPlayerIndex).displayCurrentHand();
                System.out.println("Please select a card to discard to the crib (Enter a number between 1 and 5): ");
                crib.addCard(h.selectCard(input.nextInt() - 1));

                players.get(currentPlayerIndex).resetHand();
            }
            playerCounter++;
            currentPlayerIndex = playerCounter % (players.size());
        }

        if (players.size() == 3) { // add 1 card to the crib from the deck for 3 players
            crib.addCard(deck.drawCard());
        }

        displayPlayervalue = firstPlayerIndex + 1;
        deckSize = deck.getSize();
        System.out.println("Player" + displayPlayervalue + ", cut a card from the deck (enter a number between 1 and "
                + deckSize + "): ");
        starterCard = deck.cut(input.nextInt() - 1);
        // input.close();
        if (starterCard.getRank() == 11) {
            System.out.print("The Starter Card Has Been Chosen... It is the ");
            displayStartCard();
            System.out.println("... 2 for his heels!");
            players.get(dealerIndex).addPoints(2);
            if (players.get(dealerIndex).getPoints() >= 121) {
                return true;
            }
        } else {
            System.out.print("The Starter Card Has Been Chosen... It is the ");
            displayStartCard();
            System.out.println("");
        }

        // input.close();
        return false;
    }

    public boolean executeThePlay() {
        int firstPlayerIndex = findFirstPlayer();
        int currentPlayerIndex = firstPlayerIndex;
        int playerCounter = currentPlayerIndex;
        int displayPlayervalue = firstPlayerIndex + 1;
        int runningTotal = 0;
        int goCounter = 0;
        ArrayList<Card> runningPlay = new ArrayList<Card>();
        Scanner input = new Scanner(System.in);

        System.out.println("THE PLAY");

        boolean finished = false;
        while (!finished) {

            if (canPlay(players.get(currentPlayerIndex), runningPlay)) {
                if (goCounter > 0) { // case for 1 for his go
                    System.out.println("One For His Go, 1 Point to Player" + displayPlayervalue);
                    players.get(currentPlayerIndex).addPoints(1);
                    if (players.get(currentPlayerIndex).getPoints() >= 121) {
                        return true;
                    }
                    goCounter = 0;
                }

                System.out.println("The Current Running Total Is: " + runningTotal);
                if (runningPlay.size() > 0) {
                    System.out.print("The Last Card Played Was The: ");
                    displayCard(runningPlay.get(runningPlay.size() - 1));
                    System.out.println("");
                }

                boolean done = false;
                while (!done) {// until player plays a valid card
                    System.out.println("Player" + displayPlayervalue
                            + ", It Is Your Turn And You Can Play, Please Select A Valid Card From Your Deck To Play");
                    players.get(currentPlayerIndex).displayCurrentHand();

                    int i = input.nextInt();
                    if (i < 1 || i > players.get(currentPlayerIndex).getCurrentHand().getHand().size()) { // check for
                                                                                                          // valid input
                                                                                                          // within hand
                        continue;
                    } else if (players.get(currentPlayerIndex).getCurrentHand().getHand().get(i - 1).getValue()
                            + runningTotal > 31) {
                        continue;
                    } else { // card played is valid
                        Hand h = players.get(currentPlayerIndex).getCurrentHand();
                        int temp = i - 1;
                        Card temp2 = h.selectCard(temp);
                        runningPlay.add(temp2);

                        runningTotal += runningPlay.get(runningPlay.size() - 1).getValue();
                        players.get(currentPlayerIndex).setHand(h);

                        // calculate points score for the play
                        int pointsToAdd = checkForPointsThePlay(runningPlay, runningTotal);
                        players.get(currentPlayerIndex).addPoints(pointsToAdd);
                        if (players.get(currentPlayerIndex).getPoints() >= 121) {
                            return true;
                        }

                        if (runningTotal == 31) {
                            runningTotal = 0;
                            runningPlay = new ArrayList<Card>();
                        }

                        // condition to end the play
                        int cardsleft = 0;
                        for (int j = 0; j < players.size(); j++) {
                            cardsleft += players.get(j).getCurrentHand().getHand().size();
                        }
                        if (cardsleft == 0) {
                            done = true;
                            finished = true;
                            continue;
                        }

                        done = true;

                    }
                }

                if (isLastPlayerWithCards(currentPlayerIndex)) {
                    continue;
                }

            } else {

                // condition to end the play
                int cardsleft = 0;
                for (int i = 0; i < players.size(); i++) {
                    cardsleft += players.get(i).getCurrentHand().getHand().size();
                }
                if (cardsleft == 0) {
                    finished = true;
                    continue;
                }

                if (goCounter == players.size() - 1) {
                    runningTotal = 0;
                    runningPlay = new ArrayList<Card>();
                    System.out.println("Nobody Can Play Any Cards, Resetting the Running Total");
                    goCounter = 0;

                    System.out.println("One For His Go, 1 Point to Player" + displayPlayervalue);
                    players.get(currentPlayerIndex).addPoints(1);
                    if (players.get(currentPlayerIndex).getPoints() >= 121) {
                        return true;
                    }

                    continue;
                }
                boolean done = false;
                while (!done) {// until player enters 0
                    if (players.get(currentPlayerIndex).getCurrentHand().isEmpty()) {
                        done = true;
                        continue;
                    }

                    if (isLastPlayerWithCards(currentPlayerIndex)) {
                        runningTotal = 0;
                        runningPlay = new ArrayList<Card>();
                        done = true;
                        continue;
                    }

                    System.out.println("Player" + displayPlayervalue
                            + ", It Is Your Turn, You Cannot Play A Card, Press 0 To Say Go");
                    if (input.nextInt() == 0) {
                        done = true;
                        goCounter++;
                    }
                }
            }

            // condition to end the play
            int cardsleft = 0;
            for (int i = 0; i < players.size(); i++) {
                cardsleft += players.get(i).getCurrentHand().getHand().size();
            }
            if (cardsleft == 0) {
                finished = true;
                continue;
            }

            playerCounter++;
            currentPlayerIndex = playerCounter % (players.size());
            displayPlayervalue = currentPlayerIndex + 1;
        }

        return false;
    }

    public boolean executeTheShow() {
        int dealerIndex = findDealer();
        int firstPlayerIndex = findFirstPlayer();
        int currentPlayerIndex = firstPlayerIndex;
        int playerCounter = currentPlayerIndex;
        int displayPlayervalue = firstPlayerIndex + 1;
        Scanner input = new Scanner(System.in);

        System.out.println("THE SHOW");

        for (int i = 0; i < players.size(); i++) {
            // iterates thru all players, starting with first nondealer index, use
            // i%(players.size()) to get current index
            displayPlayervalue = currentPlayerIndex + 1;
            System.out.print("Player" + displayPlayervalue + ",");
            players.get(currentPlayerIndex).displayOriginalHand();
            System.out.print("The Starter Card Is The: ");
            displayStartCard();
            System.out.println("");
            // adding points for hand
            int pointsToAdd = players.get(currentPlayerIndex).CheckPointsTheShow(starterCard);
            players.get(currentPlayerIndex).addPoints(pointsToAdd);
            if (players.get(currentPlayerIndex).getPoints() >= 121) {
                return true;
            }

            System.out.println("Press 1 to Continue");
            boolean done = false;
            while (!done) {
                if (input.nextInt() == 1) {
                    done = true;
                }
            }
            // System.out.println("Your Total Points Are: " +
            // players.get(currentPlayerIndex).getPoints());

            if (players.get(currentPlayerIndex).isDealer()) { // case where player is dealer
                System.out.println("Player" + displayPlayervalue + " Is The Dealer, The Crib Is: ");
                displayCrib();
                System.out.print("The Starter Card Is The: ");
                displayStartCard();
                System.out.println("");
                pointsToAdd = players.get(currentPlayerIndex).CheckPointsTheShowCrib(starterCard, crib);
                players.get(currentPlayerIndex).addPoints(pointsToAdd);
                if (players.get(currentPlayerIndex).getPoints() >= 121) {
                    return true;
                }

                System.out.println("Press 1 to Continue");
                done = false;
                while (!done) {
                    if (input.nextInt() == 1) {
                        done = true;
                    }
                }

                // System.out.println("Your Total Points Are: " +
                // players.get(currentPlayerIndex).getPoints());
                // setting the new dealer for next round
                players.get(currentPlayerIndex).setDealer(false);
                playerCounter++;
                currentPlayerIndex = playerCounter % (players.size());
                players.get(currentPlayerIndex).setDealer(true);
            } else {
                playerCounter++;
                currentPlayerIndex = playerCounter % (players.size());
            }

        }

        return false;
    }

    public int findDealer() {
        int index = -1;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).isDealer()) {
                index = i;
            }
        }
        return index;
    }

    public int findFirstPlayer() {
        int index = -1;
        for (int i = 0; i < players.size() - 1; i++) {
            if (players.get(i).isDealer()) {
                index = i + 1;
            }
        }
        if (index == -1) {
            index = 0;
        }
        return index;
    }

    public void displayStartCard() {
        if (starterCard.getRank() == 13) {
            System.out.print("King");
        } else if (starterCard.getRank() == 12) {
            System.out.print("Queen");
        } else if (starterCard.getRank() == 11) {
            System.out.print("Jack");
        } else if (starterCard.getRank() == 1) {
            System.out.print("Ace");
        } else {
            System.out.print(starterCard.getRank());
        }
        System.out.print(" of " + starterCard.getSuit());
    }

    public void displayCard(Card card) {
        if (card.getRank() == 13) {
            System.out.print("King");
        } else if (card.getRank() == 12) {
            System.out.print("Queen");
        } else if (card.getRank() == 11) {
            System.out.print("Jack");
        } else if (card.getRank() == 1) {
            System.out.print("Ace");
        } else {
            System.out.print(card.getRank());
        }
        System.out.print(" of " + card.getSuit());
    }

    public void displayCrib() {
        ArrayList<Card> temp = crib.getCardStack();
        for (int i = 0; i < temp.size(); i++) {
            int displayvalue = i;
            System.out.print("[" + displayvalue + "] ");
            if (temp.get(i).getRank() == 13) {
                System.out.print("King");
            } else if (temp.get(i).getRank() == 12) {
                System.out.print("Queen");
            } else if (temp.get(i).getRank() == 11) {
                System.out.print("Jack");
            } else if (temp.get(i).getRank() == 1) {
                System.out.print("Ace");
            } else {
                System.out.print(temp.get(i).getRank());
            }
            System.out.print(" of " + temp.get(i).getSuit() + "\n");
        }
    }

    public int calculateRunningTotal(ArrayList<Card> rp) {
        int rt = 0;
        for (int i = 0; i < rp.size(); i++) {
            rt += rp.get(i).getValue();
        }
        return rt;
    }

    public boolean canPlay(Player p, ArrayList<Card> rp) {
        int runningPoints = calculateRunningTotal(rp);
        for (int i = 0; i < p.getCurrentHand().getHand().size(); i++) {
            if (runningPoints + p.getCurrentHand().getHand().get(i).getValue() <= 31) {
                return true;
            }
        }
        return false;
    }

    public int checkForPointsThePlay(ArrayList<Card> rp, int rt) {
        int pointsToAdd = 0;
        Card lastPlayedCard = rp.get(rp.size() - 1);

        if (rt == 15) {
            pointsToAdd += 2;
            System.out.println("15 on the board, 2 points for the player");
        } else if (rt == 31) {
            pointsToAdd += 2;
            System.out.println("31 on the board, 2 points for the player");
        }

        // check for pairs
        int counter = 1;
        int index = rp.size() - 2;
        boolean done = false;
        while (!done) {
            if (index < 0) {
                done = true;
            } else if (rp.get(index).getRank() != lastPlayedCard.getRank()) {
                done = true;
            } else {
                counter++;
                index--;
            }
        }

        if (counter == 4) {
            pointsToAdd += 12;
            System.out.println("4 of a kind, 12 points to the player");
        } else if (counter == 3) {
            pointsToAdd += 6;
            System.out.println("3 of a kind, 6 points to the player");
        } else if (counter == 2) {
            pointsToAdd += 2;
            System.out.println("pair, 2 points to the player");
        }

        // check for sequences
        if (rp.size() >= 3) {
            counter = 1;
            for (int i = rp.size() - 1; i > 0; i--) {
                if (rp.get(i - 1).getRank() + 1 == rp.get(i).getRank()) {
                    counter++;
                } else {
                    break;
                }
            }

            if (counter >= 3) {
                pointsToAdd += counter;
                System.out.println("Run of" + counter + ", " + counter + "points to the player");
            }
        }

        return pointsToAdd;
    }

    public boolean isLastPlayerWithCards(int index) {
        for (int i = 0; i < players.size(); i++) {
            if (i != index && !players.get(i).getCurrentHand().isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
