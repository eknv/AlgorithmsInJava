package com.eknv.algorithms.sort_search;

/**
 * I want to learn some big words so people think I'm smart.
 * <p>
 * I opened up a dictionary to a page in the middle and started flipping through,
 * looking for words I didn't know.
 * <p>
 * I put each word I didn't know at increasing indices in a huge array I created in memory.
 * When I reached the end of the dictionary, I started from the beginning and did the same thing until I reached the page I started at.
 * <p>
 * Now I have an array of words that are mostly alphabetical,
 * except they start somewhere in the middle of the alphabet, reach the end,
 * and then start from the beginning of the alphabet.
 * <p>
 * In other words, this is an alphabetically ordered array that has been "rotated." For example:
 * <p>
 * String[] words = new String[]{
 * "ptolemaic",
 * "retrograde",
 * "supplant",
 * "undulate",
 * "xenoepist",
 * "asymptote",  // <-- rotates here!
 * "babka",
 * "banoffee",
 * "engender",
 * "karpatka",
 * "othellolagkage",
 * };
 * <p>
 * Write a method for finding the index of the "rotation point,"
 * which is where I started working from the beginning of the dictionary.
 * <p>
 * This array is huge (there are lots of words I don't know) so we want to be efficient here.
 */
public class FindRotationPoint {

    private FindRotationPoint() {
    }

    public static int findRotationPoint(String[] words) {

        if (words == null || words.length <= 1) {
            return -1;
        }

        int start = 0;
        int end = words.length - 1;
        int mid = 0;

        while (end - start > 1) {
            mid = (start + end) / 2;

            if (words[mid].compareTo(words[start]) < 0) {
                end = mid;
            } else if (words[mid].compareTo(words[end]) > 0) {
                start = mid;
            }
        }


        return mid + 1;
    }

}