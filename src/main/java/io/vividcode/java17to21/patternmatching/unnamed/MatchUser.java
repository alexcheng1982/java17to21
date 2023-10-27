package io.vividcode.java17to21.patternmatching.unnamed;

import io.vividcode.java17to21.patternmatching.record.User;

public class MatchUser {

  public void matchUser(Object obj) {
    if (obj instanceof User(
        _,
        User.Name(
            String firstName,
            String lastName,
            _,
            _
        ),
        User.Address(
            String addressLine1,
            String addressLine2,
            String city,
            String zipCode
        ),
        _
    )) {
      System.out.printf("%s %s%n%n%s%n%s%n%s,%s",
          firstName, lastName, addressLine1, addressLine2, city, zipCode);
    }
  }
}
