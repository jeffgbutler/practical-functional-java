package solutions.refactoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ScriptGeneratorTest {

    private void testGenerator(ScriptGenerator generator) throws IOException {
        try (InputStream is = getClass().getResourceAsStream("/Users.xlsx");
                Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            List<String> lines = generator.generate(sheet);
            assertThat(lines.size()).isEqualTo(44);
            assertThat(lines.get(0)).isEqualTo("insert into ApplicationPermission(user_id, application_id) values('t.wilson', 2237);");
            assertThat(lines.get(15)).isEqualTo("insert into ApplicationPermission(user_id, application_id) values('p.romero', 3657);");
            assertThat(lines.get(22)).isEqualTo("insert into ApplicationPermission(user_id, application_id) values('b.walton', 4352);");
            assertThat(lines.get(43)).isEqualTo("insert into ApplicationPermission(user_id, application_id) values('e.nash', 5565);");
        }
    }
    
    @Test
    public void testAwfulScriptGenerator() throws IOException {
        testGenerator(new AwfulScriptGenerator());
    }

    @Test
    public void testAwfulScriptGeneratorRefactoredStep1() throws IOException {
        testGenerator(new AwfulScriptGeneratorRefactoredStep1());
    }

    @Test
    public void testAwfulScriptGeneratorRefactoredStep2() throws IOException {
        testGenerator(new AwfulScriptGeneratorRefactoredStep2());
    }

    @Test
    public void testAwfulScriptGeneratorRefactoredStep3() throws IOException {
        testGenerator(new AwfulScriptGeneratorRefactoredStep3());
    }

    @Test
    public void testAwfulScriptGeneratorRefactoredStep4() throws IOException {
        testGenerator(new AwfulScriptGeneratorRefactoredStep4());
    }

    @Test
    public void testAwfulScriptGeneratorRefactoredStep5() throws IOException {
        testGenerator(new AwfulScriptGeneratorRefactoredStep5());
    }

    @Test
    public void testAwfulScriptGeneratorRefactoredStep6() throws IOException {
        testGenerator(new AwfulScriptGeneratorRefactoredStep6());
    }
}
