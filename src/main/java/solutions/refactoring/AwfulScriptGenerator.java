package solutions.refactoring;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class AwfulScriptGenerator implements ScriptGenerator {
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
            Cell firstCell = row.getCell(0);
            if (firstCell != null) {
                String userId = firstCell.getStringCellValue();
                if (".".equals(userId.substring(1, 2))) {
                    for (Cell cell : row) {
                        if (cell.getColumnIndex() == 0) {
                            continue;
                        }

                        if ("X".equals(cell.getStringCellValue())) {
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
                    }
                }
            }
        }

        return lines;
    }
}
