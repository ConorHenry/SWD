import java.util.Scanner;

/**
 * Converter class implements the interface for receiving user input in the form of a dollar amount below $1000
 * and converting the number to natural language
 * @author conorhenry
 */
public class Converter {
    /**
     * The integer part of the number which is to be converted
     */
    private Integer number;
    /**
     * The decimal part of the number that is to be converted, as a string
     */
    private String decimal;
    /**
     * StringBuilder object for returning the result
     */
    private StringBuilder result;
    /**
     * Constant array of strings representing the names of single digit numbers
     */
    private static final String[] DIGITS={"","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
    /**
     * Constant array of strings representing the names of decades from 20 to 90
     */
    private static final String[] DECADES={"TWENTY","THIRTY","FORTY","FIFTY","SIXTY","SEVENTY","EIGHTY","NINETY"};
    /**
     * Constant array of strings representing the names of number between 10 and 19
     */
    private static final String[] IRREGULARS={"TEN","ELEVEN","TWELVE","THIRTEEN","FOURTEEN","FIFTEEN","SIXTEEN","SEVENTEEN","EIGHTEEN","NINETEEN"};

    /**
     * Constructor for converter class. Takes input from the user to get the number to be converted, and parses it into
     * integer and decimal sections.
     */
    public Converter(){
        result=new StringBuilder();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter an amount less than $1000 (ex: 1.25, 12.00, 999.99, 0.25)");
        while(!input.hasNext("\\d{1,3}\\.\\d{2}")) {//regex for number strings in the format 1.00,11.00,573.95, etc.
            System.out.println("Invalid input, try again");
            input.next();
        }
        String[] splitForm=input.next("\\d{1,3}\\.\\d{2}").split("\\.");
        number=Integer.parseInt(splitForm[0]);
        decimal=splitForm[1];
    }


    /**
     * Convert method takes the number provided by user and returns a string representing the
     * specified number in the form (ex) " ONE hundred TWELVE and 34/100 "
     * @return a string representing the specified number in the form (ex) " ONE hundred TWELVE and 34/100 "
     */
    public String convert(){
        boolean done=false;
        int count=0;
        while(!done){
            switch (number.toString().length()) {//switch on the number of digits in the number
                //Starting with the most significant digit, build that digit's part of the string, then delete that
                //digit and loop
                case 1:
                    result.append(DIGITS[number]);
                    done=true;
                    break;
                case 2:
                    if(number<20) {
                        result.append(IRREGULARS[number-10]);
                        done=true;
                    }
                    else{
                        result.append(DECADES[number/10-2]).append("-");
                        number-=number/10*10;
                    }
                    break;
                case 3:
                    result.append(DIGITS[number/100]).append(" hundred ");
                    number-=number/100*100;
                    break;
            } count++;
        }

        if(number==0&&count==1){
            return decimal+"¢ ("+decimal+"/100)";
        }
        return result+" and "+decimal+"/100";
    }

}
