package threefoursum;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class FourSumTest {
    @Test
    public void testFourSum() {
        // Cases where there are no triplet
        int[] list_0_triplet = { 1, 2, 3, 4 };

        assertNull(ThreeFourSum.fourSumCubic(list_0_triplet));
        assertNull(ThreeFourSum.fourSumQuartic(list_0_triplet));
        assertNull(ThreeFourSum.fourSumHashMap(list_0_triplet));

        // Cases where there is one triplet
        int[] list_1_triplet_distinct = { 1, 2, 3, -6 };
        int[] list_1_triplet_equal = { 2, -3, 2, -3, 1, -6, 3}; // Case with equal integers

        assertNotNull(ThreeFourSum.fourSumCubic(list_1_triplet_distinct));
        assertNotNull(ThreeFourSum.fourSumQuartic(list_1_triplet_distinct));
        assertNotNull(ThreeFourSum.fourSumHashMap(list_1_triplet_distinct));

        assertNotNull(ThreeFourSum.fourSumCubic(list_1_triplet_equal));
        assertNotNull(ThreeFourSum.fourSumQuartic(list_1_triplet_equal));
        assertNotNull(ThreeFourSum.fourSumHashMap(list_1_triplet_equal));

        // Case where there are multiple triplets
        // QUESTION: How relevant? I am indirectly testing triplets with 1 solution in our case
        int[] list_mult_input = { 1, 2, -3, -4, 5, -6, -7, 8, 1, -2, 3, -1 };
        int[] list_mult_input_equal = { 1, 2, 3, -3, -4, 5, -6, -7, 8, 1, -2, -7, 3, -1 }; // Case with equal integers
        int[] list_mult_expected = { 1, -3, -4, 6 };
        int[] list_mult_expected_sorted = { -7, -6, 5, 8 }; // Exception for quadratic: sorted results

        assertNotNull(ThreeFourSum.fourSumQuartic(list_mult_input));
        assertArrayEquals(list_mult_expected, ThreeFourSum.fourSumQuartic(list_mult_expected));
        assertNotNull(ThreeFourSum.fourSumCubic(list_mult_input));
        assertArrayEquals(list_mult_expected_sorted, ThreeFourSum.fourSumCubic(list_mult_expected_sorted));
        assertNotNull(ThreeFourSum.fourSumHashMap(list_mult_input));
        assertArrayEquals(list_mult_expected, ThreeFourSum.fourSumHashMap(list_mult_expected));

        assertNotNull(ThreeFourSum.fourSumQuartic(list_mult_input_equal));
        assertArrayEquals(list_mult_expected, ThreeFourSum.fourSumQuartic(list_mult_expected));
        assertNotNull(ThreeFourSum.fourSumCubic(list_mult_input_equal));
        assertArrayEquals(list_mult_expected_sorted, ThreeFourSum.fourSumCubic(list_mult_expected_sorted));
        assertNotNull(ThreeFourSum.fourSumHashMap(list_mult_input_equal));
        assertArrayEquals(list_mult_expected, ThreeFourSum.fourSumHashMap(list_mult_expected));

        // Cases where there are fewer than 3 distinct integers (1 or 2) in the list
        int[] list_2_el_false = { 1, -1 }; // Case with 2 elements summing up to 0

        assertNull(ThreeFourSum.fourSumCubic(list_2_el_false));
        assertNull(ThreeFourSum.fourSumQuartic(list_2_el_false));
        assertNull(ThreeFourSum.fourSumHashMap(list_2_el_false));

        int[] list_2_el_true = { 1, 2 }; // Case with 2 elements not summing up to 0

        assertNull(ThreeFourSum.fourSumCubic(list_2_el_true));
        assertNull(ThreeFourSum.fourSumQuartic(list_2_el_true));
        assertNull(ThreeFourSum.fourSumHashMap(list_2_el_true));

        int[] list_1_el_true = { 0 }; // Case with 1 element summing up to 0

        assertNull(ThreeFourSum.fourSumCubic(list_1_el_true));
        assertNull(ThreeFourSum.fourSumQuartic(list_1_el_true));
        assertNull(ThreeFourSum.fourSumHashMap(list_1_el_true));

        int[] list_1_el_false = { 1 }; // Case with 1 element not summing up to 0

        assertNull(ThreeFourSum.fourSumCubic(list_1_el_false));
        assertNull(ThreeFourSum.fourSumQuartic(list_1_el_false));
        assertNull(ThreeFourSum.fourSumHashMap(list_1_el_false));

        // Case where there is an empty list
        int[] list_empty = {};

        assertNull(ThreeFourSum.fourSumCubic(list_empty));
        assertNull(ThreeFourSum.fourSumQuartic(list_empty));
        assertNull(ThreeFourSum.fourSumHashMap(list_empty));

        // Cases where there are several equal integers, also less than 4 elements
        int[] list_equal = { 0, 0, 0, 0 }; // Case with 4 equal integers summing up to 0

        assertNotNull(ThreeFourSum.fourSumCubic(list_equal));
        assertNotNull(ThreeFourSum.fourSumQuartic(list_equal));
        assertNotNull(ThreeFourSum.fourSumHashMap(list_equal));

        int[] list_equal_true = { 0, 0, 0 }; // Case with 3 equal integers summing up to 0

        assertNull(ThreeFourSum.fourSumCubic(list_equal_true));
        assertNull(ThreeFourSum.fourSumQuartic(list_equal_true));
        assertNull(ThreeFourSum.fourSumHashMap(list_equal_true));

        int[] list_equal_false = { 1, 1, 1, 1 }; // Case with 4 equal integers not summing up to 0

        assertNull(ThreeFourSum.fourSumCubic(list_equal_false));
        assertNull(ThreeFourSum.fourSumQuartic(list_equal_false));
        assertNull(ThreeFourSum.fourSumHashMap(list_equal_false));

        int[] list_equal_2_el_false = { 1, 1 }; // Case with 2 equal integers not summing up to 0

        assertNull(ThreeFourSum.fourSumCubic(list_equal_2_el_false));
        assertNull(ThreeFourSum.fourSumQuartic(list_equal_2_el_false));
        assertNull(ThreeFourSum.fourSumHashMap(list_equal_2_el_false));

        int[] list_equal_2_el_true = { 0, 0 }; // Case with 2 equal integers summing up to 0

        assertNull(ThreeFourSum.fourSumCubic(list_equal_2_el_true));
        assertNull(ThreeFourSum.fourSumQuartic(list_equal_2_el_true));
        assertNull(ThreeFourSum.fourSumHashMap(list_equal_2_el_true));

        // Case with only negative integers
        int [] list_negatives = { -1, -2, -3, -4, -5 };

        assertNull(ThreeFourSum.fourSumCubic(list_negatives));
        assertNull(ThreeFourSum.fourSumQuartic(list_negatives));
        assertNull(ThreeFourSum.fourSumHashMap(list_negatives));
    }
}