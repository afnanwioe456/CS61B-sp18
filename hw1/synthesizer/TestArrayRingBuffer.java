package synthesizer;

import org.junit.Test;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(1.0);
        arb.enqueue(2.0);
        assertEquals(arb.fillCount, 2);
        double item = arb.dequeue();
        assertEquals(item, 1.0, 0.001);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
}
