/**
 * Sorting of balls.
 *
 * @since 1.8
 */
public class ColorSort {

    public static void main(String[] param) {

    }

    ;

    public static void reorder(Color[] balls) {
        // reds to the left, blues to the right and greens are stuck in the middle

        if (balls.length < 2) return;
/*
      // 1. solution the Insertion Sort
      // too slow
      for (int i = 1; i < balls.length; i++) {
         Color t = balls[i];
         int j;
         for ( j = i-1; j >= 0; j--) {
            if (balls[j].compareTo(t) <=0) break;
            balls[j+1] = balls[j];
         }
         balls[j+1] = t;
      }*/


 /*         // 2. solution
            // doesn't function correctly. too complex to debug.
            for (int i = 0; i < balls.length; i++) {

            if (balls[i] == Color.blue  && b > i) {
                Color t = balls[b];
                balls[b] = balls[i];
                balls[i] = t;
                if (t == Color.red){
                    r++;
                }
                b--;
            } else if (balls[i] == Color.green) {
                Color t = balls[i];
                if (balls[b] == Color.blue) {
                    balls[i] = balls[b-1];
                    balls[b-1] = t;
                    b--;
                } else if (balls[b] == Color.red){
                    balls[r] = balls[b];
                    balls[b] = t;
                    r++;
                } else {
                    balls[i] = balls[b];
                    balls[b] = t;
                }

            } else if (balls[i] == Color.red) {
                Color temp = balls[r];
                if (balls[r] == Color.blue){
                    Color t = balls[b];
                    balls[b] = balls[i+1];
                    b--;
                }
                balls[r] = balls[i];
                balls[i] = temp;
                r++;
            }
            }
            */

        // 3. solution
        // inspired by ../test/ColorSortTest.java, method check
        // fast enough

        int reds = 0;
        int blues = 0;

        // count the sides and paint all green
        for (int i = 0; i < balls.length; i++) {
            if (balls[i] == Color.red){
                reds++;

            }else if (balls[i] == Color.blue){
                blues++;
            }
            balls[i] = Color.green;
        }

        // paint beginning red
        for (int i = 0; i < reds; i++) {
            balls[i] = Color.red;
        }

        // paint end blue
        for (int i = balls.length - blues; i < balls.length; i++) {
            balls[i] = Color.blue;
        }


    }

    enum Color {red, green, blue}

}

