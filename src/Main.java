import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Tokenstream tokenstream = new ArithmeticScan("src/test.txt");
        ArithmeticEvaluationAndParser pr = new ArithmeticEvaluationAndParser(tokenstream);
        double res = pr.parse();
        System.out.println(res);

    }
}
