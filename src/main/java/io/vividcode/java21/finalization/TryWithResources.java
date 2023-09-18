package io.vividcode.java21.finalization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResources {

  void copyFile() throws IOException {
    try (var input = new FileInputStream("input.txt");
        var output = new FileOutputStream(
            "output.txt")) {
      input.transferTo(output);
    }
  }
}
