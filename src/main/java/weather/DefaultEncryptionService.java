package weather;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DefaultEncryptionService implements EncryptionService{

    private Key key=new SecretKeySpec(new byte[]{0x01,0x02,0x03,0x04,0x05,0x06,0x07,0x08},"AES");

    public DefaultEncryptionService(){

    }
    @Override
    public byte[] encrypt(byte[] plainText){
        try {
            Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
            instance.init(Cipher.ENCRYPT_MODE,key);
            return instance.doFinal(plainText);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] decrypt(byte[] cipherText) {
        try {
            Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
            instance.init(Cipher.DECRYPT_MODE,key);
            return instance.doFinal(cipherText);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
