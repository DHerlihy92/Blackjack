/**
 * Created by T00196758 on 09/11/2017.
 */
public class Card {
    private String name, suit;
    private int value;

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Card(String name, String suit, int value){
        setName(name);
        setSuit(suit);
        setValue(value);
    }
    public Card(){this("Unknown", "Unknown", 0); }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", suit='" + suit + '\'' +
                ", value=" + value +
                '}';
    }
}
