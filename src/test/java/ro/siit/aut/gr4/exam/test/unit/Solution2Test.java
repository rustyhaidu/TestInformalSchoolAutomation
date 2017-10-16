package ro.siit.aut.gr4.exam.test.unit;

import org.testng.Assert;
import org.testng.annotations.Test;
import ro.siit.aut.gr4.exam.main.model.Monkey;
import ro.siit.aut.gr4.exam.main.solutions.Solution2;

public class Solution2Test {

    @Test
    public void bothSmiling() {
        Assert.assertTrue(Solution2.areWeInTrouble(
                new Monkey(true), new Monkey(true)));
    }

    @Test
    public void noneSmiling() {
        Assert.assertTrue(Solution2.areWeInTrouble(
                new Monkey(false), new Monkey(false)));
    }

    @Test
    public void firstSmiling() {
        Assert.assertFalse(Solution2.areWeInTrouble(
                new Monkey(true), new Monkey(false)));
    }

    @Test
    public void secondSmiling() {
        Assert.assertFalse(Solution2.areWeInTrouble(
                new Monkey(false), new Monkey(true)));
    }
}
