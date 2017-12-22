package demo.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Random;

@Entity
@Data
@Table(name = "RUNNING_ANALYSIS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RunningInfo {
    @Id
    private String runningId;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate;
    private Date timestamp;
    private String userName;
    private String address;
    enum HealthWarningLevel{
        LOW, NORMAL, HIGH;
    }
    private HealthWarningLevel healthWarningLevel;

    public RunningInfo() {

    }

    @JsonCreator
    public RunningInfo(
            @JsonProperty("runningId") String runningId,
            @JsonProperty("latitude") String latitude,
            @JsonProperty("longitude") String longitude,
            @JsonProperty("runningDistance") String runningDistance,
            @JsonProperty("totalRunningTime") String totalRunningTime,
            @JsonProperty("heartRate") int heartRate,
            @JsonProperty("timestamp") Date timestamp,
            @JsonProperty("username") String username,
            @JsonProperty("address") String address) {

        this.runningId = runningId;
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
        this.runningDistance = Double.parseDouble(runningDistance);
        this.totalRunningTime = Double.parseDouble(totalRunningTime);
        this.userName = username;
        this.address = address;

        if (heartRate == 0) {
            Random rand = new Random();
            this.heartRate = rand.nextInt(140)+60;
        }

        this.timestamp = timestamp == null? new Date():timestamp;

        if (this.heartRate >= 60 && this.heartRate <= 75) {
            healthWarningLevel = HealthWarningLevel.LOW;
        }
        else if (heartRate > 75 && heartRate <= 120) {
            healthWarningLevel = HealthWarningLevel.NORMAL;
        }
        else {
            healthWarningLevel = HealthWarningLevel.HIGH;
        }
    }
}
