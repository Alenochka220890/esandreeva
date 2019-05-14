package ru.stqa.alena.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests_2 {
  @Test
  public void testDistance() {
    Point p1 = new Point(3, 4);
    Point p2 = new Point(5, 6);
    Assert.assertEquals(p1.distance(p2), 2.8284271247461903);
  }
}
