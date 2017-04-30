package com.takwolf.morsecoder;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public final class MorseCoder {

    private static final Map<Integer, String> alphabets = new HashMap<>();    // code point -> morse
    private static final Map<String, Integer> dictionaries = new HashMap<>(); // morse -> code point

    private static void registeMorse(Character abc, String dict) {
        alphabets.put(Integer.valueOf(abc), dict);
        dictionaries.put(dict, Integer.valueOf(abc));
    }

    static {
        // Letters
        registeMorse('A', "01");
        registeMorse('B', "1000");
        registeMorse('C', "1010");
        registeMorse('D', "100");
        registeMorse('E', "0");
        registeMorse('F', "0010");
        registeMorse('G', "110");
        registeMorse('H', "0000");
        registeMorse('I', "00");
        registeMorse('J', "0111");
        registeMorse('K', "101");
        registeMorse('L', "0100");
        registeMorse('M', "11");
        registeMorse('N', "10");
        registeMorse('O', "111");
        registeMorse('P', "0110");
        registeMorse('Q', "1101");
        registeMorse('R', "010");
        registeMorse('S', "000");
        registeMorse('T', "1");
        registeMorse('U', "001");
        registeMorse('V', "0001");
        registeMorse('W', "011");
        registeMorse('X', "1001");
        registeMorse('Y', "1011");
        registeMorse('Z', "1100");
        // Numbers
        registeMorse('0', "11111");
        registeMorse('1', "01111");
        registeMorse('2', "00111");
        registeMorse('3', "00011");
        registeMorse('4', "00001");
        registeMorse('5', "00000");
        registeMorse('6', "10000");
        registeMorse('7', "11000");
        registeMorse('8', "11100");
        registeMorse('9', "11110");
        // Punctuation
        registeMorse('.', "010101");
        registeMorse(',', "110011");
        registeMorse('?', "001100");
        registeMorse('\'', "011110");
        registeMorse('!', "101011");
        registeMorse('/', "10010");
        registeMorse('(', "10110");
        registeMorse(')', "101101");
        registeMorse('&', "01000");
        registeMorse(':', "111000");
        registeMorse(';', "101010");
        registeMorse('=', "10001");
        registeMorse('+', "01010");
        registeMorse('-', "100001");
        registeMorse('_', "001101");
        registeMorse('"', "010010");
        registeMorse('$', "0001001");
        registeMorse('@', "011010");
        registeMorse(' ', "100001");
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
        StringBuilder morseBuilder = new StringBuilder();
        for (int i = 0; i < text.codePointCount(0, text.length()); i++) {
            int codePoint = text.codePointAt(i);
            String word = alphabets.get(codePoint);
            if (word == null) {
                word = Integer.toBinaryString(codePoint);
            }
            morseBuilder.append(word.replace('0', dit).replace('1', dah)).append(split);
        }
        return morseBuilder.toString();
    }

    public String decode(String morse) {
        if (morse == null) {
            throw new IllegalArgumentException("Morse should not be null.");
        }
        if (!StringUtils.containsOnly(morse, dit, dah, split)) {
            throw new IllegalArgumentException("Incorrect morse.");
        }
        String[] words = StringUtils.split(morse, split);
        StringBuilder textBuilder = new StringBuilder();
        for (String word : words) {
            word = word.replace(dit, '0').replace(dah, '1');
            Integer codePoint = dictionaries.get(word);
            if (codePoint == null) {
                codePoint = Integer.valueOf(word, 2);
            }
            textBuilder.appendCodePoint(codePoint);
        }
        return textBuilder.toString();
    }

}
