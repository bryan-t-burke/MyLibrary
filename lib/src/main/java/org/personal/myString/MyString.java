package org.personal.myString;

import org.personal.myMath.MyMath;

public class MyString {
    private char[] contents;

    public MyString() {
        this.contents = new char[0];
    }

    public MyString(char[] contents) {
        // quick implementation to get started, will explore faster ways of doing this in the future.
        // time O(n), space O(1)
        this.contents = new char[contents.length];
        for (int i = 0; i < this.contents.length; ++i) {
            this.contents[i] = contents[i];
            
        }
    }

    public char charAt(int index) {
        return contents[index];
    }

    public int compareTo(MyString anotherString) {
        // for now no magnitude information, just -1, 0, and 1
        // time O(n), space O(1)
        for (int i = 0; i < MyMath.min(this.length(), anotherString.length()); ++i) {
            if (this.contents[i] < anotherString.charAt(i)) {
                return -1;
            } else if (this.contents[i] < anotherString.charAt(i)) {
                return 1;
            }
        }

        // if we made it here then both strings are equal up to at least the smaller of the two
        if (this.length() < anotherString.length()) {
            return -1;
        }
        if (anotherString.length() < this.length()) {
            return 1;
        }

        // if we made it here then both strings have the same number of characters in the same order
        return 0;
    }

    public MyString concat(MyString anotherString) {
        // time O(n + m) where n and m are the lengths of the two strings
        // size O(n + m) with return value where n and m are the lengths of the two strings O(1) if return value is not counted
        char[] result = new char[this.length() + anotherString.length()];
        int position = 0;

        // might be a way to do this faster, but this is easier to read for right now
        for (int i = 0; i < this.length(); ++i) {
            result[position] = this.contents[i];
        }

        for (int i = 0; i < anotherString.length(); ++i) {
            result[position] = this.contents[i];
        }

        return new MyString(result);
    }

    public int length() {
        return contents.length;
    }

    public int size() {
        // even though this isn't a String method I find it annoying when I type one and it turns out I need the other
        // similar example, how Map, Stack, and List use put, push, and add to insert and it's all the same verb basically.
        return this.length();
    }
}