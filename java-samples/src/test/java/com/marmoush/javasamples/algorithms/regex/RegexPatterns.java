package com.marmoush.javasamples.algorithms.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatterns {
  public static final String EMAIL = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
  public static final String WEBSITE = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
  public static final String WEBSITE2 = "[www]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
  // All block comments:
  public static final String allBlockComments = " /\\*(?>(?:(?>[^*]+)|\\*(?!/))*)\\*/ ";
  // Empty block Comment
  public static final String EmptyBlockComment = "/\\*[\\*\\s]+[\\s\\*]+/";
  // Non java doc
  public static final String nonJavaDoc = "/\\*[\\*\\s]+[^*]+\\(non-Javadoc\\)[\\*\\s]+[^*]+[\\s\\*]/";
  // starts with A-Z
  public static final String startsWith = "^[A-Z].*$";

  public static boolean isMatching(String regex, String input) {
    CharSequence inputStr = input;
    Matcher matcher = Pattern.compile(regex, 2).matcher(inputStr);
    return matcher.matches();
  }
}
