package edu.utdallas.cs3354.team15.foundation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * The Player class
 * 
 * Represents an active player within the game.
 * This includes the current and original hand and whether the player is a
 * dealer or is actively playing.
 * The current hand can be modified by consumers.
 * 
 * @author Ben Brothers
 * @version %I%, %G%
 */
public class Player {

	/* Class Attributes */
	private Hand currentHand;
	private Hand originalHand;
	private int points;
	private boolean isDealer;
	private boolean isPlaying;

	/**
	 * constructs a player object
	 */
	public Player() {
		originalHand = new Hand();
		currentHand = originalHand;
		points = 0;
		isDealer = false;
		isPlaying = false;
	}

	/* Member Functions */

	/**
	 * Gets the current hand
	 * 
	 * @return currentHand the current hand
	 */
	public Hand getCurrentHand() {
		return currentHand;
	}

	/**
	 * Gets the original hand
	 * 
	 * @return originalHand the original hand
	 */
	public Hand getOriginalHand() {
		return originalHand;
	}

	/**
	 * sets currend hand
	 * 
	 * @param hand the hand to be set
	 */
	public void setHand(Hand hand) {
		if (hand != null)
			currentHand = hand;
	}

	/**
	 * sets both current and original hand
	 * 
	 * @param hand the hand to be set
	 */
	public void resetHand() {
		ArrayList<Card> h1 = currentHand.getHand();
		Hand h2 = new Hand();
		for (int i = 0; i < 4; i++) {
			Card card1 = new Card(h1.get(i).getSuit(), h1.get(i).getRank(), h1.get(i).getValue());
			h2.addCard(card1);
		}
		originalHand = h2;
	}

	/**
	 * gets the player's points
	 * 
	 * @return points the player's points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * sets the player's points
	 * 
	 * @param p the value to set points to
	 */
	public void setPoints(int p) {
		if (p > 0 && p < Integer.MAX_VALUE)
			points = p;
	}

	/**
	 * adds the player's points
	 * 
	 * @param p the value to add to points
	 */
	public void addPoints(int p) {
		if (p > 0 && p < Integer.MAX_VALUE) {
			System.out.print("Your Points Increased From " + points + " to ");
			points += p;
			System.out.println(points);
		}
	}

	/**
	 * sets Dealer status
	 * 
	 * @param b the boolean to set isDealer to
	 */
	public void setDealer(boolean b) {
		isDealer = b;
	}

	/**
	 * sets Playing status
	 * 
	 * @param b the boolean to set isPlaying to
	 */
	public void setPlaying(boolean b) {
		isPlaying = b;
	}

	/**
	 * gets if the player is the dealer
	 * 
	 * @return isDealer
	 */
	public boolean isDealer() {
		return isDealer;
	}

	/**
	 * gets if the player is playing
	 * 
	 * @return isplaying
	 */
	public boolean isPlaying() {
		return isPlaying;
	}

	/**
	 * Calculates how many points to add for the player's original hand and a
	 * starter card
	 * 
	 * @param startCard the starter card
	 * @return pointsToAdd
	 */
	public int CheckPointsTheShow(Card startCard) {
		int pointsToAdd = 0;
		int rankCounter = 5;

		ArrayList<Card> myArrayList = new ArrayList<Card>();
		for (int i = 0; i < 4; i++) {
			myArrayList.add(originalHand.selectCard(0));
		}
		myArrayList.add(startCard);

		// Check for values adding to 15
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(2).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(3).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(1).getValue() + myArrayList.get(2).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(1).getValue() + myArrayList.get(3).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(1).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(2).getValue() + myArrayList.get(3).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(2).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(3).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() + myArrayList.get(2).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() + myArrayList.get(3).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(2).getValue() + myArrayList.get(3).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(2).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(3).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(1).getValue() + myArrayList.get(2).getValue() + myArrayList.get(3).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(1).getValue() + myArrayList.get(2).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(1).getValue() + myArrayList.get(3).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(2).getValue() + myArrayList.get(3).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() + myArrayList.get(2).getValue()
				+ myArrayList.get(3).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() + myArrayList.get(2).getValue()
				+ myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() + myArrayList.get(3).getValue()
				+ myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(2).getValue() + myArrayList.get(3).getValue()
				+ myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(1).getValue() + myArrayList.get(2).getValue() + myArrayList.get(3).getValue()
				+ myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() + myArrayList.get(2).getValue()
				+ myArrayList.get(3).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}

		// check for pairs
		int count = 0;
		for (int i = 0; i < 5; i++) {
			int temp = 0;

			for (int j = 0; j < 5; j++) {
				if (myArrayList.get(i).getRank() == myArrayList.get(j).getRank()) {
					temp++;
				}
			}

			if (temp > count) {
				count = temp;
			}
		}

		if (count == 4) { // 4 of a kind
			pointsToAdd += 12;
			System.out.println("4 of a kind");
			rankCounter = 2;
		} else { // atleast 1 pair
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < 5; i++) {
				if (!temp.contains(myArrayList.get(i).getRank())) {
					temp.add(myArrayList.get(i).getRank());
				}
			}
			rankCounter = temp.size();
		}

		// 1 pair
		if (count == 2) {
			if (rankCounter == 4) {
				pointsToAdd += 2;
				System.out.println("Pair");
			}
		}
		// 2 pair
		if (count == 2) {
			if (rankCounter == 3) {
				pointsToAdd += 4;
				System.out.println("2 Pair");
			}
		}
		// 3 of a kind
		if (count == 3) {
			if (rankCounter == 3) {
				pointsToAdd += 6;
				System.out.println("3 of a kind");
			}
		}
		// 3 of a kind + 1 pair
		if (count == 3) {
			if (rankCounter == 2) {
				pointsToAdd += 8;
				System.out.println("3 of a kind");
				System.out.println("1 pair");
			}
		}

		// check for flush
		count = 0;
		boolean hasFlush = true;
		for (int i = 0; i < 4; i++) {
			if (myArrayList.get(i).getSuit() != myArrayList.get(0).getSuit()) {
				hasFlush = false;
				break;
			}
		}
		if (hasFlush) {
			if (myArrayList.get(0).getSuit() == myArrayList.get(4).getSuit()) {
				pointsToAdd += 5;
				System.out.println("5 Card Flush");
			} else {
				pointsToAdd += 4;
				System.out.println("4 Card Flush");

			}
		}

		// check for sequences
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			tempList.add(myArrayList.get(i).getRank());
			Collections.sort(tempList);
		}
		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(tempList);
		ArrayList<Integer> tempList2 = new ArrayList<>(hashSet);

		int count1 = 1;
		int count2 = 1;
		int st1 = tempList2.get(0);
		int st2 = st1;
		for (int i = 0; i < tempList2.size() - 1; i++) {
			if (tempList2.get(i + 1) == 1 + tempList2.get(i)) {
				count1++;
				if (count1 > count2) {
					count2 = count1; // count2 stores length of longest run
					st2 = st1;
				}
			} else {
				count1 = 1;
				st1 = tempList2.get(i + 1);
			}
		}
		if (count2 == 5) {
			pointsToAdd += 5;
			System.out.println("sequence of 5");
		} else if (count2 == 4) {
			if (tempList2.size() == 4) {
				// 1 duplicate, run size 4
				pointsToAdd += 8;
				System.out.println("2 sequences of 4");
			} else {
				pointsToAdd += 4;
				System.out.println("sequence of 4");
			}
		} else if (count2 == 3) {
			int count3 = 0;
			int count4 = 0;
			int dup1 = 0;
			// calculate mostduplicates
			for (int i = 0; i < 4; i++) {
				if (tempList.get(i) == tempList.get(i + 1)) {
					count3++;

					dup1 = tempList.get(i);

					if (count3 > count4) {
						count4 = count3;
					}
				} else {
					count3 = 0;
				}
			}
			if (tempList2.size() == 3 && count4 == 2) { // 2 duplicates of the same number (3 runs of 3)
				pointsToAdd += 9;
				System.out.println("3 sequences of 3");
			} else if (count4 == 0) { // no duplicates (1 run of 3)
				pointsToAdd += 3;
				System.out.println("1 sequence of 3");
			} else {
				if (dup1 >= st2 && dup1 <= st2 + 2) {
					if (tempList2.size() == 4) { // 2 runs of 3
						pointsToAdd += 6;
						System.out.println("2 sequences of 3");
					} else { // 4 runs of 3
						pointsToAdd += 12;
						System.out.println("4 sequences of 3");
					}
				} else { // pair outside of bounds
					pointsToAdd += 3;
					System.out.println("1 sequence of 3");
				}
			}
		}

		// check for his nobs
		for (int i = 0; i < 4; i++) {
			if ((myArrayList.get(i).getSuit() == myArrayList.get(4).getSuit()) && myArrayList.get(i).getRank() == 11) {
				pointsToAdd += 1;
				System.out.println("and one for his nobs");
			}
		}

		System.out.println("You Get " + pointsToAdd + " Points For This Hand");
		return pointsToAdd;
	}

	/**
	 * Calculates how many points to add for the dealer's crib and a starter card
	 * 
	 * @param startCard the starter card
	 * @param crib      the crib
	 * @return pointsToAdd
	 */
	public int CheckPointsTheShowCrib(Card startCard, Crib crib) {
		int pointsToAdd = 0;
		int rankCounter = 5;

		ArrayList<Card> myArrayList = crib.getCardStack();
		myArrayList.add(startCard);

		// Check for values adding to 15
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(2).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(3).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(1).getValue() + myArrayList.get(2).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(1).getValue() + myArrayList.get(3).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(1).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(2).getValue() + myArrayList.get(3).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(2).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(3).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() + myArrayList.get(2).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() + myArrayList.get(3).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(2).getValue() + myArrayList.get(3).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(2).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(3).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(1).getValue() + myArrayList.get(2).getValue() + myArrayList.get(3).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(1).getValue() + myArrayList.get(2).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(1).getValue() + myArrayList.get(3).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(2).getValue() + myArrayList.get(3).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() + myArrayList.get(2).getValue()
				+ myArrayList.get(3).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() + myArrayList.get(2).getValue()
				+ myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() + myArrayList.get(3).getValue()
				+ myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(2).getValue() + myArrayList.get(3).getValue()
				+ myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(1).getValue() + myArrayList.get(2).getValue() + myArrayList.get(3).getValue()
				+ myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}
		if (myArrayList.get(0).getValue() + myArrayList.get(1).getValue() + myArrayList.get(2).getValue()
				+ myArrayList.get(3).getValue() + myArrayList.get(4).getValue() == 15) {
			pointsToAdd += 2;
			System.out.println("Add to 15");
		}

		// check for pairs
		int count = 0;
		for (int i = 0; i < 5; i++) {
			int temp = 0;

			for (int j = 0; j < 5; j++) {
				if (myArrayList.get(i).getRank() == myArrayList.get(j).getRank()) {
					temp++;
				}
			}

			if (temp > count) {
				count = temp;
			}
		}

		if (count == 4) { // 4 of a kind
			pointsToAdd += 12;
			System.out.println("4 of a kind");
			rankCounter = 2;
		} else { // atleast 1 pair
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < 5; i++) {
				if (!temp.contains(myArrayList.get(i).getRank())) {
					temp.add(myArrayList.get(i).getRank());
				}
			}
			rankCounter = temp.size();
		}

		// 1 pair
		if (count == 2) {
			if (rankCounter == 4) {
				pointsToAdd += 2;
				System.out.println("Pair");
			}
		}
		// 2 pair
		if (count == 2) {
			if (rankCounter == 3) {
				pointsToAdd += 4;
				System.out.println("2 Pair");
			}
		}
		// 3 of a kind
		if (count == 3) {
			if (rankCounter == 3) {
				pointsToAdd += 6;
				System.out.println("3 of a kind");
			}
		}
		// 3 of a kind + 1 pair
		if (count == 3) {
			if (rankCounter == 2) {
				pointsToAdd += 8;
				System.out.println("3 of a kind");
				System.out.println("1 pair");
			}
		}

		// check for flush
		count = 0;
		boolean hasFlush = true;
		for (int i = 0; i < 4; i++) {
			if (myArrayList.get(i).getSuit() != myArrayList.get(0).getSuit()) {
				hasFlush = false;
				break;
			}
		}
		if (hasFlush) {
			if (myArrayList.get(0).getSuit() == myArrayList.get(4).getSuit()) {
				pointsToAdd += 5;
				System.out.println("5 Card Flush");
			}
		}

		// check for sequences
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			tempList.add(myArrayList.get(i).getRank());
			Collections.sort(tempList);
		}
		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(tempList);
		ArrayList<Integer> tempList2 = new ArrayList<>(hashSet);

		int count1 = 1;
		int count2 = 1;
		int st1 = tempList2.get(0);
		int st2 = st1;
		for (int i = 0; i < tempList2.size() - 1; i++) {
			if (tempList2.get(i + 1) == 1 + tempList2.get(i)) {
				count1++;
				if (count1 > count2) {
					count2 = count1; // count2 stores length of longest run
					st2 = st1;
				}
			} else {
				count1 = 1;
				st1 = tempList2.get(i + 1);
			}
		}
		if (count2 == 5) {
			pointsToAdd += 5;
			System.out.println("sequence of 5");
		} else if (count2 == 4) {
			if (tempList2.size() == 4) {
				// 1 duplicate, run size 4
				pointsToAdd += 8;
				System.out.println("2 sequences of 4");
			} else {
				pointsToAdd += 4;
				System.out.println("sequence of 4");
			}
		} else if (count2 == 3) {
			int count3 = 0;
			int count4 = 0;
			int dup1 = 0;
			// calculate mostduplicates
			for (int i = 0; i < 4; i++) {
				if (tempList.get(i) == tempList.get(i + 1)) {
					count3++;

					dup1 = tempList.get(i);

					if (count3 > count4) {
						count4 = count3;
					}
				} else {
					count3 = 0;
				}
			}
			if (tempList2.size() == 3 && count4 == 2) { // 2 duplicates of the same number (3 runs of 3)
				pointsToAdd += 9;
				System.out.println("3 sequences of 3");
			} else if (count4 == 0) { // no duplicates (1 run of 3)
				pointsToAdd += 3;
				System.out.println("1 sequence of 3");
			} else {
				if (dup1 >= st2 && dup1 <= st2 + 2) {
					if (tempList2.size() == 4) { // 2 runs of 3
						pointsToAdd += 6;
						System.out.println("2 sequences of 3");
					} else { // 4 runs of 3
						pointsToAdd += 12;
						System.out.println("4 sequences of 3");
					}
				} else { // pair outside of bounds
					pointsToAdd += 3;
					System.out.println("1 sequence of 3");
				}
			}
		}

		// check for his nobs
		for (int i = 0; i < 4; i++) {
			if ((myArrayList.get(i).getSuit() == myArrayList.get(4).getSuit()) && myArrayList.get(i).getRank() == 11) {
				pointsToAdd += 1;
				System.out.println("and one for his nobs");
			}
		}

		System.out.println("You Get " + pointsToAdd + " Points For The Crib");
		return pointsToAdd;
	}

	public void displayCurrentHand() {
		ArrayList<Card> temp = currentHand.getHand();
		System.out.println("Your Hand Is: ");
		for (int i = 0; i < temp.size(); i++) {
			int displayvalue = i + 1;
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

	public void displayOriginalHand() {
		ArrayList<Card> temp = originalHand.getHand();
		System.out.println(" Your Original Hand Was: ");
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
}
