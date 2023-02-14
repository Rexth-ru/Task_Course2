import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.Map.Entry.comparingByValue;

public class Main {
    public static void main(String[] args) {
        
// read the input from the console and remove punctuation and space
        
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.replaceAll("\\p{Punct}|\\p{Space}"," ");
        
// count the number of words
        
        List<String> stringList = new ArrayList<>(List.of(str.split(" ")));
        long n = stringList.stream().filter((x) -> !x.equals("")).count();
        System.out.println("В тексте "+n+" слов");
    
//print the most frequently mentioned words (10), ordered by the number of mentions in
//reverse order. In case of the same number of mentions, the words should be sorted alphabetically.
        
        Map<String, Long> map = stringList.stream().filter((x) -> !x.equals(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        map.entrySet().stream().sorted(Entry.comparingByKey())
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .limit(10).forEach(System.out::println);
        scanner.close();
    }
}
