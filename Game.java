/*
 * import all libraries and packets needed
 */
package javaapplication1;

import java.util.Scanner;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Eyad
 */
public class Game {

    //Method : Element
    //Function : User chooses element and is later used to deicde winner
    public static String Element() {

        boolean correct_input = false;
        String userElement = null;
        while (!correct_input) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose: Fire, Water, Earth, Lightening, Wind.");
            userElement = scan.next();
            System.out.println("Your element is:" + " " + userElement);

            if ((!userElement.equalsIgnoreCase("Fire")) && (!userElement.equalsIgnoreCase("Water")) && (!userElement.equalsIgnoreCase("Earth")) && (!userElement.equalsIgnoreCase("Wind")) && (!userElement.equalsIgnoreCase("Lightening"))) {
                System.out.print("Please pick one of the given elements");
            } else {
                correct_input = true;
            }
        }

        return userElement;
    }

    //Method : Computer
    //Function : Decides element for computer
    public static String Computer() {
        double computerTurn = Math.random();
        String computerElement = "";

        if (computerTurn <= 0.2) {
            computerElement = "Fire";
        } else if ((computerTurn >= 0.21) && (computerTurn <= 0.4)) {
            computerElement = "Water";
        } else if ((computerTurn >= 0.41) && (computerTurn <= 0.6)) {
            computerElement = "Earth";
        } else if ((computerTurn >= 0.61) && (computerTurn <= 0.8)) {
            computerElement = "Lightening";
        } else if ((computerTurn >= 0.81) && (computerTurn <= 1.0)) {
            computerElement = "Wind";
        } else {
            computerElement = "Fire";
        }

        System.out.println("The computer chose: " + computerElement);
        return computerElement;
    }

    //Method : Result
    //Function : Takes user and computer element and decides winner
    public static void Result(String userElem, String compElem) {
        switch (compElem) {
            case "Fire":
                if (userElem.equalsIgnoreCase("Water")) {
                    System.out.print("You Win!");

                } else if (userElem.equalsIgnoreCase("Wind")) {
                    System.out.print("You Lose!");
                } else {
                    System.out.print("Its a Draw!");
                }
                break;
            case "Water":
                if (userElem.equalsIgnoreCase("Earth")) {
                    System.out.print("You Win!");

                } else if (userElem.equalsIgnoreCase("Fire")) {
                    System.out.print("You Lose!");
                } else {
                    System.out.print("Its a Draw!");
                }
                break;
            case "Earth":
                if (userElem.equalsIgnoreCase("Lightening")) {
                    System.out.print("You Win!");

                } else if (userElem.equalsIgnoreCase("Water")) {
                    System.out.print("You Lose!");
                } else {
                    System.out.print("Its a Draw!");
                }
                break;
            case "Lightening":
                if (userElem.equalsIgnoreCase("Wind")) {
                    System.out.print("You Win!");

                } else if (userElem.equalsIgnoreCase("Earth")) {
                    System.out.print("You Lose!");
                } else {
                    System.out.print("Its a Draw!");
                }
                break;
            case "Wind":
                if (userElem.equalsIgnoreCase("Fire")) {
                    System.out.print("You Win!");

                } else if (userElem.equalsIgnoreCase("Lightening")) {
                    System.out.print("You Lose!");
                } else {
                    System.out.print("Its a Draw!");
                }
                break;
            default:
                System.out.print("WTF, wat did u dooo????");
                break;
        }
    }

    //Method : ShowPicture
    //Function : Shows pictures based on the element parameters
    public static void ShowPicture(String userElement, String compElement) throws IOException {
        BufferedImage user_img = null;
        BufferedImage comp_img = null;
        if (userElement.equalsIgnoreCase("Fire")) {
            user_img = ImageIO.read(new File("fire.png"));
        } else if (userElement.equalsIgnoreCase("Water")) {
            user_img = ImageIO.read(new File("water.png"));
        } else if (userElement.equalsIgnoreCase("Earth")) {
            user_img = ImageIO.read(new File("earth.png"));
        } else if (userElement.equalsIgnoreCase("Wind")) {
            user_img = ImageIO.read(new File("wind.png"));
        } else if (userElement.equalsIgnoreCase("Lightening")) {
            user_img = ImageIO.read(new File("lightening.png"));
        } else {
            System.out.print("You done goofed");
        }

        if (compElement.equalsIgnoreCase("Fire")) {
            comp_img = ImageIO.read(new File("fire.png"));
        } else if (compElement.equalsIgnoreCase("Water")) {
            comp_img = ImageIO.read(new File("water.png"));
        } else if (compElement.equalsIgnoreCase("Earth")) {
            comp_img = ImageIO.read(new File("earth.png"));
        } else if (compElement.equalsIgnoreCase("Wind")) {
            comp_img = ImageIO.read(new File("wind.png"));
        } else if (compElement.equalsIgnoreCase("Lightening")) {
            comp_img = ImageIO.read(new File("lightening.png"));
        } else {
            System.out.print("You done goofed");
        }

        JFrame frame = new JFrame("Battle");
        JPanel panel = new JPanel();
        ImageIcon user_icon = new ImageIcon(user_img);
        ImageIcon comp_icon = new ImageIcon(comp_img);
        JLabel text1 = new JLabel("Player", JLabel.CENTER);
        text1.setIcon(user_icon);
        text1.setHorizontalTextPosition(JLabel.CENTER);
        text1.setVerticalTextPosition(JLabel.TOP);
        JLabel text2 = new JLabel("Computer", JLabel.CENTER);
        text2.setIcon(comp_icon);
        text2.setHorizontalTextPosition(JLabel.CENTER);
        text2.setVerticalTextPosition(JLabel.TOP);

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(text1);
        panel.add(text2);
        panel.add(Box.createGlue()); //creates space between the JLabels

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        String userCont;

        Scanner scan = new Scanner(System.in);

        while (true) {
            String userElem = Element();
            String compElem = Computer();
            ShowPicture(userElem, compElem);
            Result(userElem, compElem);

            System.out.println("\n Quit or Continue?");
            userCont = scan.next();
            if (userCont.equalsIgnoreCase("Quit")) {
                System.exit(0);
            }

        }

    }
}
