// Fig. 12.47: TextAreaFrame.java
// Copying selected text from one textarea to another.

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Frame class holds the text feild objects, sets them to a layout, and implements an action listener for a button
 * which implements the logic found in Converter.java
 * @author conorhenry
 */
public class Frame extends JFrame {

    /**
     * Text feild where only roman numerals can be input
     */
    private final RomanTextFeild romanTextField;

    /**
     * JLable to show in GUI window
     */
    private final JLabel fieldLabel;

    /**
     * Text feild where only arabic numerals can be input
     * (useful if later implementing reverse logic)
     */
    private final ArabicTextFeild arabicTextField;
    /**
     * Button user presses to convert their input
     */
    private final JButton convertButton;

    private void initFrame(){

    }
    /**
     * no-arg constructor which adds gui elements to window,
     * displays them, get's input, listens for action on the
     * convert button, then carries out the conversion logic
     * using a new Converter object instance
     */
    // no-argument constructor
    public Frame() {
        super("Roman-Arabic Numeral Converter");
        Box box = Box.createVerticalBox(); // create box
        romanTextField = new RomanTextFeild( 10);
        box.add(new JScrollPane(romanTextField)); // add scrollpane
        fieldLabel=new JLabel("⬆Roman⬆ ⬇Arabic⬇");
        box.add(fieldLabel);
        arabicTextField = new ArabicTextFeild(10);
        box.add(new JScrollPane(arabicTextField)); // add scrollpane
        convertButton = new JButton("Convert Entry");
        box.add(convertButton); // add copy button to box
        romanTextField.addActionListener(
                new ActionListener() // anonymous inner class
                {
                    /**
                     * Override method implements custom behaivor of action listener.
                     * @param event
                     */
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Converter newConversion= new Converter();
                        if(!romanTextField.getText().isEmpty()) {
                            newConversion.setRomanNumeral(romanTextField.getText());
                            arabicTextField.setText(newConversion.computerArab());
                        }
                    }
                } // end anonymous inner class
        ); // end call to addActionListener

        arabicTextField.addActionListener(
                new ActionListener() // anonymous inner class
                {
                    /**
                     * Override method implements custom behavior of action listener.
                     * @param event
                     */
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Converter newConversion= new Converter();
                        if(!arabicTextField.getText().isEmpty()) {
                            newConversion.setArabicVal(new Integer(arabicTextField.getText()));
                            romanTextField.setText(newConversion.computeRoman());
                        }
                    }
                } // end anonymous inner class
        );

        add(box); // add box to frame
    } // end TextAreaFrame constructor
} // end class TextAreaFrame


