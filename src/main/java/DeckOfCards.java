// This java file is to create a GUI where also some of the functions in the Kotlin File are used to satisfy the
// objectives of assignment but some are not and are done in a different but close fashion such as the deal one card
// function.

import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeckOfCards {
    private JPanel pan = new JPanel(); // Panel

    public static void main(String[] args)  // Main Function
    {
        final int[] k = {52};   // Number of Cards left in the deck
        Deck_of_Cards deck1 = new Deck_of_Cards();  // A deck of cards using class in kotlin file
        deck1.InitializeDeck(); // Initializing the deck
        ImageIcon image1 = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\shuffle1.png");  // Image of shuffle word
        ImageIcon image2 = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\DealOneCard.png");   // Image of Deal Card word
        ImageIcon image3 = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\display.png");   // Image of Show Order word
        ImageIcon image4 = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\Next.png");  // Image of Next word
        ImageIcon image6 = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\NewDeck.png");   // Image of an empty deck
        JButton button = new JButton("", image1);    // Making button have image 1
        JButton button1 = new JButton("", image2);   // Making button1 have image 2
        JButton button2 = new JButton("", image3);   // Making button2 have image 3
        JButton button3 = new JButton("", image4);   // Making button3 have image 4
        JButton button4 = new JButton("", image6);   // Making button4 have image 6
        button.setSize(200, 30);    // Setting the size of button
        button1.setSize(200, 30);   // Setting the size of button1
        button2.setSize(200, 30);   // Setting the size of button2
        button3.setSize(180, 30);   // Setting the size of button3
        button4.setSize(200, 30);    // Setting the size of button4
        button.setLocation(135, 20);   // Setting the location of button
        button1.setLocation(135, 60);   // Setting the location of button1
        button2.setLocation(135, 100);  // Setting the location of button2
        button3.setLocation(495, 435);  // Setting the location of button3
        button4.setLocation(135, 140);   // Setting the location of button4
        JFrame f = new JFrame("Deck of Cards"); // Creating a new frame
        final ImageIcon[] image = {new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\deck-of-cards.jpg")};    // Initializing the image of the frame
        f.setContentPane(new DeckOfCards().pan);  // Adding the panel
        f.setContentPane(new JLabel(image[0])); // Adding the image
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Make the frame close on the exit button
        f.add(button);  // Adding button
        f.add(button1); // Adding button1
        f.add(button2); // Adding button2
        f.add(button3); // Adding button3
        f.add(button4); // Adding button4
        JTextField text = new JTextField("The Card is Ace Hearts"); // Creating a new textField
        text.setSize(300, 30);   // Setting size of the textField
        text.setLocation(430, 400);  // Setting the location of the textField
        text.setHorizontalAlignment(JTextField.CENTER); // Setting the alignment of the text to center
        text.setEditable(false);    // Setting the textField to be uneditable
        f.add(text);    // Adding the textField to the frame
        final ImageIcon[] image5 = {new ImageIcon()};   // Creating an image for the second frame in case of deal a card
        final int[] a = {0};    // Number of Card
        button4.addActionListener(new ActionListener() {    // Creating an action listener for button4 which makes a new deck
            @Override
            public void actionPerformed(ActionEvent e) {
                deck1.InitializeDeck(); // Initializing the deck
                a[0] = 0; // Bringing a[0] back to 0 so that we are back to the first card
                k[0] = 51;    // Bringing k[0] back to 51 so that we have 51 cards left in the deck
                text.setText("You now have a new deck!");   // Setting the text in textField
            }
        });
        button.addActionListener(new ActionListener() { // Creating an action listener for button which shuffles the deck
            @Override
            public void actionPerformed(ActionEvent e) {
                if (k[0] == 51) {
                    deck1.shuffle();    // Calling the shuffle function from the Kotlin file
                    a[0] = 0;   // Bringing a[0] back to 0 so that we are back to the first card
                    text.setText("The Deck has been shuffled"); // Setting the text in textField
                } else text.setText("Cannot shuffle because deck is not full!");  // Setting the text in textField
            }
        });
        button1.addActionListener(new ActionListener() {    // Creating an Action Listener for button1 which is supposed to deal one card to the user
            @Override
            public void actionPerformed(ActionEvent e) {
                String text12 = "Oops there are no cards left!";    // String to use when there are no more cards to deal
                int i = 0;    // Variable to indicate if there are cards left or not (if 1 no more cards and if 0 there are cards left)
                String suit = deck1.suitName(a[0]);  // Suit of the card
                String faceValue = deck1.FaceValueName(a[0]); // Face Value of the Card
                int b = deck1.NumberofCard(suit, faceValue);   // Number of the card according to its suit and face value
                if (k[0] != 0) {  // If k[0] is not 0 means that we have not dealt all cards then according to 'b' we choose which picture of which card to display
                    if (b == 1) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\AceHearts.png");
                    } else if (b == 2) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\2Hearts.png");
                    } else if (b == 3) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\3Hearts.png");
                    } else if (b == 4) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\4Hearts.png");
                    } else if (b == 5) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\5Hearts.png");
                    } else if (b == 6) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\6Hearts.png");
                    } else if (b == 7) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\7Hearts.png");
                    } else if (b == 8) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\8Hearts.png");
                    } else if (b == 9) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\9Hearts.png");
                    } else if (b == 10) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\10Hearts.png");
                    } else if (b == 11) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\JackHearts.png");
                    } else if (b == 12) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\QueenHearts.png");
                    } else if (b == 13) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\KingHearts.png");
                    } else if (b == 14) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\AceDiamonds.png");
                    } else if (b == 15) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\2Diamonds.png");
                    } else if (b == 16) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\3Diamonds.png");
                    } else if (b == 17) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\4Diamonds.png");
                    } else if (b == 18) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\5Diamonds.png");
                    } else if (b == 19) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\6Diamonds.png");
                    } else if (b == 20) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\7Diamonds.png");
                    } else if (b == 21) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\8Diamonds.png");
                    } else if (b == 22) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\9Diamonds.png");
                    } else if (b == 23) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\10Diamonds.png");
                    } else if (b == 24) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\JackDiamonds.png");
                    } else if (b == 25) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\QueenDiamonds.png");
                    } else if (b == 26) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\KingDiamonds.png");
                    } else if (b == 27) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\AceClubs.png");
                    } else if (b == 28) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\2Clubs.png");
                    } else if (b == 29) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\3Clubs.png");
                    } else if (b == 30) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\4Clubs.png");
                    } else if (b == 31) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\5Clubs.png");
                    } else if (b == 32) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\6Clubs.png");
                    } else if (b == 33) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\7Clubs.png");
                    } else if (b == 34) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\8Clubs.png");
                    } else if (b == 35) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\9Clubs.png");
                    } else if (b == 36) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\10Clubs.png");
                    } else if (b == 37) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\JackClubs.png");
                    } else if (b == 38) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\QueenClubs.png");
                    } else if (b == 39) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\KingClubs.png");
                    } else if (b == 40) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\AceSpades.png");
                    } else if (b == 41) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\2Spades.png");
                    } else if (b == 42) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\3Spades.png");
                    } else if (b == 43) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\4Spades.png");
                    } else if (b == 44) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\5Spades.png");
                    } else if (b == 45) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\6Spades.png");
                    } else if (b == 46) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\7Spades.png");
                    } else if (b == 47) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\8Spades.png");
                    } else if (b == 48) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\9Spades.png");
                    } else if (b == 49) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\10Spades.png");
                    } else if (b == 50) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\JackSpades.png");
                    } else if (b == 51) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\QueenSpades.png");
                    } else if (b == 52) {
                        k[0]--;
                        image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\KingSpades.png");
                    } else image5[0] = new ImageIcon();
                } else {
                    i = 1;
                    image5[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\MyFirstProgram\\.idea\\resources\\EmptyDeck.png");    // Picture of empty deck if no cars left
                }
                if (a[0] == 51)    // Not to exceed range of cards array which is 52
                    a[0] = 0;
                else a[0]++;
                text.setText("The Card is " + faceValue + " " + suit);    // Show the Card selected in the Text Field
                JFrame frame1 = new JFrame("Your Card");    // Creating a new frame for the picture of the new Card
                frame1.setVisible(true);    // Setting the frame visible
                frame1.setSize(250, 310);    // Setting the size of the frame
                JLabel label2;  // Creating a new Jlabel
                if (i == 0)    // Initializing the Jlabel to the appropriate image
                {
                    label2 = new JLabel(image5[0]);
                } else    // If there are no cards left
                {
                    frame1.setSize(400, 400);    // Changing the size of the frame
                    JTextField text123 = new JTextField();  // Creating a new Text Field
                    text123.setSize(300, 30);    // Setting the size of the textField
                    text123.setLocation(40, 300);    // Setting the location of the textField
                    text123.setHorizontalAlignment(JTextField.CENTER);  // Setting the alignment in the textField to be in the center
                    text123.setEditable(false); // Making the textField uneditable
                    frame1.add(text123);    // Adding the textField to the frame
                    text123.setText(text12);    // Setting the variable which indicates no more cards to the textField
                    text.setText("Oops there are no cards left!");  // text in the main textField to also be set to show that no more cards are found
                    label2 = new JLabel(image5[0]); // Setting the image to the Jlabel
                }
                JPanel panel2 = new JPanel();   // Creating a new JPanel
                frame1.add(panel2); // Adding the panel to the frame
                panel2.add(label2); // Adding the label to the panel
                frame1.setLocationRelativeTo(null); // Setting the location of appearance of the new frame to be in the middle of the screen
            }
        });
        button2.addActionListener(new ActionListener() {    // Creating an Action Listener for button2 which is supposed to show the Cards in Order
            @Override
            // It works by showing the first Card in the deck in the Text Field
            public void actionPerformed(ActionEvent e) {
                String suit = deck1.suitName(a[0]); // The suit of the first Card
                String FaceValue = deck1.FaceValueName(a[0]);   // The Face Value of the first Card
                text.setText("The Card is " + FaceValue + " " + suit + " ");    // Setting the text in the Text Field to show the first Card
            }
        });
        button3.addActionListener(new ActionListener() {    // Creating an Action Listener for button3 which is supposed to give the next Card
            @Override
            public void actionPerformed(ActionEvent e) {
                if (a[0] == 51)    // Not to exceed the range of Cards array which is 52
                    a[0] = 0;
                else a[0]++;
                String suit = deck1.suitName(a[0]); //  The suit of the next Card
                String FaceValue = deck1.FaceValueName(a[0]);   // The Face Value of the next Card
                text.setText("The Card is " + FaceValue + " " + suit + " ");    // Setting the text of the Text Field
            }
        });
        f.setSize(980, 514); // Setting the size of the frame to 980,514
        f.setResizable(false);  //  The frame can't be resized
        f.setLocationRelativeTo(null);  // Setting the position of appearance of the frame to be the center of the screen
        f.setVisible(true); // Setting the frame to be visible
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    }
}
