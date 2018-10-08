import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 public class HomeWork1 {
    //private String text;

    @Test
    public void finalAmountOfPaymentOnACredit() {
        int  credit = 40000;
        double lumpSumOfPayments = 0;
        double[] percentArray = {0.1, 0.08, 0.06};
        String text = "Lump sum of payments is: ";
        for (int i = 0; i < percentArray.length; i++) {
            lumpSumOfPayments = lumpSumOfPayments + credit * percentArray[i];
        }
        System.out.println(text + lumpSumOfPayments);
        Assertions.assertEquals( 9600, lumpSumOfPayments ,"wrong sum");

    }
 }
