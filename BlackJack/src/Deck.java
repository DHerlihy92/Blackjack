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
    

}
