package org.anagram.generate.util;

import java.util.ArrayList;
import java.util.List;

public class AnagramUtil {

    public static List<String> generateAnagrams(String input) {
        validateInput(input);

        List<String> anagrams = new ArrayList<>();

        // Processa o anagrama, que é recursivo e carregará a lista 'anagrams'
        processAnagram(input, "", anagrams);

        return anagrams;
    }

    private static void processAnagram(String input, String prefix, List<String> anagrams) {
        //Sempre que um anagrama for concluído, adiciono na lista senão processa a próxima letra
        if (input.isEmpty()) {
            anagrams.add(prefix);
        } else {
            for (int i = 0; i < input.length(); i++) {
                // Pega o caracter atual
                char currentChar = input.charAt(i);

                // Cria uma nova string de letras restantes sem o caractere atual
                String remainingChars = input.substring(0, i) + input.substring(i + 1);

                // Chama o método recursivo, agora com o novo prefixo
                processAnagram(remainingChars, prefix + currentChar, anagrams);
            }
        }
    }

    private static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Informe os dados para processamento do anagrama.");
        }

        if (input.length() == 1) {
            throw new IllegalArgumentException("O Texto deve possuir ao menos dois caracteres.");
        }

        if (!input.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("O Texto deve conter apenas letras.");
        }
    }
}
