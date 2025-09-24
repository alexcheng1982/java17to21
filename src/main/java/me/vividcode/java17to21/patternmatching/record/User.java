package me.vividcode.java17to21.patternmatching.record;

public record User(String username,
                   Name name,
                   Address homeAddress,
                   Address workAddress) {

  public record Name(String firstName,
                     String lastName,
                     String middleName,
                     String title) {

  }

  public record Address(String addressLine1,
                        String addressLine2,
                        String city,
                        String zipCode) {

  }
}
