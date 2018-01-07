package solutions.basics.streams;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ReduceTest {

    @Test
    public void testForLoop() {
        ReduceExercise re = new ReduceExercise();
        assertThat(re.toStringWithForLoop()).isEqualTo("Fred, Wilma, Barney, Betty");
    }

    @Test
    public void testStreamWithLambda() {
        ReduceExercise re = new ReduceExercise();
        assertThat(re.toStringWithStreamAndLambda()).isEqualTo(", Fred, Wilma, Barney, Betty");
    }
}
