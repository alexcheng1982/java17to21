package io.vividcode.java17to21.patternmatching.record;

import io.vividcode.java17to21.patternmatching.record.User.Address;
import io.vividcode.java17to21.patternmatching.record.User.Name;

public class MatchUser {

  public void matchUser(Object obj) {
    if (obj instanceof User(
        String username,
        User.Name(
            String firstName,
            String lastName,
            String middleName,
            String title
        ),
        User.Address(
            String addressLine1,
            String addressLine2,
            String city,
            String zipCode
        ),
        User.Address workAddress
    )) {
      System.out.printf("%s %s%n%n%s%n%s%n%s,%s",
          firstName, lastName, addressLine1, addressLine2, city, zipCode);
    }
  }

  public static void main(String[] args) {
    new MatchUser().matchUser(new User(
        "john",
        new Name("John", "Doe", null, null),
        new Address("Some place", "Some street", "City1", "100100"),
        null
    ));
  }
}
