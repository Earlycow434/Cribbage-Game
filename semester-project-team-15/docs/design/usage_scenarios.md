# Usage Scenarios
| Scenario Name: Placing Pegs |
| :-- |
| 1 - Game places 2 pegs for each person on board. |

| Scenario Name: Selecting First Dealer |
| :-- |
| 1 - Game shuffles the deck. <br> 2 - Player 1 cuts the deck and selects a card. <br>3 - Player 2 cuts the deck and selects a card. <br>4 - Game assigns dealer to player with the lowest card. |

| Scenario Name: Dealing Cards |
| :-- |
| 1 - Game shuffles the deck. <br>2 - Non-Dealer cuts the deck. <br>3 - Non-Dealer Draws a card from the draw pile. <br>4 - Game updates draw pile and Non-Dealer hand. <br>5 - Dealer draws a card from the draw pile. <br>6 - Game updates draw pile and Dealer hand. <br>7 - Repeat steps 3-6 until each player has 6 cards in their hand. |

| Scenario Name: Discarding in Crib |
| :-- |
| 1 - Non-Dealer selects two cards from hand. <br>2 - Game adds the two cards to the crib. <br>3 - Non-Dealer draws two cards from the draw pile. <br>4 - Game updates draw pile and Non-Dealer hand. <br>5 - Dealer selects two cards from hand. <br>6 - Game adds the two cards to the crib. <br>7 - Dealer draws two cards from the draw pile. <br>8 - Game updates draw pile and Dealer hand. |

| Scenario Name: Obtaining Start Card |
| :-- |
| 1 - Game randomly selects a card from inside the deck. <br>2 - Game updates the start card. <br>3 - If start card is a Jack game moves Dealer's lowest peg 1 point ahead of the Dealer's highest peg on the game board. |

| Scenario Name: Playing Cards |
| :-- |
| 1 - Game displays a list of cards already played. <br>2 - Game displays the running total. <br>3 - Game displays to Non-Dealer their current hand. <br>4 - Game prompts Non-Dealer to select a card. <br>5 - Non-Dealer selects a card to play. <br>6 - If card is valid, go to step 8. <br> 7 - Game prompts Non-Dealer to select a new card, or enter "GO" if they do not have a valid card. <br>8 - Game updates cards played. <br>9 - Game updates running total. <br>10 - Repeat steps 1-9 for Dealer. <br>11 - If both players enter "GO" in successive turns, game resets the running total. <br>12 - Repeat steps 1-11 until neither player has any cards left in their hands.  |

| Scenario Name: Scoring Points while Playing Cards |
| :-- |
| 1 - If the running total = 31 or 15, go to step 8. <br>2 - If the player says go, go to step 7. <br>3 - If the player plays the same ranked card as the previously played card, go to step 8. <br>4 - If the player plays the same ranked card as the previously played card, and the previously played card has the same rank as the card played before it, go to step 9. <br>5 - If the player plays the same ranked card aas the previously played card, and the previously played card has the same rank as the 2 cards played before it, go to step 10. <br>6 - If the player plays a card, and the past 3 or more cards have been consecutive in rank (I.E. 1,2,3..), go to step 11. <br>7 - Game moves Player's lowest peg 1 point ahead of the Player's highest peg on the game board, end scenario. <br>8 - Game moves Player's lowest peg 2 points ahead of the Player's highest peg on the game board, end scenario. <br>9 - Game moves Player's lowest peg 6 points ahead of the Player's highest peg on the game board, end scenario. <br>10 - Game moves Player's lowest peg 12 points ahead of the Player's highest peg on the game board, end scenario. <br>11 - Game calculates number of successive cards (x) and moves Player's lowest peg x points ahead of the Player's highest peg on the game board, end scenario.  |

| Scenario Name: The Show |
| :-- |
| 1 - Game compares Non-Dealer's hand to the start card. <br>2 - Game updates Non-Dealer's score on game board. <br>3 - Repeat steps 1 and 2 for Dealer. <br>4 - Game compares cards in crib to start card. <br>5 - Game updates Dealer's score on game board.  |

| Scenario Name: Winning the game |
| :-- |
| 1 - If a player reaches 121 points, game displays a message stating that the player won. <br>2 - Game will update the hands, game board, and crib, and prompt the player to play again. |