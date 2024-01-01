package weather;

import java.util.Date;

public class WeatherDataPacket extends WeatherHeaderPacket {

    private WeatherData weatherData;
    private int batteryLevel;
    private int signalStrength;
    private String deviceStatus;

    public WeatherDataPacket( String deviceId, boolean isEncrypted, WeatherData weatherData, int batteryLevel, int signalStrength, String deviceStatus) {
        this.version = 1;
        this.deviceId = deviceId;
        this.isEncrypted = isEncrypted;
        this.weatherData = weatherData;
        this.batteryLevel = batteryLevel;
        this.signalStrength = signalStrength;
        this.deviceStatus = deviceStatus;
        this.timestamp=new Date().toInstant().toEpochMilli();
    }

    public WeatherDataPacket() {
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
