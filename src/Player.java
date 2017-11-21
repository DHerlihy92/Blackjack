import java.util.ArrayList;

public class Player {
    private String name;
    private Deck hand;
    private int balance;

    public int getBalance() { return balance; }

    public Deck getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public void setHand(Deck hand) {
        this.hand = hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) { this.balance = balance; }

    public Player(String name, Deck hand, int balance){
        setName(name);
        setHand(hand);
        setBalance(balance);

    }
    public Player(){this("Unknown", null, 0);}

    public int calcHandValue(){
        int total=0;
        ArrayList<Card> totaller = hand.getDeck();
        Card test = new Card();
        for(int i=0; i<totaller.size(); i++){
            test=totaller.get(i);
            total+=test.getValue();
        }
        return total;
    }

    public int removeBet(int bet){
        balance-=bet;

        return balance;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                ", balance=" + balance +
                '}';
    }
}
