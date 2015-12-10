package paser;

import item.CartItem;

import java.util.regex.Pattern;

public class CartParser extends Parser {
    private  Pattern pattern=Pattern.compile("^(\\w+)-(\\d+)$");
    @Override
    protected CartItem paserLine(String line) {
        String[] input=line.split("-");
        return new CartItem(input[0],Integer.parseInt(input[1]));
    }

    @Override
    public Pattern getPattern() {
        return pattern;
    }
}
