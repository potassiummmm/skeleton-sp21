package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> aListNoResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        for (int i = 0; i < 3; i++) {
            aListNoResizing.addLast(i);
            buggyAList.addLast(i);
        }
        for (int i = 0; i < 3; i++) {
            assertEquals(aListNoResizing.removeLast(), buggyAList.removeLast());
        }
        assertEquals(aListNoResizing.size(), buggyAList.size());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            int correctSize = correct.size();
            int brokenSize = broken.size();
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                System.out.println("correct size: " + correctSize);
                System.out.println("broken size: " + brokenSize);
            } else if (operationNumber == 2) {
                // getLast
                if (correctSize > 0) {
                    System.out.println("last elem of correct list: " + correct.getLast());
                }
                if (brokenSize > 0) {
                    System.out.println("last elem of broken list: " + broken.getLast());
                }
            }
            else {
                if (correctSize > 0) {
                    int lastElem = correct.removeLast();
                    System.out.println("removed last elem of correct list: " + lastElem);
                }
                if (brokenSize > 0) {
                    int lastElem = broken.removeLast();
                    System.out.println("removed last elem of broken list: " + lastElem);
                }
            }
        }

    }
}
