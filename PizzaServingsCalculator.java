//Jake Byrne CMPSC 221 Summer 2023

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//C;ass used to calculator pizza servings and display GUI
public class PizzaServingsCalculator extends JFrame {

    // Constructor
    public PizzaServingsCalculator(String name) {
        super(name);
    }

    // Creates and adds each component to the GUI. Also allows for the calculation
    // of pizza servings with the anonymous function
    public void addGUIComponenents(Container pane) {

        // Creation of needed components for the GUI
        JButton pizzaButton = new JButton("Calculate Servings");

        JLabel pTitle = new JLabel("Pizza Servings Calculator", JLabel.CENTER);

        JPanel inputWindow = new JPanel();

        JLabel pCalculation = new JLabel("", JLabel.CENTER);

        JTextField sizeInput = new JTextField(4);

        JPanel pFrame = new JPanel();

        // Sets the grid layout, and colors the text at the top while giving it the
        // desired font
        inputWindow.setLayout(new GridLayout(4, 1));

        pTitle.setFont(new Font("Serif Bold", Font.BOLD, 24));

        pTitle.setForeground(Color.red);

        // Use of anonymous function to calculate pizza slices and displayed it. We were
        // taught this through the videos for week 6(I believe video 4)
        pizzaButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == pizzaButton && !sizeInput.getText().equals("")) {

                    double peopleServings = Math.pow((Double.parseDouble(sizeInput.getText()) / 8), 2);

                    String result = "A " + sizeInput.getText() + " inch pizza will serve "
                            + String.format("%.2f", peopleServings) + " people.";
                    pCalculation.setText(result);

                }
            }
        });

        // GUI elements which are added in a very particular order so that the GUI looks
        // the way it does
        pFrame.add(new JLabel("Enter the size of the pizza in inches: "));
        pFrame.add(sizeInput);

        inputWindow.add(pTitle);

        inputWindow.add(pFrame);

        inputWindow.add(pizzaButton);

        inputWindow.add(pCalculation);

        pane.add(inputWindow);

    }

    // This method does all the work in displaying the gui to the user, and is ran
    // in the main method
    public static void displayGUI() {

        PizzaServingsCalculator pizzaCalc = new PizzaServingsCalculator("Pizza Servings Calculator");

        pizzaCalc.setTitle("Pizza Servings Calculator");

        pizzaCalc.addGUIComponenents(pizzaCalc.getContentPane());

        pizzaCalc.setPreferredSize(new Dimension(350, 300));

        pizzaCalc.setVisible(true);

        pizzaCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pizzaCalc.pack();

        pizzaCalc.setResizable(false);
    }

    public static void main(String[] args) {
        displayGUI();
    }

}
