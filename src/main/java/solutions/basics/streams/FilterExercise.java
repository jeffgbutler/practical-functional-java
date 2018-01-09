package solutions.basics.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExercise {
    
    public List<String> notFredWithForLoop() {
        List<String> answer = new ArrayList<>();
        for (String string: getListOfStrings()) {
            if (string.equals("Fred")) {
                continue;
            }
            
            answer.add(string);
        }
        
        return answer;
    }

    public List<String> notFredWithStreamAndLambda() {
        // TODO - rewrite the above method using a filter and a lambda expression
        
        return getListOfStrings().stream()
                .filter(s -> !s.equals("Fred"))
                .collect(Collectors.toList());
//        return null;
    }
    
    public List<String> notFredWithStreamAndMethodReference() {
        // TODO - rewrite the above method using a filter and a method reference
        
        return getListOfStrings().stream()
                .filter(this::notFred)
                .collect(Collectors.toList());
//        return null;
    }
    
    private boolean notFred(String s) {
        return !s.equals("Fred");
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
