package ee.jaanusrebane.fingerprint.service;

import java.io.IOException;

/**
 * @author Jaanus Rebane
 */
public interface Sign {
    byte[] signDocument( String key, byte[] file ) throws Exception;
}
