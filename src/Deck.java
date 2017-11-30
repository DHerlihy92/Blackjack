import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by T00196758 on 09/11/2017.
 */
public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();
    private int dealNo=0;


    public int getDealNo() {
        return dealNo;
    }

    public void setDealNo(int dealNo) {
        this.dealNo = dealNo;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public Deck(ArrayList<Card> deck){
        setDeck(deck);
    }

    public Deck(){this(null);}

    public void display(){
        JTextArea text = new JTextArea();

        for(int i=0;i<deck.size();i++)
        {
            text.append(deck.get(i).toString()+"\n");
        }

        JOptionPane.showMessageDialog(null,text);
    }

    public static ArrayList<Card> deckBuilder() {
        ArrayList<Card> deck = new ArrayList<>();
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
        String[] names = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
        int y = 0, count = 0;

        for (int i = 0; i <= 51; i++) {

            //deck.add(i, new Card());

            if (count < 13) {
                //deck.get(i).setSuit("Hearts");
                //deck.get(i).setValue(values[y]);
                //deck.get(i).setName(names[y]);
                //deck.get(i).setImage("src//Cards//card"+(i)+".png");
                deck.add(i, new Card(names[y], "Hearts", values[y], new ImageIcon("src//Cards//card"+i+".png")));
            }
            if (count >= 13 && count < 26) {
                /*deck.get(i).setSuit("Diamonds");
                deck.get(i).setValue(values[y]);
                deck.get(i).setName(names[y]);*/
                deck.add(i, new Card(names[y], "Diamonds", values[y], new ImageIcon("src//Cards//card"+i+".png")));
            }
            if (count >= 26 && count < 39) {
                /*deck.get(i).setSuit("Clubs");
                deck.get(i).setValue(values[y]);
                deck.get(i).setName(names[y]);*/
                deck.add(i, new Card(names[y], "Clubs", values[y], new ImageIcon("src//Cards//card"+i+".png")));
            }
            if (count >= 39 && count <= 51) {
                /*deck.get(i).setSuit("Spades");
                deck.get(i).setValue(values[y]);
                deck.get(i).setName(names[y]);*/
                deck.add(i, new Card(names[y], "Spades", values[y], new ImageIcon("src//Cards//card"+i+".png")));
            }
            count++;
            y++;
            if (count == 13 || count == 26 || count == 39) {
                y = 0;
            }


        }
        return deck;
    }

    public void shuffle() {
        for ( int i = deck.size()-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck.get(i);
            deck.set(i, deck.get(rand));
            deck.set(rand, temp);
        }
        dealNo=0;
    }

    public Card dealCard(){
        Card card;
        card=deck.get(dealNo);
        dealNo++;

        return card;
    }

    }
