package az.ingress.ms1relations.claim;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

public interface ClaimProvider {

    Claim provide(Authentication authentication);
}
