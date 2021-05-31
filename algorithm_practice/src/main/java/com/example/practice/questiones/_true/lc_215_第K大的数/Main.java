package com.example.practice.questiones._true.lc_215_第K大的数;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void test() {
        int[] array = {4, 3, 2, 1};
        Assertions.assertEquals(3, new Solution().findKthLargest(array, 2));
        Assertions.assertEquals(3, new Solution2().findKthLargest(array, 2));
        Assertions.assertEquals(3, new Solution3().findKthLargest(array, 2));
    }
}
