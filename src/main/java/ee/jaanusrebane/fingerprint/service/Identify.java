package ee.jaanusrebane.fingerprint.service;

/**
 * @author Jaanus Rebane
 */
public interface Identify {

    String identifyDocumentOwner( byte[] file );
}
