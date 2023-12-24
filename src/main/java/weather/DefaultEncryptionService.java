package weather;

public class DefaultEncryptionService implements EncryptionService{
    @Override
    public byte[] encrypt(byte[] plainText) {
        return new byte[0];
    }

    @Override
    public byte[] decrypt(byte[] cipherText) {
        return new byte[0];
    }
}
