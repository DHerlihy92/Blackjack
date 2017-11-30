import javax.swing.*;

/**
 * Created by T00196758 on 09/11/2017.
 */
public class Card {
    private String name, suit;
    private int value;
    private ImageIcon image;

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public ImageIcon getImage() { return image;   }

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

    public void setImage(ImageIcon image){ this.image = image; }

    public Card(String name, String suit, int value, ImageIcon image){
        setName(name);
        setSuit(suit);
        setValue(value);
        setImage(image);
    }
   //public Card(){this("Unknown", "Unknown", 0, "src//Cards//card0.png"); }

    @Override
    public String toString() {
        return name + " of " + suit + " value=" + value;
    }
}
