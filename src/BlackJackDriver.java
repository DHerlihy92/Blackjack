import javax.swing.*;

public class BlackJackDriver {
    public static void main(String[] args) {

        Card[] deck = Deck.deckBuilder();
        Deck bdeck = new Deck(deck);
        bdeck.display();
        Deck.shuffle(deck);
        bdeck.display();

    }
}
