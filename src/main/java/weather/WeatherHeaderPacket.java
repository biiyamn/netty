package weather;

public class WeatherHeaderPacket {
    protected int version;
    protected int length;
    protected String deviceId;
    protected long timestamp;
    protected boolean isEncrypted;
    protected byte[] encryptedPayload;
    protected byte[] plaintextPayload;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isEncrypted() {
        return isEncrypted;
    }

    public void setEncrypted(boolean encrypted) {
        isEncrypted = encrypted;
    }

    public byte[] getEncryptedPayload() {
        return encryptedPayload;
    }

    public void setEncryptedPayload(byte[] encryptedPayload) {
        this.encryptedPayload = encryptedPayload;
    }

    public byte[] getPlaintextPayload() {
        return plaintextPayload;
    }

    public void setPlaintextPayload(byte[] plaintextPayload) {
        this.plaintextPayload = plaintextPayload;
    }
}
