package com.smallcode.springcloudsample.service.provider.uc.util;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.*;

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
        testMultsetWordCount();
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
