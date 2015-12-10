package paser;

import item.Item;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class ItemParser extends Parser {
    private final Pattern pattern=compile("^(\\w+):(\\d+)$");
    @Override
    protected Item paserLine(String line) {
        String[] input =line.split(":");
        return new Item(input[0],Double.parseDouble(input[1]));
    }

    @Override
    public Pattern getPattern() {
        return pattern;
    }
}
