package com.example.ateliereducatif.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MathQuiz {
  static final int MINIMUM = 1;
  static final int MAXIMUM = 9;
  private String question;
  private int reponse;
  private String operateur;

  public Integer[] getListeReponse() {
    return listeReponse;
  }

  public void setListeReponse(Integer[] listeReponse) {
    this.listeReponse = listeReponse;
  }

  private Integer[] listeReponse;

  public String getOperateur() {
    return operateur;
  }

  public void setOperateur(String operateur) {
    this.operateur = operateur;
  }

  public int getReponse() {
    return reponse;
  }

  public void setReponse(int reponse) {
    this.reponse = reponse;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getQuestion() {
    return this.question;
  }

  public void genererQuestion() {
    String[] operateur = new String[3];
    operateur[0] = "+";
    operateur[1] = "-";
    operateur[2] = "X";
    Random rand = new Random();
    int randomNum1 = MINIMUM + rand.nextInt((MAXIMUM - MINIMUM) + 1);
    int randomNum2 = MINIMUM + rand.nextInt((MAXIMUM - MINIMUM) + 1);
    if(randomNum1 == randomNum2) {
      randomNum1 = MINIMUM + rand.nextInt((MAXIMUM - MINIMUM) + 1);
      randomNum2 = MINIMUM + rand.nextInt((MAXIMUM - MINIMUM) + 1);
    }
    int randomOperateur = 0 + rand.nextInt((2 - 0) + 1);
    String operateurTratra = operateur[randomOperateur];

    this.setOperateur(operateurTratra);
    Integer[] listeReponseHafa;
    listeReponseHafa = new Integer[4];
    listeReponseHafa = this.convertIntegers(this.getRandomNonRepeatingIntegers(4, MINIMUM, MAXIMUM));
    if(operateurTratra.compareTo("+") == 0) {
      this.setReponse(randomNum1+randomNum2);
    } else if(operateurTratra.compareTo("-") == 0) {
      if(randomNum1 < randomNum2) {
        randomNum1 = randomNum2;
        randomNum2 = randomNum1;
      }
      this.setReponse(randomNum1 - randomNum2);
    } else {
      int reponseMulti = randomNum1*randomNum2;
      if(reponseMulti > 4) {
        listeReponseHafa[0] = reponseMulti - 2;
        listeReponseHafa[1] = reponseMulti - 1;
        listeReponseHafa[2] = reponseMulti - 4;
      }
      this.setReponse(reponseMulti);
    }
    this.setQuestion(""+ randomNum1 + " "+operateurTratra+" " + randomNum2 + " = ?");
    listeReponseHafa[3] = this.getReponse();
    Collections.shuffle(Arrays.asList(listeReponseHafa));
    System.out.println(Arrays.toString(listeReponseHafa));
    this.setListeReponse(listeReponseHafa);
  }

  public MathQuiz() {
  }

  public static ArrayList<Integer> getRandomNonRepeatingIntegers(int size, int min,
                                                        int max) {
    ArrayList<Integer> numbers = new ArrayList<>();
    Random random = new Random();
    while (numbers.size() < size) {
      //Get Random numbers between range
      int randomNumber = random.nextInt((max - min) + 1) + min;
      //Check for duplicate values
      if (!numbers.contains(randomNumber)) {
        numbers.add(randomNumber);
      }
    }

    return numbers;
  }
  public static Integer[] convertIntegers(ArrayList<Integer> integers)
  {
    Integer[] ret = new Integer[integers.size()];
    for (int i=0; i < ret.length; i++)
    {
      ret[i] = integers.get(i).intValue();
    }
    return ret;
  }
}
