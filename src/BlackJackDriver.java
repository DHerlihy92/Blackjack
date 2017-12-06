import javax.swing.*;
import java.util.ArrayList;

public class BlackJackDriver {
    public static void main(String[] args) {

        String pName;
        int pBal, endBal, bet, pHitCounter = 2, dHitCounter = 2;
        boolean pBust = false, dBust = false;
        ArrayList<Card> deck = Deck.deckBuilder();
        ArrayList<Card> handArray = new ArrayList<Card>(5);
        ArrayList<Card> dHandArray = new ArrayList<>(5);
        Deck bdeck = new Deck(deck);
        bdeck.display();
        Deck pHand = new Deck();
        Deck dHand = new Deck();

        handArray = dealHand(bdeck);
        pHand.setDeck(handArray);
        dHandArray = dealHand(bdeck);
        dHand.setDeck(dHandArray);


        pName = JOptionPane.showInputDialog("Please enter your name: ");
        pBal = Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount you would like to deposit: "));



        Player player1 = new Player(pName, pHand, pBal);
        Player dealer = new Player("Dealer", dHand, 0);
        System.out.print(player1.getBalance());

        do {
            pHitCounter=2;
            dHitCounter=2;
            pBust=false;
            dBust=false;
            bdeck.shuffle();
            bdeck.display();
           // new BlackjackGUI();
            handArray = dealHand(bdeck);
            pHand.setDeck(handArray);
            dHandArray = dealHand(bdeck);
            dHand.setDeck(dHandArray);

            player1.setHand(pHand);
            dealer.setHand(dHand);
            bet = Integer.parseInt(JOptionPane.showInputDialog("Please enter how much you would like to bet: "));
            while (player1.getBalance() < bet){
                bet = Integer.parseInt(JOptionPane.showInputDialog("Your balance is smaller than the bet you entered, please enter a smaller bet: "));
            }

            player1.removeBet(bet);
            System.out.print("\n" + player1.getBalance());

            player1.getHand().display();

            JOptionPane.showMessageDialog(null, "Your total is " + player1.calcHandValue());

            while (JOptionPane.showConfirmDialog(null, "Would you like another card?") != JOptionPane.NO_OPTION && pHitCounter != 4) {
                pHand.getDeck().add(pHitCounter, bdeck.dealCard());
                pHitCounter++;
                player1.getHand().display();
                JOptionPane.showMessageDialog(null, "Your total is " + player1.calcHandValue());
                if(player1.calcHandValue() >= 22){
                    pBust = true;
                    JOptionPane.showMessageDialog(null, "You have gone bust!");
                    break;
                }
                }

            dealer.getHand().display();
            JOptionPane.showMessageDialog(null, "Dealers total is " + dealer.calcHandValue());

            while (dealer.calcHandValue() < 17) {
                dHand.getDeck().add(dHitCounter, bdeck.dealCard());
                dHitCounter++;
                dealer.getHand().display();
                JOptionPane.showMessageDialog(null, "Dealers total is " + dealer.calcHandValue());
            }

            if (dealer.calcHandValue() > 21) {
                dBust = true;
                JOptionPane.showMessageDialog(null, "Dealer has gone bust");
            }

            if (player1.calcHandValue() > dealer.calcHandValue() && !pBust || dBust && !pBust) {
                JOptionPane.showMessageDialog(null, "You have won!!");
                bet = bet * 2;
                player1.calcWin(bet);
                System.out.print("\n" + player1.getBalance());
            }
            else if (player1.calcHandValue() == dealer.calcHandValue() || pBust && dBust) {
                player1.calcWin(bet);
                System.out.print("\n" + player1.getBalance());
                JOptionPane.showMessageDialog(null, "You and the dealer have drawn!");
            }
            else if (player1.calcHandValue() < dealer.calcHandValue() && !dBust || pBust) {
                JOptionPane.showMessageDialog(null, "You have lost to the dealer!");
            }
            else if (pHitCounter == 4) {
                JOptionPane.showMessageDialog(null, "You have hit a 5 card trick, congrats!");
                bet = bet * 3;
                player1.calcWin(bet);
                System.out.print("\n" + player1.getBalance());
            }
            endBal=player1.getBalance();
        }while(JOptionPane.showConfirmDialog(null, "Would you like to play again?") != JOptionPane.NO_OPTION && player1.getBalance()>0);

        if(endBal==0){
            JOptionPane.showMessageDialog(null, "You have ran out of credits....", "Unlucky!", JOptionPane.WARNING_MESSAGE);
        }
        else if(endBal>pBal) {
            JOptionPane.showMessageDialog(null, "Congratulations you have finished with more credits than you started...you have made: " + (endBal-pBal), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(endBal<pBal){
            JOptionPane.showMessageDialog(null, "Commiserations  you have finished with less credits than you started...you have " + endBal + " left.", "Unlucky!", JOptionPane.WARNING_MESSAGE);
        }
        else if(endBal==pBal){
            JOptionPane.showMessageDialog(null, "Alright, you have finished with the same amount of credits that you started with: " + endBal , "Okay!", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public static ArrayList<Card> dealHand(Deck bdeck){
        ArrayList<Card> handArray = new ArrayList<>();
        for(int i=0; i<2; i++){
            handArray.add(i, bdeck.dealCard());

        }
        return handArray;
    }
}
