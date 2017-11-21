import javax.swing.*;
import java.util.ArrayList;

public class BlackJackDriver {
    public static void main(String[] args) {

        String pName;

        ArrayList<Card> deck = Deck.deckBuilder();
        ArrayList<Card> handArray= new ArrayList<Card>();
        Deck bdeck = new Deck(deck);
        bdeck.display();
        Deck.shuffle(deck);
        bdeck.display();

        pName=JOptionPane.showInputDialog("Please enter your name: ");

        Deck hand = new Deck();

        for(int i=0; i<2;i++){
            handArray.add(i,bdeck.dealCard());

        }
        hand.setDeck(handArray);
        hand.display();
    }
}
