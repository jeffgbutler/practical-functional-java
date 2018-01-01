package solutions.refactoring;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * Traditional refactoring with extracted methods and utility methods 
 */
public class AwfulScriptGeneratorRefactoredStep1 implements ScriptGenerator {
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
            addInsertStatementsForRow(lines, row);
        }

        return lines;
    }

    private void addInsertStatementsForRow(List<String> lines, Row row) {
        Cell firstCell = row.getCell(0);
        if (firstCell != null) {
            String userId = firstCell.getStringCellValue();
            if (isValidUserId(userId)) {
                addInsertStatementsForRow(lines, row, userId);
            }
        }
    }

    private void addInsertStatementsForRow(List<String> lines, Row row, String userId) {
        for (Cell cell : row) {
            if (cell.getColumnIndex() == 0) {
                continue;
            }

            if (hasAuthority(cell)) {
                addInsertStatementForCell(lines, userId, cell);
            }
        }
    }

    private void addInsertStatementForCell(List<String> lines, String userId, Cell cell) {
        switch (cell.getColumnIndex()) {
        case 1:
            lines.add(getInsertStatement(userId, 2237));
            break;
        case 2:
            lines.add(getInsertStatement(userId, 4352));
            break;
        case 3:
            lines.add(getInsertStatement(userId, 3657));
            break;
        case 4:
            lines.add(getInsertStatement(userId, 5565));
            break;
        }
    }
    
    private boolean hasAuthority(Cell cell) {
        return "X".equals(cell.getStringCellValue());
    }

    private boolean isValidUserId(String value) {
        return ".".equals(value.substring(1, 2));
    }
}
