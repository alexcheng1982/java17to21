java21-charsets:
	docker run --rm --read-only -v ./src/main/java:/root openjdk:21-rc-jdk-bullseye java /root/java21/charset/ShowCharsets.java
java21-charsets-compat:
	docker run --rm --read-only -v ./src/main/java:/root openjdk:21-rc-jdk-bullseye java -Dfile.encoding=COMPAT /root/java21/charset/ShowCharsets.java
java21-charsets-utf8:
	docker run --rm --read-only -v ./src/main/java:/root openjdk:21-rc-jdk-bullseye java -Dfile.encoding=UTF-8 /root/java21/charset/ShowCharsets.java
java17-charsets:
	docker run --rm --read-only -v ./src/main/java:/root eclipse-temurin:17 java /root/java21/charset/ShowCharsets.java