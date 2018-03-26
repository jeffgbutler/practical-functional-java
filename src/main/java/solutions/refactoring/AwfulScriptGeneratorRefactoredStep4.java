package solutions.refactoring;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import utilities.Utils;

/**
 * Refinement - get rid of the compound if statement
 */
public class AwfulScriptGeneratorRefactoredStep4 implements ScriptGenerator {
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
        Cell firstCell = row.getCell(0);
        return getInsertStatementsForRow(row, firstCell.getStringCellValue());
    }

    private Stream<String> getInsertStatementsForRow(Row row, String userId) {
        return Utils.stream(row)
                .skip(1)
                .filter(this::hasAuthority)
                .map(c -> getInsertStatementForCell(userId, c))
                .filter(Optional::isPresent)
                .map(Optional::get);
    }

    private Optional<String> getInsertStatementForCell(String userId, Cell cell) {
        String answer = null;
        switch (cell.getColumnIndex()) {
        case 1:
            answer = getInsertStatement(userId, 2237);
            break;
        case 2:
            answer = getInsertStatement(userId, 4352);
            break;
        case 3:
            answer = getInsertStatement(userId, 3657);
            break;
        case 4:
            answer = getInsertStatement(userId, 5565);
            break;
        }
        
        return Optional.ofNullable(answer);
    }
    
    private boolean hasValidUserId(Row row) {
        Cell cell = row.getCell(0);
        return cell != null && isValidUserId(cell.getStringCellValue());
    }
    
    private boolean hasAuthority(Cell cell) {
        return "X".equals(cell.getStringCellValue());
    }

    private boolean isValidUserId(String value) {
        return ".".equals(value.substring(1, 2));
    }
}
