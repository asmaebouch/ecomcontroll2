package ma.securetest.securetest;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class GenerateKayPair {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA")
;
        var keyPair=keyPairGenerator.generateKeyPair();
        byte[] pub=keyPair.getPublic().getEncoded();
        byte[] pri = keyPair.getPrivate().getEncoded();
       // PemWriter pemWriter =new PemWriter(new OutputStreamWriter(new FileOutputStream("pub.pem")));
        //PemObjet
    }
}
