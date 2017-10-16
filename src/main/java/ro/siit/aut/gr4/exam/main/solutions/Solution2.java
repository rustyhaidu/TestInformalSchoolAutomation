package ro.siit.aut.gr4.exam.main.solutions;

import ro.siit.aut.gr4.exam.main.model.Monkey;

public class Solution2 {
    public static boolean areWeInTrouble(Monkey monkeyA, Monkey monkeyB) {

        // implement me so that the unit tests found in Solution2Test are passed!
        if ((monkeyA.isSmiling() && monkeyB.isSmiling()
                || (!monkeyA.isSmiling() && !monkeyB.isSmiling()))) {
            return true;
        } else {
            return false;
        }

    }
}
