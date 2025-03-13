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

    /*
    ---------------------------------- PARA EFEITO DO TESTE ---------------------------------------------------
     Explicação do processamento:
     Este método gera anagramas de forma recursiva e adiciona na lista passado por parêmetro.
     Primeiro, ele percorre cada letra da palavra, pega uma letra por vez e coloca no comeco como sendo o prefixo.
     Depois, remove essa letra do restante da palavra e chama o próprio método novamente, agora com a palavra reduzida e
     com o novo prefixo. Isso continua acontecendo até que não sobrem mais letras para reorganizar.
     Quando isso acontece, significa que uma nova combinação foi formada e é adicionada à lista de anagramas.
     Esse processo se repete para todas as letras, garantindo que todas as combinações possíveis sejam criadas.
     */
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
