import java.util.Random;
import java.util.Scanner;

public class BlackJack
{
    public static void main(String[] args) //main method
    {
        Random rand = new Random(); //imports random number generator object
        Scanner scnr = new Scanner(System.in); //imports scanner object named scnr

        int userVal = 0; //value that the user has in his hand
        int gameNum = 1; // initializes game number
        int dealerWin = 0; //Number of dealer wins
        int tieGames = 0; // Number of tied games
        double userWin = 0; // Number of user wins
        double perWins = 0; // Percentage of wins

        boolean play = true; // boolean has to be true in order to go to main loop
        int menuInput = 1; // will be set equal to playerInput
        int playerInput = 1; //input that goes into switch statement

        System.out.println("START GAME #" + gameNum +"\n"); //Tells user the that the start of th game and game number

        while(play) //First loop so the user can keep playing
        {
            boolean playOn = true; // must be true for the user to enter if menu statement

            switch (playerInput) //switch statement where menuInput/playerInput will go into
                {

                    case 1: //if user inputs 1

                        int newCardVal = rand.nextInt(13) + 1; //Grabs a card value between 1 to 13

                        switch (newCardVal) //switch statement that takes the new card value and prints the card to the user.
                        {
                            case 1:
                                System.out.println("\nYour card is an ACE!"); //If card is a 1. This line is printed
                                break;
                            case 8:
                                System.out.println("\nYour card is an EIGHT!"); //This was done for proper grammar "an eight"
                                break;
                            case 11:
                                System.out.println("\nYour card is a JACK!"); //If random number is 11 the user gets a jack with value of 10
                                break;
                            case 12:
                                System.out.println("\nYour card is a QUEEN!"); //If random number is 12 the user gets a queen with value of 10
                                break;
                            case 13:
                                System.out.println("\nYour card is a KING!"); //If random number is 13 the user gets a king with value of 10
                                break; //breaks are used to terminate out of switch statement
                            default: //For all other card values
                                System.out.println("\nYour card is a " + newCardVal + "!"); // All other values will print out the number of the card to update the user
                                break;
                        }

                        if ((newCardVal == 11)||(newCardVal == 12)|| (newCardVal == 13)) //Because face cards are equal to 10 in BlackJack
                        {
                            newCardVal = 10;
                        }

                        userVal += newCardVal; //Replaces the old user hand value by adding the old value and the new one

                        if (userVal < 21) //Tests that the user has not busted or went over 21. If this condition is true, the user can keep on playing for that game
                        {
                            System.out.println("Your hand is: " + userVal +"\n" ); //Tells the user the value of his or her hand
                        }
                        else //If the user's hand is equal or over to 21 it will execute the following block
                            {
                                playerInput = 2; //This will ensure that case 2 of the switch statement is executed
                                playOn = false; //This boolean is set to false so that the code will not enter the menu if statement
                            }
                        break; //breaks are used to terminate out of switch statement

                    case 2: //Entered if the user inputs 2 or if userVal >= 21

                        int dealVal = rand.nextInt(11) + 16; //selects a hand for the dealer

                        if (userVal > 21) //If the user has gone over 21. He has busted and lost the game
                        {
                            System.out.println("Your hand is: " + userVal + "\n"); //Tells the user the value of his hand
                            System.out.println("You exceeded 21! You lose :(\n"); // Informs the user that he has lost
                            gameNum++; // Adds one to the game number
                            dealerWin++; //Adds one to number of dealer wins
                        }
                        else if(userVal == 21) //if user gets 21 exactly he or she wins
                        {
                            System.out.println("Your hand is: " + userVal + "\n"); // Updates user on the value of his or her card
                            System.out.println("BLACKJACK! You win!\n"); //Lets user know that they have won
                            gameNum++; //Adds one to the game number
                            userWin++; //Adds one to number of user wins

                        }
                        else if (dealVal > 21) //the dealer has busted
                        {
                            System.out.println("Dealer's hand: "+ dealVal); //Lets used know value of dealers hand
                            System.out.println("You win!\n"); //Informs user that they have won
                            userWin++; //adds one to number of user wins
                            gameNum++; // adds one to the game number
                        }
                        else if (userVal > dealVal) //If both the user and dealer have not won or busted, this checks whether the userVal is more
                        {
                            System.out.println("Dealer's hand: "+ dealVal); // Updates user about value of dealer's hand
                            System.out.println("Your hand is: " + userVal + "\n"); // Updates user on the value of his or her hand
                            System.out.println("You win!\n"); //Informs user that they have won
                            gameNum++; // adds one to the current game number
                        }
                        else if (userVal == dealVal) //the case of a tie
                        {
                            System.out.println("Dealer's hand: "+ dealVal); // Updates user about value of dealer's hand
                            System.out.println("Your hand is: " + userVal + "\n"); // Updates user on the value of his or her hand
                            System.out.println("It's a tie! No one wins!\n"); //Informs user of the tie
                            tieGames++; //adds one to number of tie games
                            gameNum++; // adds one to the current game number

                        }
                        else if (userVal < dealVal) //user's hand is lesser than dealer's hand
                        {

                            System.out.println("Your hand is: " + userVal + "\n"); // Updates user about value of user's hand
                            System.out.println("Dealer's hand: "+ dealVal); // Updates user on the value of his or her hand
                            System.out.println("Dealer wins! \n"); // informs user that he or she has lost
                            dealerWin++; //adds one to the number of dealer wins
                            gameNum++; // adds one to the current game number

                        }
                        playerInput = 1; //ensures that the switch statement goes back into case 1
                        userVal = 0; // resets the user's hand
                        playOn = false; //ensures that the user does not enter if menu statement
                        System.out.println("START GAME #" + gameNum +"\n"); // Informs user of start of new game
                        break;

                    case 3: //If user asks for statistics
                        System.out.println("Number of Player wins: " + (int)(userWin)); // Rounds the double of user wins to an int. Displays number of user wins
                        System.out.println("Number of Dealer wins: " + dealerWin); // Displays number of dealer wins
                        System.out.println("Number of tie games: " + tieGames); //Displays number of tie games
                        System.out.println("Total # of games played is: " + (gameNum -1)); //Displays number of total games. -1 because the number of games played is (the current game -1)
                        perWins = (Math.round((userWin / (gameNum - 1))*1000))/10.0; //takes the number of user wins over the games played. Multiplies it by 1000 and divides by 10.0 so that it is a double
                        System.out.println("Percentage of Player wins: " + (perWins) + "%\n"); //Displays the percentage of games won
                        break;

                    case 4: //Terminates the program
                        playOn = false; //Gets out of second while loop
                        play = false; //Gets out of first while loop
                        break;

                    default:// beause of while statement below only integers between 1 - 4 should be inputted. This default may not be fully necessary but it's their just in case
                        break;
                }

                if( playOn)  //if playOn boolean is true, enters if menu statement
                {

                    System.out.println("1. Get another card"); // Following lines print the menu
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit\n");
                    System.out.print("Choose an option:\n");

                    boolean errorInput = false; //Ensures that the next while loop is entered


                    while (!errorInput) //While loop checks that user has entered correct input
                    {
                        if (scnr.hasNextInt()) //enters if user has inputted an integer
                        {
                            menuInput = scnr.nextInt(); //takes the inputted integer as the menuInput
                            if (menuInput >= 1 && menuInput <= 4) //checks that the integer is between 1 and 4
                            {
                                errorInput = true; //Gets out of while loop
                            }
                            else
                            {
                                System.out.println("\nInvalid input!\nPlease enter an integer value between 1 and 4\n"); //Informs user of invalid input
                                System.out.println("1. Get another card"); //Reprints and menu and has user try again
                                System.out.println("2. Hold hand");
                                System.out.println("3. Print statistics");
                                System.out.println("4. Exit\n");
                                System.out.print("Choose an option:\n");

                            }
                        }
                        else //if user has not inputted a integer
                        {
                            scnr.next();
                            System.out.println( "\nInvalid input!\nPlease enter an integer value between 1 and 4\n");  //Informs user of invalid input
                            System.out.println("1. Get another card"); //Reprints and menu and has user try again
                            System.out.println("2. Hold hand");
                            System.out.println("3. Print statistics");
                            System.out.println("4. Exit\n");
                            System.out.print("Choose an option:\n");

                        }
                    }
                        playerInput = menuInput; //sets playerInput = to menuInput to go back into switch statement
                }
        }
    }
}


