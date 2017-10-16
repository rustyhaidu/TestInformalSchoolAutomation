package ro.siit.aut.gr4.exam.main.solutions;

public class Solution1 {
    public static String createTags(String i, String italic_text) {
        String generatedHtml;

        if((i == null) || ((i.equals("")))){
            generatedHtml ="";
        }else{
            generatedHtml = "<"+i+">"+italic_text+"</"+i+">";
        }

        return generatedHtml;
    }
    // implement me so that the unit tests found in Solution1Test are passed!
}
