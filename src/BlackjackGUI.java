import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BlackjackGUI extends JFrame implements ActionListener{

    private JFrame bFrame = new JFrame("Blackjack");
    private JPanel blackjackDealer, blackjackPlayer, buttons, blackjackNewGameMenu, blackjackAddUser, blackjackGameMenu;
    private JButton hit, stay, newGame, exitGame, exitGame1, newUser, howToPlay;
    private JLabel dealerCard1, dealerCard2, playerCard1, playerCard2;
    private ImageIcon back;
    private ArrayList<Card> handArray, dHandArray, deck;
    private Deck bdeck, pHand, dHand;

    public BlackjackGUI(){


        handArray = new ArrayList<Card>(5);
        dHandArray = new ArrayList<Card>(5);
        deck = Deck.deckBuilder();
        bdeck = new Deck(deck);

        bFrame.setLocation(100,100);
        bFrame.setSize(800, 900);
        bFrame.setLayout( new GridLayout(3,1));

        back = new ImageIcon("Images/backCard.png");

        //JPanel for Dealer
        blackjackDealer = new JPanel();
        blackjackDealer.setSize(800,300);
        blackjackDealer.setBackground(Color.red);
        blackjackDealer.setLayout(new FlowLayout());
        dealerCard1 = new JLabel();
        dealerCard1.setIcon(back);
        dealerCard2 = new JLabel();
        dealerCard2.setIcon(back);
        blackjackDealer.add(dealerCard1);
        blackjackDealer.add(dealerCard2);



        //JPanel for Dealer
        blackjackPlayer = new JPanel();
        blackjackPlayer.setSize(800,300);
        blackjackPlayer.setBackground(Color.blue);
        blackjackPlayer.setLayout(new FlowLayout());
        playerCard1 = new JLabel();
        playerCard1.setIcon(back);
        playerCard2 = new JLabel();
        playerCard2.setIcon(back);
        blackjackPlayer.add(playerCard1);
        blackjackPlayer.add(playerCard2);

        //JPanel for buttons
        buttons = new JPanel();
        buttons.setSize(800, 300);
        buttons.setBackground(Color.green);
        buttons.setLayout(new FlowLayout());


        //JPanel for new game buttons
        blackjackNewGameMenu = new JPanel();
        blackjackNewGameMenu.setSize(800,100);
        blackjackNewGameMenu.setLayout(new FlowLayout());
        newGame = new JButton("New Game");
        exitGame = new JButton("Exit Game");
        newGame.setSize(100,20);
        exitGame.setSize(100, 20);
        newGame.addActionListener(this);
        exitGame.addActionListener(this);
        newGame.setToolTipText("Start a new game of Blackjack");
        exitGame.setToolTipText("Exit the game");
        blackjackNewGameMenu.add(newGame);
        blackjackNewGameMenu.add(exitGame);
        blackjackNewGameMenu.setVisible(true);

        //JPanel for adding a user
        blackjackAddUser = new JPanel();
        blackjackAddUser.setSize(500, 200);
        blackjackAddUser.setLayout(new FlowLayout());
        newUser = new JButton("New User");
        howToPlay = new JButton("How to play");
        exitGame1 = new JButton("Exit Game");
        newUser.addActionListener(this);
        howToPlay.addActionListener(this);
        exitGame1.addActionListener(this);
        newUser.setToolTipText("Add a new User");
        howToPlay.setToolTipText("Learn the rules of BlackJack");
        blackjackAddUser.add(newUser);
        blackjackAddUser.add(howToPlay);
        blackjackAddUser.add(exitGame1);
        blackjackAddUser.setVisible(false);

        //JPanel for blackjack
        blackjackGameMenu = new JPanel();
        blackjackGameMenu.setSize(800,300);
        blackjackGameMenu.setLayout(new FlowLayout());
        hit = new JButton("Hit");
        hit.addActionListener(this);
        blackjackGameMenu.add(hit);
        stay = new JButton("Stay");
        stay.addActionListener(this);
        blackjackGameMenu.add(stay);
        blackjackGameMenu.setVisible(false);


        buttons.add(blackjackNewGameMenu);
        buttons.add(blackjackAddUser);
        buttons.add(blackjackGameMenu);
        //Implement JFrame
        bFrame.add(blackjackDealer);
        bFrame.add(blackjackPlayer);
        bFrame.add(buttons);
        //bFrame.add(blackjackPanel1);


        bFrame.setVisible(true);

    }


    public static void main(String[] args){
        new BlackjackGUI();
    }


    public void actionPerformed(ActionEvent e){
        if (e.getSource()==exitGame || e.getSource()==exitGame1){
            System.exit(0);
        }
        if(e.getSource()==newGame){
            blackjackNewGameMenu.setVisible(false);
            blackjackAddUser.setVisible(true);
        }
        if(e.getSource()==howToPlay){
            JOptionPane.showMessageDialog(null, "The object of Blackjack is to get to beat the dealer " +
                    "by getting as close to 21 as possible. The player and dealer are \n dealt 2 cards at the beginning. The player " +
                    "then decides to add cards(hit) or not(stay). If the player stays or goes\n bust(goes over 21) then the deals adds " +
                    "cards until they are over 17 or bust. If neither player goes bust then the\n player closest to 21 wins.", "Rules", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource()==newUser){
            blackjackAddUser.setVisible(false);

            blackjackGameMenu.setVisible(true);
            handArray = dealHand(bdeck);
            dHandArray = dealHand(bdeck);
            pHand.setDeck(handArray);
            dHand.setDeck(dHandArray);
            Card p1 = handArray.get(0);
            Card p2 = handArray.get(1);
            playerCard1.setIcon(p1.getImage());
            playerCard2.setIcon(p2.getImage());

        }
        if(e.getSource()==hit){

        }
    }
    public static void addPlayer(){
        String pName;
        int pBal;
        ArrayList<Card> deck = Deck.deckBuilder();
        ArrayList<Card> handArray = new ArrayList<Card>(5);
        ArrayList<Card> dHandArray = new ArrayList<>(5);
        Deck bdeck = new Deck(deck);
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

    }
    public static ArrayList<Card> dealHand(Deck bdeck){
        ArrayList<Card> handArray = new ArrayList<>();
        for(int i=0; i<2; i++){
            handArray.add(i, bdeck.dealCard());

        }
        return handArray;
    }
}
