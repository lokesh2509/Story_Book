public class Card {
    String text;
    Option options[];
    int OpLength;
    Card(String text, Option options[] ){
        this.text = text;
        this.options = options;
        OpLength = options.length - 1;
    }

}


