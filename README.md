# Java - MorseCoder #

[![Build Status](https://travis-ci.org/TakWolf/Java-MorseCoder.svg?branch=master)](https://travis-ci.org/TakWolf/Java-MorseCoder)
[![Download](https://api.bintray.com/packages/takwolf/maven/Java-MorseCoder/images/download.svg)](https://bintray.com/takwolf/maven/Java-MorseCoder/_latestVersion)
[![License](https://img.shields.io/github/license/TakWolf/Java-MorseCoder.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

A Java implementation for Morse Code translation. Use non-standard way to support Unicode.

摩尔斯电码翻译器的一个 Java 语言实现。使用了非标准方式支持 Unicode 编码。

## 关于摩尔斯电码 ##

请参考：[维基百科：摩尔斯电码](https://zh.wikipedia.org/wiki/%E6%91%A9%E5%B0%94%E6%96%AF%E7%94%B5%E7%A0%81)

## 用法 ##

### Gradle ###

```
dependencies {
    compile 'com.takwolf:morse-coder:0.0.1'
}

repositories {
    jcenter()
}
```

### Java ###

```
MorseCoder morseCoder = new MorseCoder();
morseCoder.encode("Hello World!");
morseCoder.decode("...././.-../.-../---/-....-/.--/---/.-./.-../-../-.-.--/");
```

## 实现 ##

### 标准字典 ###

TODO

### 其他 Unicode 字符 ###

TODO

## Author ##

TakWolf

[takwolf@foxmail.com](mailto:takwolf@foxmail.com)

[http://takwolf.com](http://takwolf.com)

## License ##

```
Copyright 2015 TakWolf

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
