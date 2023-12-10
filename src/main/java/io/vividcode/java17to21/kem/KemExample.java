package io.vividcode.java17to21.kem;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import javax.crypto.KEM;
import javax.crypto.SecretKey;

public class KemExample {

  private final KeyPair keyPair;

  KemExample() throws NoSuchAlgorithmException {
    keyPair = KeyPairGenerator.getInstance("X25519").generateKeyPair();
  }

  byte[] send() throws Exception {
    KEM kem = KEM.getInstance("DHKEM");
    KEM.Encapsulator e = kem.newEncapsulator(keyPair.getPublic());
    KEM.Encapsulated enc = e.encapsulate();
    outputKey(enc.key());
    return enc.encapsulation();
  }

  SecretKey receive(byte[] data) throws Exception {
    KEM kem = KEM.getInstance("DHKEM");
    KEM.Decapsulator d = kem.newDecapsulator(keyPair.getPrivate());
    return d.decapsulate(data);
  }

  void outputKey(SecretKey key) {
    System.out.println(HexFormat.of().formatHex(key.getEncoded()));
  }

  public static void main(String[] args) throws Exception {
    var example = new KemExample();
    var key = example.receive(example.send());
    example.outputKey(key);
  }
}
