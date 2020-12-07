import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerDeck
{

    static ArrayList<Card> deck = new ArrayList<Card>();
    static ArrayList<Card> discardPile = new ArrayList<Card>();

    public static void main(String[] args)
    {
        //build deck
        String[] suits = {"Clubs", "Spades", "Diamonds", "Hearts"};
        String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        for(int suitNum = 0; suitNum < 4; suitNum++)
        {
            for(int cardVal = 0; cardVal < 13; cardVal++)
            {
                deck.add(new Card(values[cardVal], suits[suitNum]));
            }
        }

        Collections.shuffle(deck);

        Scanner in = new Scanner(System.in);
        while(deck.size() > 0)
        {
            System.out.println("How many cards would you like to draw? There are " + deck.size() + " cards left");
            int input = 0;
            do {
                try
                {
                    input = in.nextInt();

                    if (input < 1 || input > 52)
                    {
                        System.out.println("Please enter an integer between 1 and 52, inclusive");
                    }
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Please enter a valid integer");
                    in.nextLine();
                }
            } while (input < 1 || input > 52);

            if (input > deck.size())
            {
                System.out.println("You tried to draw " + input + " cards, but there was only " + deck.size() + " left!");
                input = deck.size();
            }

            for (int i = 0; i < input; i++)
            {
                drawCard();
            }

            if(deck.size() == 0)
            {
                System.out.println("You have gone through the entire deck. Type y if you would like to play again");
                Scanner in2 = new Scanner(System.in);
                String replay = in2.nextLine();
                if(replay.equals("y"))
                {
                    Collections.shuffle(discardPile);
                    while(discardPile.size() > 0)
                    {
                        deck.add(discardPile.remove(0));
                    }
                }
            }
        }
        in.close();

        System.out.println("That's all, go home.");
    }

    public static void drawCard()
    {
        String value = deck.get(0).valueIs();
        String suit = deck.get(0).suitIs();
        System.out.println("You drew a " + value + " of " + suit);
        discardPile.add(deck.remove(0));
    }
}
