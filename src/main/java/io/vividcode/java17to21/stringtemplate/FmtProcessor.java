package io.vividcode.java17to21.stringtemplate;

import static java.util.FormatProcessor.FMT;

import java.time.LocalDate;
import java.util.FormatProcessor;
import java.util.Locale;

public class FmtProcessor {

  void useFmt() {
    var x = 100;
    var y = 200;
    var result = FMT. "%4d\{ x } + %4d\{ y } = %4d\{ x + y }" ;
    System.out.println(result);
  }

  void locale() {
    var fmt = FormatProcessor.create(Locale.CHINESE);
    var date = LocalDate.now();
    var result = fmt. "%1$tY\{ date } %1$tB\{ date } %1$td\{ date }, %1$tA\{ date }" ;
    System.out.println(result);
  }

  public static void main(String[] args) {
    FmtProcessor processor = new FmtProcessor();
    processor.useFmt();
    processor.locale();
  }
}
