package ee.jaanusrebane.fingerprint.controller;

import ee.jaanusrebane.fingerprint.service.Identify;
import ee.jaanusrebane.fingerprint.service.Sign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Jaanus Rebane
 */
@RestController
@RequestMapping("/")
public class FingerprintController {

    @Autowired
    private Sign signService;
    @Autowired
    private Identify identifyService;

    @RequestMapping("identify")
    public String identifyFingerprint( @RequestBody byte[] file ) {
        return identifyService.identifyDocumentOwner( file );
    }

    @RequestMapping(value = "fingerprint")
    public byte[] addFingerprint( @RequestParam String key, @RequestBody byte[] file ) throws IOException {
       return signService.signDocument( key, file );
    }

}