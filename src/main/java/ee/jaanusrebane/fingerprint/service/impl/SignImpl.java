package ee.jaanusrebane.fingerprint.service.impl;

import ee.jaanusrebane.fingerprint.service.Sign;
import ee.jaanusrebane.fingerprint.util.EncodeMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * @author Jaanus Rebane
 */
@Service
@Transactional
public class SignImpl implements Sign {

    @Override
    public byte[] signDocument(String key, byte[] file) throws IOException {
        String text =  new String(file, StandardCharsets.UTF_8);
        String[] documentWithSignatureModified = text.split("%C2%A0");
        String[] documentWithSignatureUnmodified = text.split("\u00A0");
        if (documentWithSignatureModified.length > 1 || documentWithSignatureUnmodified.length > 1) {
            throw new RuntimeException("Document is inappropriate for process");
        }
        if (text.startsWith("key=")) {
            text = removeRedundantText( text, key );
        }
        text = text + EncodeMapper.encodeText(key.toLowerCase());
        File tempFile = new File("src/main/resources/temp/temp.tmp");
        java.nio.file.Files.copy(
                new ByteArrayInputStream(text.getBytes()),
                tempFile.toPath(),
                StandardCopyOption.REPLACE_EXISTING);

        return Files.readAllBytes(tempFile.toPath());
    }

    private String removeRedundantText(String text, String key) {
        String redundantText = "key=" + key + "&";
        text = text.replaceAll(redundantText, "");
        text = text.replaceAll("%21", "!");
        text = text.replaceAll("%0A", "\n");
        text = text.replaceAll("%2C", ",");
        text = text.replaceAll("%3A", ":");
        text = text.replaceAll("%28", "(");
        text = text.replaceAll("%29", ")");
        text = text.replaceAll("%09", "\t");
        text = text.replaceAll("%C3%B5", "õ");
        text = text.replaceAll("%C3%95", "Õ");
        text = text.replaceAll("%C3%A4", "ä");
        text = text.replaceAll("%C3%84", "Ä");
        text = text.replaceAll("%C3%B6", "ö");
        text = text.replaceAll("%C3%96", "Ö");
        text = text.replaceAll("%C3%BC", "ü");
        text = text.replaceAll("%C3%9C", "Ü");
        text = text.replaceAll("=", "");
        text = text.replaceAll("\\+", " ");
        return text;
    }
}
