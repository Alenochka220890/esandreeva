package ru.stqa.alena.sandbox;

public class Point {

  public static void main(String[] args) {

    double x1 = 3;
    double x2 = 9;
    double y1 = 5;
    double y2 = 10;

    System.out.println("Дистанция между точками " + distance(x1, x2, y1, y2));
  }

  public static double distance(double x1,double x2,double y1,double y2) {

    return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

  }
}