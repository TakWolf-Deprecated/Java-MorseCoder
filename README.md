# Java - MorseCoder #

[![Build Status](https://travis-ci.org/TakWolf/Java-MorseCoder.svg?branch=master)](https://travis-ci.org/TakWolf/Java-MorseCoder)
[![Download](https://api.bintray.com/packages/takwolf/maven/Java-MorseCoder/images/download.svg)](https://bintray.com/takwolf/maven/Java-MorseCoder/_latestVersion)
[![License](https://img.shields.io/github/license/TakWolf/Java-MorseCoder.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

A Java implementation for Morse Code translation. Use non-standard way to support Unicode.

摩尔斯电码翻译器的一个 Java 语言实现。使用了非标准方式支持 Unicode 编码。

兼容 Android 环境。

## 关于摩尔斯电码 ##

请参考：[维基百科 -> 摩尔斯电码](https://zh.wikipedia.org/wiki/摩尔斯电码)

具体实现思路，请参考文章 [http://blog.takwolf.com/2017/05/02/java-morse-coder](http://blog.takwolf.com/2017/05/02/java-morse-coder)

## 用法 ##

### Gradle ###

```
dependencies {
    compile 'com.takwolf:morse-coder:0.0.3'
}

repositories {
    jcenter()
}
```

### Java ###

```
MorseCoder morseCoder = new MorseCoder();
morseCoder.encode("Hello World!");
morseCoder.decode("...././.-../.-../---/-...../.--/---/.-./.-../-../-.-.--/");
```

## 实现 ##

### 标准字典 ###

注意：字母都会转换为大写，0 为短信号，1 为长信号。

| 字符 | 电码 |
|---|---|
| A | 01 |
| B | 1000 |
| C | 1010 |
| D | 100 |
| E | 0 |
| F | 0010 |
| G | 110 |
| H | 0000 |
| I | 00 |
| J | 0111 |
| K | 101 |
| L | 0100 |
| M | 11 |
| N | 10 |
| O | 111 |
| P | 0110 |
| Q | 1101 |
| R | 010 |
| S | 000 |
| T | 1 |
| U | 001 |
| V | 0001 |
| W | 011 |
| X | 1001 |
| Y | 1011 |
| Z | 1100 |

| 字符 | 电码 |
|---|---|
| 0 | 11111 |
| 1 | 01111 |
| 2 | 00111 |
| 3 | 00011 |
| 4 | 00001 |
| 5 | 00000 |
| 6 | 10000 |
| 7 | 11000 |
| 8 | 11100 |
| 9 | 11110 |

| 字符 | 电码 |
|---|---|
| . | 010101 |
| , | 110011 |
| ? | 001100 |
| ' | 011110 |
| ! | 101011 |
| / | 10010 |
| ( | 10110 |
| ) | 101101 |
| & | 01000 |
| : | 111000 |
| ; | 101010 |
| = | 10001 |
| + | 01010 |
| - | 100001 |
| _ | 001101 |
| " | 010010 |
| $ | 0001001 |
| @ | 011010 |

### 其他 Unicode 字符 ###

编码时，直接将 codePoint 转换为 2 进制字符串，然后 0 替换为短信号，1 替换为长信号。

解码时反之。

该思路来源于：[https://github.com/hustcc/xmorse](https://github.com/hustcc/xmorse)

你也可以通过这个网址进行在线测试：[http://git.hust.cc/xmorse](http://git.hust.cc/xmorse)

## Author ##

TakWolf

[takwolf@foxmail.com](mailto:takwolf@foxmail.com)

[http://takwolf.com](http://takwolf.com)

## License ##

```
Copyright 2017 TakWolf

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
