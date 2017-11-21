import javax.swing.*;
import java.util.ArrayList;

public class BlackJackDriver {



    public static void main(String[] args) {

        String pName;
        int pBal, bet, balnceDuringBet, hitCounter=2, balanceAfterBet;

        ArrayList<Card> deck = Deck.deckBuilder();
        ArrayList<Card> handArray= new ArrayList<Card>();
        ArrayList<Card> dHandArray= new ArrayList<>();
        Deck bdeck = new Deck(deck);
        bdeck.display();
        bdeck.shuffle();
        bdeck.display();

        pName=JOptionPane.showInputDialog("Please enter your name: ");
        pBal=Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount you would like to deposit: "));

        Deck pHand = new Deck();
        Deck dHand = new Deck();

        handArray=dealHand(bdeck);
        pHand.setDeck(handArray);
        handArray=dealHand(bdeck);
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

        int pHandTotal=player1.calcHandValue();
        JOptionPane.showMessageDialog(null, "Your total is " + pHandTotal);

        while(JOptionPane.showConfirmDialog(null, "Would you like another card?")!=JOptionPane.NO_OPTION && pHandTotal<22 && hitCounter!=7)
        {
            pHand.getDeck().add(hitCounter, bdeck.dealCard());
            hitCounter++;
            player1.getHand().display();
            JOptionPane.showMessageDialog(null, "Your total is " + pHandTotal);
        }
        
        if(pHandTotal>21)
        {
            JOptionPane.showMessageDialog(null, "You have gone bust!");
        }
        else if(hitCounter==7)
        {
            JOptionPane.showMessageDialog(null, "You have hit a 5 card trick, congrats!");
            bet=bet*3;
            player1.calcWin(bet);
            System.out.print("\n"+player1.getBalance());
        }
        else
        {

        }

        player1.getHand().display();


    }

    public static ArrayList<Card> dealHand(Deck bdeck){
        ArrayList<Card> handArray = new ArrayList<>();
        for(int i=0; i<2;i++){
            handArray.add(i, bdeck.dealCard());

        }
        return handArray;
    }
}
