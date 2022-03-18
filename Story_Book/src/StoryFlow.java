public class StoryFlow {

    Card[] cards = new Card[12];

    Option[] options;

    //    states of items.

    static boolean sword = false;
    static boolean shield = false;

    StoryFlow(){
//      1
        options = new Option[3];
        options[1] = new Option("Take the goo", 2, true);
        options[2] = new Option("Do not take the goo", 2, false);
        cards[1] = new Card(
                "You wake up in a strange place and you see a jar of blue goo near you.",
                options
        );

//      2
        options = new Option[2];
        System.out.println("BLUE STATE: " + HomeFrame.blueGoo);
        if(HomeFrame.blueGoo){
            System.out.println("HAVE BLUE GOO");
            options = new Option[4];
            options[1] = new Option("Trade the goo for a sword", 3, true, true);
            options[2] = new Option("Trade the goo for a shield", 3, true, false, true);
            options[3] = new Option("Ignore the merchant", 3);
        } else {
            options[1] = new Option("Ignore the merchant", 3);
        }
        cards[2] = new Card(
                "You venture forth in search of answers to where you are when you come across a merchant.",
                options
        );

//      3
        options = new Option[4];
        options[1] = new Option("Explore the castle", 4);
        options[2] = new Option("Find a room to sleep at in the town", 5);
        options[3] = new Option("Find some hay in a stable to sleep in", 6);
        cards[3] = new Card(
                "After leaving the merchant you start to feel tired and stumble upon a small town next to a dangerous looking castle.",
                options
        );

//      4
        options = new Option[3];
        options[1] = new Option("RESTART \uD83D\uDC80", 1, false, false, false);
        options[2] = new Option("RESTART \uD83D\uDC80\"", 1, false, false, false);
        cards[4] = new Card(
                "You are so tired that you fall asleep while exploring the castle and are killed by some terrible monster in your sleep.",
                options
        );

//      5
        options = new Option[2];
        options[1] = new Option("BUSTED \uD83D\uDE16", 1, false, false, false, true);
        cards[5] = new Card(
                "Without any money to buy a room you break into the nearest inn and fall asleep. After a few hours of sleep the owner of the inn finds you and has the town guard lock you in a cell.",
                options
        );
//      6
        options = new Option[2];
        options[1] = new Option("Explore the castle'", 7);
        cards[6] = new Card(
                "You wake up well rested and full of energy ready to explore the nearby castle.",
                options
        );

//      7
        options = new Option[2];

        options[1] = new Option("Try to run", 8);

        if (HomeFrame.blueGoo || sword || shield){
            System.out.println("7"+ HomeFrame.blueGoo);
            options = new Option[3];
            options[1] = new Option("Try to run", 8);
            if (sword)
                options[2] = new Option("Attack it with your sword", 9);
            if (shield)
                options[2] = new Option("Hide behind your shield", 10);
            if (HomeFrame.blueGoo)
                options[2] = new Option("Throw the blue goo at it", 11);
        }

        cards[7] = new Card(
                "While exploring the castle you come across a horrible monster in your path.",
                options
        );

//      8
        options = new Option[2];

        options[1] = new Option("RESTART \uD83E\uDD7A", 1, false, false, false, true);
        cards[8] = new Card(
                "Your attempts to run are in vain and the monster easily catches.",
                options
        );

//      9
        options = new Option[2];

        options[1] = new Option("RESTART \uD83E\uDD7A", 1, false, false, false, true);
        cards[9] = new Card(
                "You foolishly thought this monster could be slain with a single sword.",
                options
        );

//      10
        options = new Option[3];

        options[1] = new Option("RESTART \uD83D\uDC79", 1, false, false, false, true);
        options[2] = new Option("RESTART \uD83D\uDC79", 1, false, false, false, true);

        cards[10] = new Card(
                "The Monster \uD83D\uDC79 laughed as you hid behind your shield and ate \uD83E\uDD24 you",
                options
        );

//      11
        options = new Option[3];

        options[1] = new Option("CONGRATULATIONS, PLAY AGAIN \uD83C\uDF89", 1, false, false, false, true);
        options[2] = new Option("CONGRATULATIONS, PLAY AGAIN \uD83C\uDF89", 1, false, false, false, true);

        cards[11] = new Card(
                "You threw your jar of goo at the monster and it exploded. After the dust settled you saw the monster was destroyed. Seeing your victory you decide to claim this castle as your and live out the rest of your days there.",
                options
        );


    }

    public Card[] getCards() {
        return cards;
    }

    public Card getCardByPage(int page){
        return cards[page];
    }


}
