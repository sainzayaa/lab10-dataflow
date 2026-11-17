package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GcdTest {

    @Test
    @DisplayName("T1 gcd(12,8)=4, 2 iterations: x(13,16) x(17,16) x(17,20) y(13,15)T y(13,16) y(13,17) y(18,15)T y(18,15)F y(18,16) y(18,17) tmp(16,18)")
    void gcdTwoIterations() {
        assertEquals(4, DataFlowTargets.gcd(12, 8));
    }

    @Test
    @DisplayName("T2 gcd(7,0)=7, loop skipped: x(13,20) y(13,15)F")
    void gcdYZero() {
        assertEquals(7, DataFlowTargets.gcd(7, 0));
    }

    @Test
    @DisplayName("T3 gcd(0,5)=5, 1 iteration: x(13,16) x(17,20) y(13,15)T y(13,16) y(13,17) y(18,15)F tmp(16,18)")
    void gcdXZero() {
        assertEquals(5, DataFlowTargets.gcd(0, 5));
    }
}
