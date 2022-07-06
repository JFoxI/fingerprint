package ee.jaanusrebane.fingerprint.service.impl;

import ee.jaanusrebane.fingerprint.service.Identify;
import ee.jaanusrebane.fingerprint.util.EncodeMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class IdentifyImpl implements Identify {

    @Override
    public String identifyDocumentOwner( byte[] file ) {
        String result;
        String text =  new String( file );
        String[] documentWithSignatureModified = text.split("%C2%A0");
        String[] documentWithSignatureUnmodified = text.split("\u00A0");
        if (documentWithSignatureModified.length > 1) {
            result = EncodeMapper.decodeModifiedText( documentWithSignatureModified[1] );
        } else if ( documentWithSignatureUnmodified.length > 1) {
            result = EncodeMapper.decodeText( documentWithSignatureUnmodified[1] );
        } else {
            result = "Signature not found";
        }
        return result;
    }

}
