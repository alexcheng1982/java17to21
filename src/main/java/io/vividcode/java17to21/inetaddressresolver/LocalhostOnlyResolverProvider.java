package io.vividcode.java17to21.inetaddressresolver;

import java.net.spi.InetAddressResolver;
import java.net.spi.InetAddressResolverProvider;

public class LocalhostOnlyResolverProvider extends InetAddressResolverProvider {

  @Override
  public InetAddressResolver get(Configuration configuration) {
    return new LocalhostOnlyResolver(configuration.builtinResolver(),
        configuration.lookupLocalHostName());
  }

  @Override
  public String name() {
    return "localhost-only";
  }
}
