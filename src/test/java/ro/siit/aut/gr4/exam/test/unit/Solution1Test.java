package ro.siit.aut.gr4.exam.test.unit;

import org.testng.Assert;
import org.testng.annotations.Test;
import ro.siit.aut.gr4.exam.main.solutions.Solution1;

public class Solution1Test {

    @Test
    public void italic() {
        Assert.assertEquals(
                Solution1.createTags("i", "italic text"), "<i>italic text</i>");
    }

    @Test
    public void noText() {
        Assert.assertEquals(
                Solution1.createTags("i", ""), "<i></i>");
    }

    @Test
    public void noTag() {
        Assert.assertEquals(
                Solution1.createTags("", ""), "");
    }

    @Test
    public void nullTag() {
        Assert.assertEquals(Solution1.createTags(null, ""), "");
    }
}
