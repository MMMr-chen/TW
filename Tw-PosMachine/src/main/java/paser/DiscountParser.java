package paser;

import promotion.DiscountPromotion;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class DiscountParser extends PromotionParser<DiscountPromotion> {
    private final Pattern pattern=compile("^(\\w+):(\\d+)$");
    @Override
    protected String parserLineCode(String line) {
        return line.split(":")[0];
    }

    @Override
    protected DiscountPromotion parserLine(String line) {
        return new DiscountPromotion(Integer.parseInt(line.split(":")[1]));
    }

    @Override
    public Pattern getPattern() {
        return pattern;
    }
}
