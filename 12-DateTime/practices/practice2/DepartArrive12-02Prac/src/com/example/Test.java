public static class Test {
    public static void main(String[] args) {
        String[] strList = { "tomorrow", "toto", "to", "timbukto", "the", "hello", "heat" };
        String searchStr = "to";
        System.out.println("Searching for: " + searchStr);

        // Call concrete class that implments StringAnalyzer
        ContainsAnalyzer contains = new ContainsAnalyzer();

        System.out.println("===Contains===");
        for (String currentStr : strList) {
            if (contains.analyze(currentStr, searchStr)) {
                System.out.println("Match: " + currentStr);
            }
        }
    }
}

public class Z03Analyzer {

    public static void searchArr(String[] strList, String searchStr, StringAnalyzer analyzer) {
        for (String currentStr : strList) {
            if (analyzer.analyze(currentStr, searchStr)) {
                System.out.println("Match: " + currentStr);
            }
        }
    }
    // A number of lines omitted
}

13   public static void main(String[] args) {
    14     String[] strList01 = 
    15     {"tomorrow","toto","to","timbukto","the","hello","heat"};  
    16     String searchStr = "to";
    17     System.out.println("Searching for: " + searchStr);
    18     
    19     // Call concrete class that implments StringAnalyzer
    20     ContainsAnalyzer contains = new ContainsAnalyzer();
    21         
    22     System.out.println("===Contains===");
    23     Z03Analyzer.searchArr(strList01, searchStr, contains);
    24   } 
    