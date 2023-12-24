package weather;

import java.time.ZonedDateTime;
import java.util.Date;

public class WeatherDataPacket {
    private int version;
    private int length;
    private String deviceId;
    private long timestamp;
    private boolean isEncrypted;
    private int checksum;
    private WeatherData weatherData;
    private int batteryLevel;
    private int signalStrength;
    private String deviceStatus;

    public WeatherDataPacket( String deviceId, boolean isEncrypted, WeatherData weatherData, int batteryLevel, int signalStrength, String deviceStatus) {
        this.version = 1;
        this.deviceId = deviceId;
        this.isEncrypted = isEncrypted;
        this.checksum = 0;
        this.weatherData = weatherData;
        this.batteryLevel = batteryLevel;
        this.signalStrength = signalStrength;
        this.deviceStatus = deviceStatus;
        this.timestamp=new Date().toInstant().toEpochMilli();
    }

    public WeatherDataPacket() {
    }

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

    public int getChecksum() {
        return checksum;
    }

    public void setChecksum(int checksum) {
        this.checksum = checksum;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public int getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(int signalStrength) {
        this.signalStrength = signalStrength;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    // Constructor, getters, setters, and potentially a method to serialize the object

    public static class WeatherData {
        private long timestamp;
        private float temperature;
        private int humidity;
        private int windSpeed;
        private int pressure;

        public WeatherData() {
        }

        public WeatherData(long timestamp, float temperature, int humidity, int windSpeed, int pressure) {
            this.timestamp = timestamp;
            this.temperature = temperature;
            this.humidity = humidity;
            this.windSpeed = windSpeed;
            this.pressure = pressure;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public float getTemperature() {
            return temperature;
        }

        public void setTemperature(float temperature) {
            this.temperature = temperature;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public int getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(int windSpeed) {
            this.windSpeed = windSpeed;
        }

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }
        // Constructor, getters, setters
    }
    
    // Additional methods to serialize/deserialize the object
}
