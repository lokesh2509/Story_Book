import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame extends JFrame{
    static int currPage = 1;

    static StoryFlow s = new StoryFlow();

    static  HomeFrame hf;
    private JPanel HomePanel;
    private JLabel StoryLabel;

    public static Card currentCard;
    public static boolean blueGoo;

    private JButton option1;
    private JButton option2;
    private JButton option3;
    private JButton option4;

    public HomeFrame(){

        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("op1");
                currentCard.options[1].selected();
                System.out.println(currPage);
                HomePanel.repaint();
                LoadPage();
            }
        });
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("op2");
                currentCard.options[2].selected();
                System.out.println(currPage);
                HomePanel.repaint();
                LoadPage();
            }
        });
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("op3");
                currentCard.options[3].selected();
                System.out.println(currPage);
                HomePanel.repaint();
                LoadPage();
            }
        });
        option4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("op4");
                currentCard.options[4].selected();
                System.out.println(currPage);
                HomePanel.repaint();
                LoadPage();
            }
        });
    }
a
    public static void main(String[] args){

        hf = new HomeFrame();
        hf.setContentPane(hf.HomePanel);
        hf.setTitle("Mysterious StoryBoard. ");
        hf.setSize(800, 800);
        hf.setVisible(true);
        hf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setup layout
        updateButtonStyle(hf.option1);
        updateButtonStyle(hf.option2);
        updateButtonStyle(hf.option3);
        updateButtonStyle(hf.option4);

        LoadPage();
    }

    private static void LoadPage() {
        s = new StoryFlow();
        currentCard = s.getCardByPage(currPage);
        hf.StoryLabel.setText(wrapText(currentCard.text));

        if(currentCard.OpLength == 4){
            hf.option4.setText(currentCard.options[4].opText);
        }
        if (currentCard.OpLength < 4 &&  currentCard.OpLength >= 3) {
            hf.option4.setVisible(false);
            hf.option3.setVisible(true);
            hf.option2.setVisible(true);
            hf.option1.setVisible(true);
            hf.option3.setText(currentCard.options[3].opText);
            hf.option2.setText(currentCard.options[2].opText);
            hf.option1.setText(currentCard.options[1].opText);
        }
        if (currentCard.OpLength == 2 ) {
            hf.option4.setVisible(false);
            hf.option3.setVisible(false);
            hf.option2.setVisible(true);
            hf.option1.setVisible(true);
            hf.option2.setText(currentCard.options[2].opText);
            hf.option1.setText(currentCard.options[1].opText);
//            hf.option1.setText("text this");
        }
        if (currentCard.OpLength < 2) {
            hf.option4.setVisible(false);
            hf.option3.setVisible(false);
            hf.option2.setVisible(false);
            System.out.println("op1:"+ currentCard.options[1]);

            hf.option1.setText(currentCard.options[1].opText);
        }
    }

    private static String wrapText(String text) {
        int len = text.length();
        String returnText = text;
        if (len > 65)
            returnText = "<html> <p>"+text.substring(0, 65)+"<br>"+ text.substring(65, len) +"</p> <html>";
        if (len > 120)
            returnText = "<html> <p>"+text.substring(0, 65)+"<br>"+ text.substring(65, 125) + "<br>"+ text.substring(125, len) + "</p> <html>";
        return returnText;
    }

    private static void updateButtonStyle(JButton option) {
        option.setBackground(Color.WHITE);
        option.setFocusPainted(false);
        option.setContentAreaFilled(false);
    }


}
