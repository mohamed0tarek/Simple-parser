import java.io.*;

//Scanner
class ArithmeticScan extends Tokenstream {
    private StreamTokenizer streamTokenizer;

    public ArithmeticScan(String filename) {
        try {
            streamTokenizer = new StreamTokenizer(new FileReader(filename));
            setup();
            next();
        } catch (IOException e) {
            throw new IllegalArgumentException("Error opening file " + filename);
        }
    }

    private void setup() {
        streamTokenizer.resetSyntax();
        streamTokenizer.parseNumbers();
        streamTokenizer.whitespaceChars(' ', ' ');
        streamTokenizer.whitespaceChars('\t', '\t');
        streamTokenizer.whitespaceChars('\n', '\n');
        streamTokenizer.whitespaceChars('\r', '\r');
    }

    public void next() {
        if (currToken != EOF)
            try {
                currToken = streamTokenizer.nextToken();
                switch (currToken) {
                    case StreamTokenizer.TT_EOF:
                        currToken = EOF;
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        numericValue = streamTokenizer.nval;
                        currToken = DOUBLE;
                        break;
                    case '(':
                    case ')':
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        break;
                    default:
                        throw new IllegalArgumentException("Illegal token " + this);
                }
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
    }
}