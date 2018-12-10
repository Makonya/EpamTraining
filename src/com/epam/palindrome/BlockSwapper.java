package com.epam.palindrome;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.*;

public class BlockSwapper {
    private static final String FIRST_BLOCK = "1101101";
    private static final String SECOND_BLOCK = "1101011";
    private static final Logger LOGGER = Logger.getLogger(BlockSwapper.class);

    private static String swap(String block, int start, int end) {
        StringBuilder reversedString = new StringBuilder(block.substring(start, end + 1));
        reversedString.reverse();
        StringBuilder result = new StringBuilder(block);
        result.replace(start, end + 1, reversedString.toString());
        return result.toString();
    }

    private static String  formatBlock(String block){
        int firstIndex = 0;
        int lastIndex = 0;
        do {
            try{
                Pattern patternFindFirstIndex = Pattern.compile("[1][0]");
                Matcher matcher = patternFindFirstIndex.matcher(block);
                matcher.find();
                firstIndex = matcher.start();

                for (int i = block.length()-1; i > 1; i--) {
                    if (block.charAt(i) == '1' && block.charAt(i - 1) == '1') {
                        lastIndex = i;
                        break;
                    }
                }
                block = swap(block, firstIndex, lastIndex);
            } catch (IllegalStateException e){
                LOGGER.warn("It's impossible to swap block!");
            }
        } while (firstIndex != lastIndex);
        return block;
    }

    public static void main(String[] args) {
        System.out.println("Before formatting: " + FIRST_BLOCK + ", " + SECOND_BLOCK);
        String formattedFirstBlock = formatBlock(FIRST_BLOCK);
        String formattedSecondBlock = formatBlock(SECOND_BLOCK);
        if (formattedFirstBlock.equals(formattedSecondBlock)){
            System.out.println("Two blocks are identity: " + formattedFirstBlock);
        } else {
            System.out.println("Two blocks are not identity: " + formattedFirstBlock + ", " + formattedSecondBlock);
        }
    }
}
