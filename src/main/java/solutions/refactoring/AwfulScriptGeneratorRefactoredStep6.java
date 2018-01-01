package solutions.refactoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import utilities.Utils;

/**
 * Refinement - function composition
 */
public class AwfulScriptGeneratorRefactoredStep6 implements ScriptGenerator {

    private static Map<Integer, Function<String, String>> columnToApplicationMappings = new HashMap<>();
    
    static {
        columnToApplicationMappings.put(1, getInsertBuilderForApplication(2237));
        columnToApplicationMappings.put(2, getInsertBuilderForApplication(4352));
        columnToApplicationMappings.put(3, getInsertBuilderForApplication(3657));
        columnToApplicationMappings.put(4, getInsertBuilderForApplication(5565));
    };

    private static Function<String, String> getInsertBuilderForApplication(int appId) {
        return userId -> getInsertStatement(userId, appId);
    }
    
    private static String getInsertStatement(String userId, int appId) {
        return "insert into ApplicationPermission(user_id, application_id) values('"
                + userId
                + "', "
                + appId
                + ");";
    }

    @Override
    public List<String> generate(Sheet sheet) {
        return Utils.stream(sheet)
                .filter(this::hasValidUserId)
                .flatMap(this::getInsertStatementsForRow)
                .collect(Collectors.toList());
    }

    private Stream<String> getInsertStatementsForRow(Row row) {
        return getInsertStatementsForRow(row, getUserId(row).get());
    }

    private Stream<String> getInsertStatementsForRow(Row row, String userId) {
        return Utils.stream(row)
                .skip(1)
                .filter(this::hasAuthority)
                .map(c -> getInsertStatementForCell(userId, c));
    }

    private String getInsertStatementForCell(String userId, Cell cell) {
        return columnToApplicationMappings.get(cell.getColumnIndex()).apply(userId);
    }
    
    private Optional<Cell> getFirstCell(Row row) {
        return Optional.ofNullable(row.getCell(0));
    }
    
    private Optional<String> getUserId(Row row) {
        return getFirstCell(row).map(Cell::getStringCellValue);
    }
    
    private boolean hasValidUserId(Row row) {
        return getUserId(row)
                .map(this::isValidUserId)
                .orElse(false);
    }
    
    private boolean hasAuthority(Cell cell) {
        return "X".equals(cell.getStringCellValue());
    }

    private boolean isValidUserId(String value) {
        return ".".equals(value.substring(1, 2));
    }
}
