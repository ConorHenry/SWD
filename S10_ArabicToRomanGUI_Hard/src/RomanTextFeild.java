import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;


/**
 * A custom override textFeild for holding Roman Numeral only,
 * any other input is ignored.
 * @author conorhenry
 */
//referenced from official JTextField documentation
public class RomanTextFeild extends JTextField{
    /**
     * Constuctor which creats textField with a certain number of collumns
     * @param nCols -number of collumns
     */
    public RomanTextFeild(int nCols) {
        super(nCols);
    }

    /**
     * Constuctor which passes objects to JFrame class
     * @param text, text to show
     * @param nCols, number of collunms
     */
    public RomanTextFeild(String text,int nCols) {
        super(text,nCols);
    }

    /**
     * Override method makes Arabic Doc defauld
     * @return new ArabicDoc();
     */
    @Override
    protected Document createDefaultModel() {
        return new ArabicDoc();
    }

    /**
     * static cass ArabicDodc defines a custom doccument subtype which overrides the instertString method with a regex
     * that causes all input except valid roman numeral characters to be ignored as input
     */
    static class ArabicDoc extends PlainDocument {
        /**
         * override method the instertString method with a regex
         * that causes all input except valid roman numeral characters to be ignored as input
         * @param offset:  the offset into the document to insert the content >= 0
         * @param text: the string to insert
         * @param a:  the attributes to associate with the inserted content. This may be null if there are no attributes.
         * @throws BadLocationException if parent call fails with specifed input
         */
        @Override
        public void insertString(int offset, String text, AttributeSet a)
                throws BadLocationException {
            super.insertString(offset, text.replaceAll("[^IVXLCDMivxlcdm]",""), a);//delete all that are not roman Numeral characters
        }
    }
}


