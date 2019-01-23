package com.takwolf.morsecoder;

import org.junit.Assert;
import org.junit.Test;

public class MorseCoderTests {

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

    @Test
    public void test3() {
        String text = "\uD83D\uDE0D\uD83D\uDE03\uD83D\uDC3B\uD83D\uDD25";
        String morse = "-----.--.....--.-/-----.--.......--/-----.-....---.--/-----.-.-..-..-.-/";
        Assert.assertEquals(morseCoder.encode(text), morse);
        Assert.assertEquals(morseCoder.decode(morse), text);
    }

}
