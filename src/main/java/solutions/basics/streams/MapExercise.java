package solutions.basics.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapExercise {
    
    public List<String> toUpperCaseWithForLoop() {
        List<String> answer = new ArrayList<>();
        for (String string: getListOfStrings()) {
            answer.add(string.toUpperCase());
        }
        
        return answer;
    }

    public List<String> toUpperCaseWithStreamAndLambda() {
        // TODO - rewrite the above method using a map and a lambda expression
        
        return getListOfStrings().stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
//        return null;
    }
    
    public List<String> toUpperCaseStreamAndMethodReference() {
        // TODO - rewrite the above method using a map and a method reference
        
        return getListOfStrings().stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
//        return null;
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
