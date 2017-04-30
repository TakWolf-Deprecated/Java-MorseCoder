package com.takwolf.morsecoder;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public final class MorseCoder {

    private static final Map<Integer, String> alphabets = new HashMap<>();
    private static final Map<String, Integer> dictionaries = new HashMap<>();

    private static void registeMorse(Character abc, String dict) {
        alphabets.put(Integer.valueOf(abc), dict);
        dictionaries.put(dict, Integer.valueOf(abc));
    }

    static {
        // Letters
        registeMorse('A', "01");      // A
        registeMorse('B', "1000");    // B
        registeMorse('C', "1010");    // C
        registeMorse('D', "100");     // D
        registeMorse('E', "0");       // E
        registeMorse('F', "0010");    // F
        registeMorse('G', "110");     // G
        registeMorse('H', "0000");    // H
        registeMorse('I', "00");      // I
        registeMorse('J', "0111");    // J
        registeMorse('K', "101");     // K
        registeMorse('L', "0100");    // L
        registeMorse('M', "11");      // M
        registeMorse('N', "10");      // N
        registeMorse('O', "111");     // O
        registeMorse('P', "0110");    // P
        registeMorse('Q', "1101");    // Q
        registeMorse('R', "010");     // R
        registeMorse('S', "000");     // S
        registeMorse('T', "1");       // T
        registeMorse('U', "001");     // U
        registeMorse('V', "0001");    // V
        registeMorse('W', "011");     // W
        registeMorse('X', "1001");    // X
        registeMorse('Y', "1011");    // Y
        registeMorse('Z', "1100");    // Z
        // Numbers
        registeMorse('0', "11111");   // 0
        registeMorse('1', "01111");   // 1
        registeMorse('2', "00111");   // 2
        registeMorse('3', "00011");   // 3
        registeMorse('4', "00001");   // 4
        registeMorse('5', "00000");   // 5
        registeMorse('6', "10000");   // 6
        registeMorse('7', "11000");   // 7
        registeMorse('8', "11100");   // 8
        registeMorse('9', "11110");   // 9
        // Punctuation
        registeMorse('.', "010101");  // Full stop
        registeMorse(',', "110011");  // Comma
        registeMorse('?', "001100");  // Question mark
        registeMorse('\'', "011110"); // Apostrophe
        registeMorse('!', "101011");  // Exclamation mark
        registeMorse('/', "10010");   // Slash
        registeMorse('(', "10110");   // Left parenthesis
        registeMorse(')', "101101");  // Right parenthesis
        registeMorse('&', "01000");   // Ampersand
        registeMorse(':', "111000");  // Colon
        registeMorse(';', "101010");  // Semicolon
        registeMorse('=', "10001");   // Equal sign
        registeMorse('+', "01010");   // Plus sign
        registeMorse('-', "100001");  // Hyphen1minus
        registeMorse('_', "001101");  // Low line
        registeMorse('"', "010010");  // Quotation mark
        registeMorse('$', "0001001"); // Dollar sign
        registeMorse('@', "011010");  // At sign
        registeMorse(' ', "100001");  // Space
    }

    private final char dit; // short mark or dot
    private final char dah; // longer mark or dash
    private final char split;

    public MorseCoder() {
        this('.', '-', '/');
    }

    public MorseCoder(char dit, char dah, char split) {
        this.dit = dit;
        this.dah = dah;
        this.split = split;
    }

    public String encode(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text should not be null.");
        }
        text = text.toUpperCase();
        StringBuilder morse = new StringBuilder();
        for (int i = 0; i < text.codePointCount(0, text.length()); i++) {
            int codePoint = text.codePointAt(i);
            String value = alphabets.get(codePoint);
            if (value == null) {
                throw new RuntimeException("Unsupport code point : " + codePoint);
            }
            morse.append(value.replace('0', dit).replace('1', dah)).append(split);
        }
        return morse.toString();
    }

    public String decode(String morse) {
        if (morse == null) {
            throw new IllegalArgumentException("Morse should not be null.");
        }
        if (!StringUtils.containsOnly(morse, dit, dah, split)) {
            throw new IllegalArgumentException("Incorrect morse.");
        }
        String[] words = StringUtils.split(morse, split);
        StringBuilder text = new StringBuilder();
        for (String word : words) {
            Integer codePoint = dictionaries.get(word.replace(dit, '0').replace(dah, '1'));
            if (codePoint == null) {
                throw new RuntimeException("Unsupport word : " + word);
            }
            text.appendCodePoint(codePoint);
        }
        return text.toString();
    }

}
