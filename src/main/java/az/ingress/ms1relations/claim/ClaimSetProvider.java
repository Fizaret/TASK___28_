package az.ingress.ms1relations.claim;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

public interface ClaimSetProvider {

    ClaimSet provide(Authentication authentication);
}
