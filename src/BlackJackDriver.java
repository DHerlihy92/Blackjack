import javax.swing.*;
import java.util.ArrayList;

public class BlackJackDriver {
    public static void main(String[] args) {

        String pName;
        int pBal, bet, balnceDuringBet, pHitCounter = 2, dHitCounter = 2;
        boolean pBust = false, dBust = false;

        ArrayList<Card> deck = Deck.deckBuilder();
        ArrayList<Card> handArray = new ArrayList<Card>();
        ArrayList<Card> dHandArray = new ArrayList<>();
        Deck bdeck = new Deck(deck);
        bdeck.display();
        bdeck.shuffle();
        bdeck.display();

        pName=JOptionPane.showInputDialog("Please enter your name: ");
        pBal=Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount you would like to deposit: "));

        Deck pHand = new Deck();
        Deck dHand = new Deck();

        handArray = dealHand(bdeck);
        pHand.setDeck(handArray);
        handArray = dealHand(bdeck);
        dHand.setDeck(handArray);



        Player player1 = new Player(pName, pHand, pBal);
        Player dealer = new Player("Dealer", dHand, 0);
        System.out.print(player1.getBalance());

        bet=Integer.parseInt(JOptionPane.showInputDialog("Please enter how much you would like to bet: "));
        while (player1.getBalance()<bet){
            bet=Integer.parseInt(JOptionPane.showInputDialog("Your balance is smaller than the bet you entered, please enter a smaller bet: "));
        }

        player1.removeBet(bet);
        System.out.print("\n"+player1.getBalance());

        player1.getHand().display();

        player1.calcHandValue();
        dealer.calcHandValue();
        JOptionPane.showMessageDialog(null, "Your total is " + player1.calcHandValue());

        while(JOptionPane.showConfirmDialog(null, "Would you like another card?")!=JOptionPane.NO_OPTION && player1.calcHandValue()<22 && pHitCounter!=7)
        {
            pHand.getDeck().add(pHitCounter, bdeck.dealCard());
            pHitCounter++;
            player1.getHand().display();
            JOptionPane.showMessageDialog(null, "Your total is " + player1.calcHandValue());
        }
        
        if(player1.calcHandValue()>21)
        {
            pBust=true;
            JOptionPane.showMessageDialog(null, "You have gone bust!");
        }
        dealer.getHand().display();
        JOptionPane.showMessageDialog(null, "Dealers total is " + dealer.calcHandValue());
        while(dealer.calcHandValue()<17){
            dHand.getDeck().add(dHitCounter, bdeck.dealCard());
            dHitCounter++;
            dealer.getHand().display();
            JOptionPane.showMessageDialog(null, "Dealers total is " + dealer.calcHandValue());
        }
        if (dealer.calcHandValue()>21){
            dBust=true;
            JOptionPane.showMessageDialog(null, "Dealer has gone bust");
        }
        dealer.getHand().display();

        if(player1.calcHandValue()>dealer.calcHandValue() && pBust!=true || dBust == true && pBust != true){
            JOptionPane.showMessageDialog(null, "You have won!!");
            bet=bet*2;
            player1.calcWin(bet);
            System.out.print("\n"+player1.getBalance());
        }
        else if(player1.calcHandValue()==dealer.calcHandValue() || pBust == true && dBust == true){
            player1.calcWin(bet);
            System.out.print("\n"+player1.getBalance());
            JOptionPane.showMessageDialog(null, "You and the dealer have drawn!");
        }
        else if(player1.calcHandValue()<dealer.calcHandValue() && dBust != true || pBust==true){
            JOptionPane.showMessageDialog(null, "You have lost to the dealer!");
        }
        else if(pHitCounter==4)
        {
            JOptionPane.showMessageDialog(null, "You have hit a 5 card trick, congrats!");
            bet=bet*3;
            player1.calcWin(bet);
            System.out.print("\n"+player1.getBalance());
        }

    }

    public static ArrayList<Card> dealHand(Deck bdeck){
        ArrayList<Card> handArray = new ArrayList<>();
        for(int i=0; i<2;i++){
            handArray.add(i, bdeck.dealCard());

        }
        return handArray;
    }
}
