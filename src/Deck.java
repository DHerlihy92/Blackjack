import javax.swing.*;

/**
 * Created by T00196758 on 09/11/2017.
 */
public class Deck {
    private Card[] deck = new Card[52];

    public Card[] getDeck() {
        return deck;
    }

    public void setDeck(Card[] deck) {
        this.deck = deck;
    }

    public Deck(Card[] deck){
        setDeck(deck);
    }

    public Deck(){this(null);}

    public void display(){
        JTextArea text = new JTextArea();

        for(int i=0;i<deck.length;i++)
        {
            text.append(deck[i].toString()+"\n");
        }

        JOptionPane.showMessageDialog(null,text);
    }

    public static Card[] deckBuilder() {
        Card[] deck = new Card[52];
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
        String[] names = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
        int y = 0, count = 0;

        for (int i = 0; i <= 51; i++) {

            deck[i] = new Card();

            if (count < 13) {
                deck[i].setSuit("Hearts");
                deck[i].setValue(values[y]);
                deck[i].setName(names[y]);
            }
            if (count >= 13 && count < 26) {
                deck[i].setSuit("Diamonds");
                deck[i].setValue(values[y]);
                deck[i].setName(names[y]);
            }
            if (count >= 26 && count < 39) {
                deck[i].setSuit("Clubs");
                deck[i].setValue(values[y]);
                deck[i].setName(names[y]);
            }
            if (count >= 39 && count <= 51) {
                deck[i].setSuit("Spades");
                deck[i].setValue(values[y]);
                deck[i].setName(names[y]);
            }
            count++;
            y++;
            if (count == 13 || count == 26 || count == 39) {
                y = 0;
            }

        }
        return deck;
    }

    public static void shuffle(Card[] deck) {
        for ( int i = deck.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
    }
    }
