package com.marmoush.javasamples.algorithms.crackingcodeinterview;

import java.util.HashMap;

public class TrieNode {
  private HashMap<Character, TrieNode> children;
  private String content;
  private boolean isWord;
}
