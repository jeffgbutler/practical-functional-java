package solutions.basics.streams;

import java.util.ArrayList;
import java.util.List;

public class ReduceExercise {
    
    public String toStringWithForLoop() {
        StringBuilder answer = new StringBuilder();
        boolean first = true;
        for (String string: getListOfStrings()) {
            if (first) {
                first = false;
            } else {
                answer.append(", ");
            }

            answer.append(string);
        }
        
        return answer.toString();
    }

    public String toStringWithStreamAndLambda() {
        // TODO - rewrite the above method using a reduce and a lambda expression
        
        return getListOfStrings().stream()
                .reduce("", (s1, s2) -> s1 + ", " + s2);
//        return null;
    }
    
    public String toStringWithStreamAndMethodReference() {
        // TODO - rewrite the above method using a reduce and a method reference
        
        return getListOfStrings().stream()
                .reduce("", this::concat);
//        return null;
    }
    
    private String concat(String s1, String s2) {
        return s1 + ", " + s2;
    }
    
    private List<String> getListOfStrings() {
        List<String> answer = new ArrayList<>();
        answer.add("Fred");
        answer.add("Wilma");
        answer.add("Barney");
        answer.add("Betty");
        
        return answer;
    }
}
