import javax.swing.*;

public class BlackJackDriver {
    public static void main(String[] args) {
        Card[] deck = new Card[52];
        int[] values = {2,3,4,5,6,7,8,9,10,10,10,10,11};
        String[] names = {"two","three","four","five","six","seven","eight","nine","ten","jack","queen","king","ace"};
        int y=0, count=0;

        for(int i=0;i<=51;i++){

            deck[i]=new Card();

            if(count<13){
                deck[i].setSuit("Hearts");
                deck[i].setValue(values[y]);
                deck[i].setName(names[y]);
            }
            if(count>=13 && count<26){
                deck[i].setSuit("Diamonds");
                deck[i].setValue(values[y]);
                deck[i].setName(names[y]);
            }
            if(count>=26 && count<39){
                deck[i].setSuit("Clubs");
                deck[i].setValue(values[y]);
                deck[i].setName(names[y]);
            }
            if(count>=39 && count<51){
                deck[i].setSuit("Spades");
                deck[i].setValue(values[y]);
                deck[i].setName(names[y]);
            }
            count++;
            y++;
            if(count==12 || count==25 || count==38){
                y=0;
            }


        }
        Deck bdeck = new Deck(deck);
        bdeck.display();
    }
}
