package solutions.refactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * Pure functions:
 * 
 * 1. addXXX methods changed to getXXX
 * 2. we no longer pass a List around
 */
public class AwfulScriptGeneratorRefactoredStep2 implements ScriptGenerator {
    private static String getInsertStatement(String userId, int appId) {
        return "insert into ApplicationPermission(user_id, application_id) values('"
                + userId
                + "', "
                + appId
                + ");";
    }

    @Override
    public List<String> generate(Sheet sheet) {
        List<String> lines = new ArrayList<>();
        for (Row row : sheet) {
            lines.addAll(getInsertStatementsForRow(row));
        }

        return lines;
    }

    private List<String> getInsertStatementsForRow(Row row) {
        List<String> lines = new ArrayList<>();
        Cell firstCell = row.getCell(0);
        if (firstCell != null) {
            String userId = firstCell.getStringCellValue();
            if (isValidUserId(userId)) {
                lines.addAll(getInsertStatementsForRow(row, userId));
            }
        }
        return lines;
    }

    private List<String> getInsertStatementsForRow(Row row, String userId) {
        List<String> lines = new ArrayList<>();
        for (Cell cell : row) {
            if (cell.getColumnIndex() == 0) {
                continue;
            }

            if (hasAuthority(cell)) {
                getInsertStatementForCell(userId, cell).ifPresent(st -> lines.add(st));
            }
        }
        return lines;
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
    
    private boolean hasAuthority(Cell cell) {
        return "X".equals(cell.getStringCellValue());
    }

    private boolean isValidUserId(String value) {
        return ".".equals(value.substring(1, 2));
    }
}
