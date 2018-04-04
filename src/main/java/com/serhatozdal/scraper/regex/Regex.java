package com.serhatozdal.scraper.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author serhatozdal
 */
public class Regex extends RegexPatterns
{
    protected String match(String regexPattern, String html) {
        return match(regexPattern, html, 1);
    }

    protected String match(String regexPattern, String html, Integer groupIndex) {
        String result = "";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(html);
        if (matcher.find())
            result = matcher.group(groupIndex);
        return result;
    }

    protected List<String> matchAll(String regexPattern, String html) {
        return matchAll(regexPattern, html, 1);
    }

    protected List<String> matchAll(String regexPattern, String html, Integer groupIndex) {
        List<String> resultList = new ArrayList<>();
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find())
            resultList.add(matcher.group(groupIndex));
        return resultList;
    }
}
