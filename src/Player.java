public class Player {
    private String name;
    private Deck hand;

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

    public Player(String name, Deck hand){
        setName(name);
        setHand(hand);

    }
    public Player(){this("Unknown", null);}

}
