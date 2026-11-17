package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    // ---- ALL-DU-PAIRS (6 more tests) ----
    @Test
    @DisplayName("P1 null attendance throws: DU pair 1 (attendance 31 to 32 T)")
    void bonusNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(null, 1));
    }

    @Test
    @DisplayName("P2 negative threshold throws: DU pair 5 (threshold 31 to 32 T)")
    void bonusNegativeThresholdThrows() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(new int[]{1}, -1));
    }

    @Test
    @DisplayName("P3 empty attendance, threshold 0: DU pairs 10 (present 35 to 50 T), 24")
    void bonusEmptyThresholdZero() {
        assertEquals(5, DataFlowTargets.bonus(new int[]{}, 0));
    }

    @Test
    @DisplayName("P4 all absent, threshold 1: DU pairs 11 (present 35 to 50 F), 24, 30")
    void bonusAllAbsentThresholdOne() {
        assertEquals(0, DataFlowTargets.bonus(new int[]{0, 0, 0}, 1));
    }

    @Test
    @DisplayName("P5 streak 5 but below threshold: DU pair 31 (score 49 to 54)")
    void bonusStreakFiveBelowThreshold() {
        assertEquals(3, DataFlowTargets.bonus(new int[]{1, 1, 1, 1, 1}, 6));
    }

    @Test
    @DisplayName("P6 exact threshold, short streak: DU pair 34 (score 51 to 56)")
    void bonusExactThreshold() {
        assertEquals(5, DataFlowTargets.bonus(new int[]{1}, 1));
    }
}
