package paser;

import promotion.SecondHalfProm;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class SecondHalfParser extends PromotionParser<SecondHalfProm> {
    private final Pattern pattern = compile("[A-Za-z0-9]+");
    @Override
    protected String parserLineCode(String line) {
        return line;
    }

    @Override
    protected SecondHalfProm parserLine(String line) {
        return SecondHalfProm.getSecondHalfProm();
    }

    @Override
    public Pattern getPattern() {
        return pattern;
    }
}
