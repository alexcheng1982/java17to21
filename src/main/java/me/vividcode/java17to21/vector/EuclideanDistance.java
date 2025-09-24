package me.vividcode.java17to21.vector;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;
import jdk.incubator.vector.DoubleVector;
import jdk.incubator.vector.VectorOperators;
import jdk.incubator.vector.VectorSpecies;

public class EuclideanDistance {

  static final VectorSpecies<Double> SPECIES = DoubleVector.SPECIES_PREFERRED;

  double distance(double[] a, double[] b) {
    double r = 0;
    for (int i = 0; i < a.length; i++) {
      r += (a[i] - b[i]) * (a[i] - b[i]);
    }
    return Math.sqrt(r);
  }

  double vectorDistance(double[] a, double[] b) {
    double r = 0;
    int upperBound = SPECIES.loopBound(a.length);
    for (int i = 0; i < upperBound; i += SPECIES.length()) {
      var va = DoubleVector.fromArray(SPECIES, a, i);
      var vb = DoubleVector.fromArray(SPECIES, b, i);
      var sub = va.sub(vb);
      r += sub.mul(sub).reduceLanes(VectorOperators.ADD);
    }
    return Math.sqrt(r);
  }

  public static void main(String[] args) {
    var random = ThreadLocalRandom.current();
    int total = 10_000;
    double[] a = new double[total];
    double[] b = new double[total];
    for (int i = 0; i < total; i++) {
      a[i] = random.nextDouble();
      b[i] = random.nextDouble();
    }
    var distance = new EuclideanDistance();
    var ts = System.currentTimeMillis();
    System.out.println(distance.distance(a, b));
    System.out.println(Duration.ofMillis(System.currentTimeMillis() - ts));
    ts = System.currentTimeMillis();
    System.out.println(distance.vectorDistance(a, b));
    System.out.println(Duration.ofMillis(System.currentTimeMillis() - ts));
  }
}
