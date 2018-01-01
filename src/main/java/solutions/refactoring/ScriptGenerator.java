package solutions.refactoring;

import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;

public interface ScriptGenerator {
    List<String> generate(Sheet sheet);
}
