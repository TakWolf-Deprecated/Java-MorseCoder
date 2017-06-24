package com.takwolf.morsecoder;

import org.junit.Assert;
import org.junit.Test;

public class MorseCoderTest {

    private final MorseCoder morseCoder = new MorseCoder();

    @Test
    public void test0() {
        String text = "Hello World!";
        String morse = "...././.-../.-../---/-...../.--/---/.-./.-../-../-.-.--/";
        Assert.assertEquals(morseCoder.encode(text), morse);
        Assert.assertEquals(morseCoder.decode(morse), text.toUpperCase());
    }

    @Test
    public void test1() {
        String text = "你好，世界！";
        String morse = "-..----.--...../-.--..-.-----.-/--------....--../-..---....-.--./---.-.-.-..--../--------.......-/";
        Assert.assertEquals(morseCoder.encode(text), morse);
        Assert.assertEquals(morseCoder.decode(morse), text);
    }

    @Test
    public void test2() {
        String text = "こんにちは";
        String morse = "--.....-.-..--/--....-..-..--/--.....--.-.--/--.....--....-/--.....--.----/";
        Assert.assertEquals(morseCoder.encode(text), morse);
        Assert.assertEquals(morseCoder.decode(morse), text);
    }

}
