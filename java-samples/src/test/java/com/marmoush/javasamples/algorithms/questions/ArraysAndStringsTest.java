package com.marmoush.javasamples.algorithms.questions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.marmoush.javasamples.algorithms.questions.ArraysAndStrings.anagram;
import static com.marmoush.javasamples.algorithms.questions.ArraysAndStrings.anagram2;

public class ArraysAndStringsTest {
  String s1 = "EtiamdiamdolorsemperinmaurisquisfermentumlobortisrisusAliquameratvolutpatDuisnecorciinterdummaxim" +
              "usquamasuscipitvelitPraesentmetusauguebibendumquisefficituratlobortissitametodioQuisquesi" +
              "tametmiatipsumtemporauctorInsapienliberoviverraidnisiquiseuismoddapibusdolorFusceutullamc" +
              "orpernislNullaaccumsanatveliteudapibusCurabiturultricesiddolorsitametaliquetMaurisrhoncus" +
              "malesuadaleositametaliquamMaurisinnequevitaeorcisodalespellentesqueFusceegetturpisutnunct" +
              "empuscommodoMorbiposuerealiquetliberositametpellentesqueCrasliberoduifaucibusacornarevel" +
              "venenatisnondolorNullamfermentumanteloreminpulvinarurnaimperdietin";
  String s2 = "EtiamdiamdolorsemperinmaurisquisfermentumlobortisrisusAliquameratvolutpatDuisnecorciinterdummaxim" +
              "usquamasuscipitvelitPraesentmetusauguebibendumquisefficituratlobortissitametodioQuisquesi" +
              "tametmiatipsumtemporauctorInsapienliberoviverraidnisiquiseuismoddapibusdolorFusceutullamc" +
              "orpernislNullaaccumsanatveliteudapibusCurabiturultricesiddolorsitametaliquetMaurisrhoncus" +
              "malesuadaleositametaliquamMaurisinnequevitaeorcisodalespellentesqueFusceegetturpisutnunct" +
              "empuscommodoMorbiposuerealiquetliberositametpellentesqueCrasliberoduifaucibusacornarevelv" +
              "enenatisnondolorNullamfermentumanteloreminpulvinarurnaimperdietin";

  @Test
  public void testAnagram() {
    Assertions.assertTrue(anagram(s1.toCharArray(), s2.toCharArray()));
  }

  @Test
  public void testAnagram2() {
    Assertions.assertTrue(anagram2(s1.toCharArray(), s2.toCharArray()));
  }
}
