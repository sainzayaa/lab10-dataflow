package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusTest {

    // ---- ALL-DEFS (2 tests) ----
    @Test
    @DisplayName("D1 all-defs: every def except score@49 reaches a use; DU pairs 2,3,4,6,7,9,12,13,15-21,25-27,29,30,33,35")
    void bonusLongStreakWithGap() {
        assertEquals(8, DataFlowTargets.bonus(new int[]{1, 1, 1, 1, 1, 0, 1}, 3));
    }

    @Test
    @DisplayName("D2 all-defs: score@49 reaches use at 56; DU pairs 8,14,28,32")
    void bonusBelowThresholdShortAttendance() {
        assertEquals(0, DataFlowTargets.bonus(new int[]{1}, 2));
    }
}
