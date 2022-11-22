package com.epam.mjs;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("mjc", Pattern.CASE_INSENSITIVE);

        System.out.println("Case insensitive flag " + pattern.flags());
        System.out.println("No flag " + Pattern.compile("mjc").flags());

        Predicate<String> stringPredicate = pattern.asPredicate();
        System.out.println("Predicate test result " + stringPredicate.test("Welcome to MJC"));
        System.out.println("Predicate negate test result " + stringPredicate.negate().test("Welcome to MJC")+"\n");

        String[] strings = Pattern.compile("\\d").split("Options: 1A 2B 3C 4D 5E");
        System.out.println(strings.length);
        for (String s : strings) {
            System.out.println(s);
        }

        Matcher matcher = pattern.matcher("Welcome to MJC");
        Pattern pattern1 = matcher.pattern();
        System.out.println("Patterns are the same - " + pattern1.equals(pattern));

        boolean matchFound = matcher.find();
        if (matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }

        System.out.println("Start - " + matcher.start());
        System.out.println("End - " + matcher.end()+"\n");

        Matcher digitsMatcher = Pattern.compile("\\d\\d\\d").matcher("Hello123, 456");
        if (digitsMatcher.find()) {
            System.out.println("Group - " + digitsMatcher.group());
        }

        System.out.println("Matches - " + matcher.matches());
        System.out.println(matcher.replaceAll("light talk about regex"));

        System.out.println(Pattern.compile("(\\d|(a|b|c)"));
    }
}
