import javax.swing.*;
import java.util.ArrayList;

public class BlackJackDriver {
    public static void main(String[] args) {

        String pName;
        int pBal, bet, balnceDuringBet;

        ArrayList<Card> deck = Deck.deckBuilder();
        ArrayList<Card> handArray= new ArrayList<Card>();
        Deck bdeck = new Deck(deck);
        bdeck.display();
        bdeck.shuffle();
        bdeck.display();

        pName=JOptionPane.showInputDialog("Please enter your name: ");
        pBal=Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount you would like to deposit: "));

        Deck hand = new Deck();

        for(int i=0; i<2;i++){
            handArray.add(i,bdeck.dealCard());

        }
        hand.setDeck(handArray);

        Player player1 = new Player(pName, hand, pBal);
        System.out.print(player1.getBalance());

        bet=Integer.parseInt(JOptionPane.showInputDialog("Please enter how much you would like to bet: "));
        while (player1.getBalance()<bet){
            bet=Integer.parseInt(JOptionPane.showInputDialog("Your balance is smaller than the bet you entered, please enter a smaller bet: "));
        }

        balnceDuringBet=player1.removeBet(bet);
        System.out.print("\n"+balnceDuringBet);

        player1.getHand().display();

        JOptionPane.showMessageDialog(null, "Your total is " + player1.calcHandValue());

        while(JOptionPane.showConfirmDialog(null, "Would you like another card?")!=JOptionPane.NO_OPTION)
        {
            int hitCounter=2;
            hand.getDeck().add(hitCounter, bdeck.dealCard());
            hitCounter++;
            player1.getHand().display();
            JOptionPane.showMessageDialog(null, "Your total is " + player1.calcHandValue());
        }

        player1.getHand().display();


    }
}
