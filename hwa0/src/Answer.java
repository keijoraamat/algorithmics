import java.util.*;

/** Lab 1.
 * @since 1.8
 */
public class Answer {

    public static void main (String[] param) {

        // TODO!!! Solutions to small problems
        //   that do not need an independent method!

        // conversion double -> String

        double d = 3.14;
        double dd = 4.345;
        String s1 = String.valueOf(d);
        String s2 = Double.toString(dd);
        System.out.println(s1);
        System.out.println(s2);
        // conversion String -> int

        Integer i1 = Integer.valueOf("666");
        int i2 = 0;
        try {
            i2 = Integer.parseInt("777v");
        } catch (NumberFormatException e) {
            e.printStackTrace(System.out);
        }

        System.out.println(i2+1);

        // "hh:mm:ss"

        // cos 45 deg

        // table of square roots

//        String firstString = "ABcd12";
//        String result = reverseCase (firstString);
//        System.out.println ("\"" + firstString + "\" -> \"" + result + "\"");

        // reverse string

//        String s = "How  many      words   here";
//        int nw = countWords (s);
//        System.out.println (s + "\t" + nw);

        // pause. COMMENT IT OUT BEFORE JUNIT-TESTING!
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final int LSIZE = 40;
        ArrayList<Integer> randList = new ArrayList<Integer> (LSIZE);
        Random generaator = new Random();
        for (int i=0; i<LSIZE; i++) {
            randList.add (generaator.nextInt(1000));
        }

        // minimal element

        // HashMap tasks:
        //    create
        //    print all keys
        //    remove a key
        //    print all pairs

        System.out.println ("Before reverse:  " + randList);
        reverseList (randList);
        System.out.println ("After reverse: " + randList);

        System.out.println ("Maximum: " + maximum (randList));
    }

    /** Finding the maximal element.
     * @param a Collection of Comparable elements
     * @return maximal element.
     * @throws NoSuchElementException if <code> a </code> is empty.
     */
    static public <T extends Object & Comparable<? super T>> T maximum (Collection<? extends T> a)
            throws NoSuchElementException {

        return Collections.max(a);
    }

    /** Counting the number of words. Any number of any kind of
     * whitespace symbols between words is allowed.
     * @param text text
     * @return number of words in the text
     */
    public static int countWords (String text) {
        text = text.replaceAll("[\\n\\t]", " ");
        String[] words = text.split(" ");

        int len = 0;
        for (String word: words) {
            if (word.length() != 0){
                len++;
            }
        }
        return len;
    }

    /** Case-reverse. Upper -> lower AND lower -> upper.
     * @param s string
     * @return processed string
     */
    public static String reverseCase (String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c) && Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isAlphabetic(c) && Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
               sb.append(c);
            }
        }
        return sb.toString();
    }

    /** List reverse. Do not create a new list.
     * @param list list to reverse
     */
    public static <T extends Object> void reverseList (List<T> list)
            throws UnsupportedOperationException {
        // Used help from https://www.geeksforgeeks.org/java-program-to-reverse-a-list/
        // Option 1:  the Collections:
        // Collections.reverse(list);

        // Option 2:  recursive
        if (list.size() <= 1 || list == null){
            return;
        }
        T value = list.remove(0);
        reverseList(list);
        list.add(value);

    }
}

