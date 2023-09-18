package io.vividcode.java17to21.inetaddressresolver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.spi.InetAddressResolver;
import java.util.stream.Stream;

public class LocalhostOnlyResolver implements InetAddressResolver {

  private final InetAddressResolver delegate;
  private final String localhostName;

  public LocalhostOnlyResolver(InetAddressResolver delegate, String localhostName) {
    this.delegate = delegate;
    this.localhostName = localhostName;
  }

  @Override
  public Stream<InetAddress> lookupByName(String host, LookupPolicy lookupPolicy)
      throws UnknownHostException {
    return delegate.lookupByName(localhostName, lookupPolicy);
  }

  @Override
  public String lookupByAddress(byte[] addr) throws UnknownHostException {
    return delegate.lookupByAddress(addr);
  }
}
