package io.vividcode.java17to21.simplewebserver;

import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleWebServer {

  public static void main(String[] args) throws IOException {
    Path dir = Files.createTempDirectory("webserver");
    Files.writeString(dir.resolve("index.html"), "<h1>Hello World!</h1>");
    SimpleFileServer.createFileServer(
        new InetSocketAddress(9999),
        dir,
        OutputLevel.INFO
    ).start();
  }
}
