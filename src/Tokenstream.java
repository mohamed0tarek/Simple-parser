abstract class Tokenstream {

    static final int DOUBLE = -99;
    static final int EOF = -100;
    public int currToken;
    public double numericValue;

    abstract public void next();
}