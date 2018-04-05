package com.serhatozdal.scraper.regex;

import com.serhatozdal.scraper.model.Credits;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author serhatozdal
 */
public class Regex extends RegexPatterns {

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

    protected List<Credits> matchAllCredits(String regexPattern, String html, Integer keyIndex, Integer valueIndex) {
        List<Credits> list = new ArrayList<>();

        List<String> keyList = matchAll(regexPattern, html, keyIndex);
        List<String> valueList = matchAll(regexPattern, html, valueIndex);
        if (keyList.size() == valueList.size()) {
            for (int i = 0; i < keyList.size(); i++) {
                Credits credits = new Credits();
                credits.setImdbId(keyList.get(i));
                credits.setName(valueList.get(i));
                list.add(credits);
            }
        }
        return list;
    }
}
