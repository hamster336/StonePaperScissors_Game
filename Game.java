import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.util.Random;

public class Game implements ActionListener {
    JFrame frame;
    JTextField screen;

    JButton rock, paper, scissors, submit, next, close;

    Font fnt1 = new Font("SansSerif", Font.BOLD, 22);
    Font fnt2 = new Font("SansSerif", Font.BOLD, 20);

    JPanel panel;

    String userInput;
    String computerChoice;

    public Game() {
        frame = new JFrame();
        frame.setSize(550, 260);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Bidu maja aayega!!");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setBackground(Color.WHITE);          // makes the backfround color white
        // frame.getContentPane().setBackground(new Color(80, 100, 100));   // makes the bg color a blend of thr rgb in given proportion

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        screen = new JTextField();
        screen.setBounds(25, 25, 500, 50);
        screen.setFont(fnt1);
        screen.setEditable(false);
        screen.setHorizontalAlignment(JTextField.CENTER);
        screen.setBorder(border);
        screen.setBackground(Color.LIGHT_GRAY);

        rock = new JButton("ROCK");
        rock.setFont(fnt2);
        rock.setBackground(Color.LIGHT_GRAY);
        rock.setForeground(Color.BLACK);

        paper = new JButton("PAPER");
        paper.setFont(fnt2);
        paper.setBackground(Color.LIGHT_GRAY);
        paper.setForeground(Color.BLACK);

        scissors = new JButton("SCISSORS");
        scissors.setFont(fnt2);
        scissors.setBackground(Color.LIGHT_GRAY);
        scissors.setForeground(Color.BLACK);

        submit = new JButton("SUBMIT");
        submit.setFont(fnt2);
        submit.setBackground(Color.LIGHT_GRAY);
        submit.setForeground(Color.BLACK);

        next = new JButton("NEXT");
        next.setFont(fnt2);
        next.setBackground(Color.LIGHT_GRAY);
        next.setForeground(Color.BLACK);

        close = new JButton("CLOSE");
        close.setFont(fnt2);
        close.setBackground(Color.LIGHT_GRAY);
        close.setForeground(Color.BLACK);

        rock.setBounds(25, 100, 150, 40);
        paper.setBounds(200, 100, 150, 40);
        scissors.setBounds(375, 100, 150, 40);

        submit.setBounds(375, 160, 150, 35);
        next.setBounds(375, 160, 150, 35);

        close.setBounds(25, 160, 150, 40);

        frame.add(rock);
        frame.add(paper);
        frame.add(scissors);
        frame.add(submit);
        frame.add(next);
        frame.add(close);

        frame.add(screen);

        rock.addActionListener(this);
        paper.addActionListener(this);
        scissors.addActionListener(this);

        rock.setEnabled(true);
        paper.setEnabled(true);
        scissors.setEnabled(true);

        submit.addActionListener(this);
        next.addActionListener(this);
        close.addActionListener(this);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static String getChoice() {
        Random ran = new Random();

        String computerChoice[] = { "ROCK", "PAPER", "SCISSORS" };
        int randomNum = ran.nextInt(3);

        return computerChoice[randomNum];
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rock) {
            screen.setText("");
            screen.setText("ROCK");
            userInput = "ROCK";

            String message = "You chose: ";
            screen.setText(message.concat(userInput));

            submit.setBounds(375, 160, 150, 35);
        }

        if (e.getSource() == paper) {
            screen.setText("");
            screen.setText("PAPER");
            userInput = "PAPER";

            String message = "You chose: ";
            screen.setText(message.concat(userInput));

            submit.setBounds(375, 160, 150, 35);
        }

        if (e.getSource() == scissors) {
            screen.setText("");
            screen.setText("SCISSORS");
            userInput = "SCISSORS";

            String message = "You chose: ";
            screen.setText(message.concat(userInput));

            submit.setBounds(375, 160, 150, 35);
        }

        
        if (e.getSource() == submit) {
            rock.setEnabled(false);
            paper.setEnabled(false);
            scissors.setEnabled(false);

            computerChoice = getChoice();
            String message = "Computer chose: ";
            screen.setText(message.concat(computerChoice));

            frame.add(next);
            frame.remove(submit);
        }

        if (e.getSource() == next) {
               if (userInput == computerChoice) {
                screen.setText("");
                screen.setText("It was a tie ^_^");
            } else if ((userInput.equalsIgnoreCase("rock")) && (computerChoice.equalsIgnoreCase("scissors"))
                    || ((userInput.equalsIgnoreCase("scissors")) && (computerChoice.equalsIgnoreCase("paper")))
                    || ((userInput.equalsIgnoreCase("paper")) && (computerChoice.equalsIgnoreCase("rock")))) {
                screen.setText("");
                screen.setText("Congratulations, You won :)");
            } else {
                screen.setText("");
                screen.setText("You Lost :(");
            }
            
            rock.setEnabled(true);
            paper.setEnabled(true);
            scissors.setEnabled(true);

            frame.add(submit);
            frame.remove(next);
        }

        if (e.getSource() == close) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}