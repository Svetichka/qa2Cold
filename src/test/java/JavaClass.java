import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class JavaClass{
    private String text;

  @Test
public void firstTest() {
      Integer firstNumber =95;
      Integer secondNumber = 150;
    String text = "Sum is: ";

    sumAndPrint(firstNumber, secondNumber);

    Assertions.assertEquals( 245, firstNumber + secondNumber,"wrong sum");
  }

  private void sumAndPrint(Integer firstNumber, Integer secondNumber) {
      Integer sum = firstNumber + secondNumber;
      System.out.println(text + sum);
  }
}
