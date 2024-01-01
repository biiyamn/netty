package weather;

public interface EncryptionService {
    byte[] encrypt(byte[] plainText);
    byte[] decrypt(byte[] cipherText);
}
