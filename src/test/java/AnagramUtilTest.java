import org.anagram.generate.util.AnagramUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class AnagramUtilTest {

    @Test
    void shouldGenerateCorrectAnagrams() {
        String input = "abc";

        List<String> anagrams = AnagramUtil.generateAnagrams(input);

        assertNotNull(anagrams);
        assertEquals(6, anagrams.size());
        assertTrue(anagrams.contains("abc"));
        assertTrue(anagrams.contains("acb"));
        assertTrue(anagrams.contains("bac"));
        assertTrue(anagrams.contains("bca"));
        assertTrue(anagrams.contains("cab"));
        assertTrue(anagrams.contains("cba"));
    }

    @Test
    void shouldThrowExceptionForEmptyOrNullInput() {
        IllegalArgumentException exceptionEmptyEntry = assertThrows(IllegalArgumentException.class, () -> {
            AnagramUtil.generateAnagrams("");
        });
        assertEquals("Informe os dados para processamento do anagrama.", exceptionEmptyEntry.getMessage());

        IllegalArgumentException exceptionNullEntry = assertThrows(IllegalArgumentException.class, () -> {
            AnagramUtil.generateAnagrams(null);
        });
        assertEquals("Informe os dados para processamento do anagrama.", exceptionNullEntry.getMessage());
    }

    @Test
    void shouldThrowExceptionForInvalidCharacters() {
        String input1 = "abc123";
        String input2 = "a b";
        String input3 = "a!c";
        String input4 = "321";
        String input5 = "a";

        assertThrows(IllegalArgumentException.class, () -> AnagramUtil.generateAnagrams(input1));
        assertThrows(IllegalArgumentException.class, () -> AnagramUtil.generateAnagrams(input2));
        assertThrows(IllegalArgumentException.class, () -> AnagramUtil.generateAnagrams(input3));
        assertThrows(IllegalArgumentException.class, () -> AnagramUtil.generateAnagrams(input4));
        assertThrows(IllegalArgumentException.class, () -> AnagramUtil.generateAnagrams(input5));
    }
}
