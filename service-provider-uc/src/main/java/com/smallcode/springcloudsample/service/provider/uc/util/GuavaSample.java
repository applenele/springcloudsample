package com.smallcode.springcloudsample.service.provider.uc.util;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.*;
import com.google.common.hash.Hashing;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;

import java.util.ArrayList;
import java.util.List;

public class GuavaSample {

    public static void main(String[] args) {
//        Optional<Integer> optional = Optional.of(1);
//        System.out.println(optional.get());


        //Preconditions.checkArgument(1>2,"1<2");

        // Preconditions.checkNotNull(null,"不为null");

//        testStaticOrdering();
//        testObjects();
//        testMultsetWordCount();

//        testRangeSet();

        testHasning();
    }


    public static void testMath(){
        // 检查两个整数相加后，是否溢出
        IntMath.checkedAdd(2, 3); // 等于5
        IntMath.checkedAdd(Integer.MAX_VALUE, 1); // 整数最大值加1，溢出，抛出ArithmeticException
        // 检查两个整数相减后，是否溢出
        IntMath.checkedSubtract(5, 1); // 等于4
        IntMath.checkedSubtract(Integer.MIN_VALUE, 1); // 整数最小值减1，溢出，抛出ArithmeticException
        // 检查两个整数相乘后，是否溢出
        IntMath.checkedMultiply(20, 8); // 等于160
        IntMath.checkedMultiply(Integer.MAX_VALUE, 2); // 整数最大值乘以2，溢出，抛出ArithmeticException
        IntMath.checkedMultiply(Integer.MIN_VALUE, 2); // 整数最小值乘以2，溢出，抛出ArithmeticException
        // 检查一个整数的N次幂（即把一个整数自乘N次），是否溢出
        IntMath.checkedPow(5, 2); // 等于25，即 5 * 5 = 25
        IntMath.checkedPow(Integer.MAX_VALUE, 2); // 整数最大值自乘2次，溢出，抛出ArithmeticException
        IntMath.checkedPow(Integer.MIN_VALUE, 2); // 整数最小值自乘2次，溢出，抛出ArithmeticException


        // 检查两个长整数相加后，是否溢出
        LongMath.checkedAdd(Integer.MAX_VALUE, 100); // 整数最大值加100，等于2147483747
        LongMath.checkedAdd(Long.MAX_VALUE, 1); // 长整数最大值加1，溢出，抛出ArithmeticException
        // 检查两个长整数相减后，是否溢出
        LongMath.checkedSubtract(Integer.MIN_VALUE, 1); // 整数最小值减1，等于-2147483649
        LongMath.checkedSubtract(Long.MIN_VALUE, 1); // 长整数最小值减1，溢出，抛出ArithmeticException
        // 检查两个长整数相乘后，是否溢出
        LongMath.checkedMultiply(Integer.MAX_VALUE, Integer.MAX_VALUE); // 两个整数最大值相乘，等于4611686014132420609
        LongMath.checkedMultiply(Long.MAX_VALUE, 2); // 长整数最大值乘以2，溢出，抛出ArithmeticException
        LongMath.checkedMultiply(Long.MIN_VALUE, 2); // 长整数最小值乘以2，溢出，抛出ArithmeticException
        // 检查一个长整数的N次幂（即把一个长整数自乘N次），是否溢出
        LongMath.checkedPow(Integer.MAX_VALUE, 2); // 整数的最大值自乘2次，等于4611686014132420609
        LongMath.checkedPow(Long.MAX_VALUE, 2); // 长整数最大值自乘2次，溢出，抛出ArithmeticException
        LongMath.checkedPow(Long.MIN_VALUE, 2); // 长整数最小值自乘2次，溢出，抛出ArithmeticException
    }

    public static void testHasning() {
        String input = "hello, world";
        // 计算MD5
        System.out.println(Hashing.md5().hashBytes(input.getBytes()).toString());
        // 计算sha256
        System.out.println(Hashing.sha256().hashBytes(input.getBytes()).toString());
        // 计算sha512
        System.out.println(Hashing.sha512().hashBytes(input.getBytes()).toString());
        // 计算crc32
        System.out.println(Hashing.crc32().hashBytes(input.getBytes()).toString());

        System.out.println(Hashing.md5().hashUnencodedChars(input).toString());

    }

    public static void testRangeSet(){
        RangeSet rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10));
        rangeSet.toString();
        System.out.println(rangeSet);
        rangeSet.add(Range.closedOpen(11, 15));
        System.out.println(rangeSet);
        rangeSet.add(Range.open(15, 20));
        System.out.println(rangeSet);
        rangeSet.add(Range.openClosed(0, 0));
        System.out.println(rangeSet);
        rangeSet.remove(Range.open(5, 10));
        System.out.println(rangeSet);
    }


    public static void testMultsetWordCount() {
        String strWorld = "wer|dfd|dd|dfd|dda|de|dr";
        String[] words = strWorld.split("\\|");
        List<String> wordList = new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);

        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }
    }


    public static void testImmutable() {
        ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
                "red",
                "orange",
                "yellow",
                "green",
                "blue",
                "purple");
    }

    public static void testThrowables() {
        try {
            throw new Exception();
        } catch (Throwable t) {
            String ss = Throwables.getStackTraceAsString(t);
            System.out.println("ss:" + ss);
            throw Throwables.propagate(t);
        }
    }


    public static void testObjects() {
        //equal方法：用于判断两个对象是否相等,避免空指针
        System.out.println(Objects.equal(null, 123));//false
        System.out.println(Objects.equal(123, 123));//true
        System.out.println(Objects.equal(123, null));//false
        System.out.println(Objects.equal(null, null));//true


        System.out.println(Objects.hashCode("123"));
    }

    public static void testStaticOrdering() {
        List<String> list = Lists.newArrayList();
        list.add("peida");
        list.add("jerry");
        list.add("harry");
        list.add("eva");
        list.add("jhon");
        list.add("neron");

        System.out.println("list:" + list);

        Ordering<String> naturalOrdering = Ordering.natural();
        Ordering<Object> usingToStringOrdering = Ordering.usingToString();
        Ordering<Object> arbitraryOrdering = Ordering.arbitrary();

        System.out.println("naturalOrdering:" + naturalOrdering.sortedCopy(list));
        System.out.println("usingToStringOrdering:" + usingToStringOrdering.sortedCopy(list));
        System.out.println("arbitraryOrdering:" + arbitraryOrdering.sortedCopy(list));
    }


}
