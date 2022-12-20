
//Parser and Evaluation

class ArithmeticEvaluationAndParser {
    private Tokenstream tokenstream;

    public ArithmeticEvaluationAndParser(Tokenstream tokenstream) {
        this.tokenstream = tokenstream;
    }

    double E() {
        double T = T();
        return EDash(T);
    }

    double EDash(double numericValue) {
        switch (tokenstream.currToken) {
            case '+':
                tokenstream.next();
                return EDash(numericValue + T());
            case '-':
                tokenstream.next();
                return EDash(numericValue - T());
            default:
                return numericValue;
        }
    }

    double T() {
        double F = F();
        return TDash(F);
    }

    double TDash(double numericValue) {
        switch (tokenstream.currToken) {
            case '*':
                tokenstream.next();
                return TDash(numericValue * F());
            case '/':
                tokenstream.next();
                return TDash(numericValue / F());
            default:
                return numericValue;
        }
    }

    double F() {
        switch (tokenstream.currToken) {
            case ArithmeticScan.DOUBLE:
                tokenstream.next();
                return tokenstream.numericValue;
            case '(':
                tokenstream.next();
                double eval = E();
                if (tokenstream.currToken != ')')
                    throw new IllegalArgumentException("Expected ')'");
                tokenstream.next();
                return eval;
            default:
                throw new IllegalArgumentException("Expected number or '('");
        }
    }

    double parse() {
        double result = E();
        if (tokenstream.currToken != Tokenstream.EOF)
            throw new IllegalArgumentException("Expected end of file");
        return result;
    }
}