package com.marmoush.javasamples.algorithms.misc;

public class Matrix {

  public Double[][] mscale(Double x, Double[][] matrix) {
    for (Double[] vector : matrix)
      for (Double element : vector)
        element *= x;
    return matrix;
  }

  public Double[][] mscale2(Double x, Double[][] matrix) {
    for (Double[] vector : matrix)
      vscale(x, vector);
    return matrix;
  }

  public Double[] vscale(Double x, Double[] vector) {
    for (Double element : vector)
      element *= x;
    return vector;
  }
}
