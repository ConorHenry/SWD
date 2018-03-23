/**
 * Class Converter implements a program for converting Roman numerals to arabic numerals and contains methods
 * and feilds that would make it simpler to be extended behaivor to handel reverse computations as well
 * @author conorhenry
 */
public class Converter {

    /**
     * value as an Integer object
     */
    private Integer arabicVal;

    /**
     * Roman numeral string
     */
    private String romanNumeral;

    /**
     * Constant array of roman numeral character values
     */
    public static final int[] romanValues={1000,500,100,50,10,5,1};

    /**
     * Constant array of roman numeral characters in same order as values
     */
    public static final String[] romanSymbols={"M","D","C","L","X","V","I"};

    public String computeRoman() {
        StringBuilder stringBuilder=new StringBuilder();
        int half=5000;
        int whole=1000;
        for(int i=0;i<5;i+=2) {
            if (arabicVal>=half) {
                stringBuilder.append(romanSymbols[i-1]);
                arabicVal-=half;
            }
            while(arabicVal>=whole) {
                stringBuilder.append(romanSymbols[i]);
            }
            half = romanValues[i+1];
            whole = romanValues[i];
        }
        for(int i=2,index=0;i<5;i+=2){
            int found;
            do {
                found=stringBuilder.indexOf(romanSymbols[i]+romanSymbols[i]+romanSymbols[i]+romanSymbols[i],index);
                if(found>=0){
                    stringBuilder.replace(found,found+4,romanSymbols[i]+romanSymbols[i-1]);
                }
            }while(found>0);
        }
        return stringBuilder.toString();
    }

        /**
         * method to convert roman numerals to arabic, called by Frame class
         * @return the value of the roman numeral, or a long sting of 000 in
         * the case of illegal input(which should be impossible)
         */
    public String computerArab() {
        try {
            char[] toConvert = romanNumeral.toCharArray();
            int total = 0;
            int cur = getVal(toConvert[0]);
            int next = 0;
            if (romanNumeral.length() == 1) {
                this.arabicVal = cur;
                return "" + cur;
            }
            for (int i = 1; i < toConvert.length; i++) {
                next = getVal(toConvert[i]);

                if (cur < next) {
                    total -= cur;
                } else {
                    total += cur;
                }
                cur = next;
                next = getVal(toConvert[i]);
            }
            total += next;
            this.arabicVal = total;
            return "" + arabicVal;
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: Invalid input");
            return "000000000000000";
        }
    }

    /**
     * setter for arabic private field
     * @param arabicVal new value to set
     */
    public void setArabicVal(int arabicVal) {

        this.arabicVal = arabicVal;
    }

    /**
     * Setter for roman private field
     */
    public void setRomanNumeral(String romanNumeral) {
        this.romanNumeral = romanNumeral;
    }

    /**
     * Static method which converts a roman numeral character to it's corresponding value
     */
    private static int getVal(char c){
        switch(Character.toUpperCase(c)){
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
            default: throw new IllegalArgumentException();
        }
    }
}
