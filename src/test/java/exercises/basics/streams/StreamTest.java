package exercises.basics.streams;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class StreamTest {

    @Test
    public void testToUpperCase() {
        
        StreamExercises se = new StreamExercises();
        
        List<String> uppers = se.toUpperCase(Arrays.asList("Fred", "Wilma", "Betty", "Barney"));
        
        assertThat(uppers).containsExactly("FRED", "WILMA", "BETTY", "BARNEY");
    }

    @Test
    public void testOrderSummary() {
        StreamExercises se = new StreamExercises();
        
        String answer = se.calculateOrderSummary(Arrays.asList(getOrder1(), getOrder2()));
        
        String expected = "Fred ordered 3 Baseball Bat and 1 Catcher's Glove\n"
                + "Barney ordered 2 Baseball Bat and 1 Pitcher's Glove";
        
        assertThat(answer).isEqualTo(expected);
    }
    
    @Test
    public void testCalculateTotalOrdered() {
        StreamExercises se = new StreamExercises();
        
        int answer = se.calculateTotalOrdered(Arrays.asList(getOrder1(), getOrder2()), "Baseball Bat");
        
        assertThat(answer).isEqualTo(5);
    }
    
    private Order getOrder1() {
        Product p1 = new Product.Builder()
                .withProductName("Baseball Bat")
                .withQuantity(3)
                .build();
        
        Product p2 = new Product.Builder()
                .withProductName("Catcher's Glove")
                .withQuantity(1)
                .build();
        
        return new Order.Builder()
                .withCustomerName("Fred")
                .withProduct(p1)
                .withProduct(p2)
                .build();
    }

    private Order getOrder2() {
        Product p1 = new Product.Builder()
                .withProductName("Baseball Bat")
                .withQuantity(2)
                .build();
        
        Product p2 = new Product.Builder()
                .withProductName("Pitcher's Glove")
                .withQuantity(1)
                .build();
        
        return new Order.Builder()
                .withCustomerName("Barney")
                .withProduct(p1)
                .withProduct(p2)
                .build();
    }
}
