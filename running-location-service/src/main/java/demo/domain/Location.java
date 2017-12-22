package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "LOCATION INFO")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    enum GpsStatus {
        EXCELLENT, OK, UNRELIABLE, BADD, NOFIX, UNKONOWN
    }

    public enum RunnerMovementType {
        STOPPED, IN_MOTION;
        public boolean isMoving() {
            return this != STOPPED;
        }
    }

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @AttributeOverride(name = "bandMake", column = @Column(name = "unit_band_make"))
    private UnitInfo unitInfo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "fmi", column = @Column(name = "medical_fmi")),
            @AttributeOverride(name = "bfr", column = @Column(name = "medical_bfr"))
    })
    private MedicalInfo medicalInfo;

    private double latitude;
    private double longitude;
    private String heading;
    private double gpsSpeed;
    private GpsStatus gpsStatus;
    private double odometer;
    private double totalRunningTime;
    private double totalIdleTime;
    private double totalCalorieBurnt;
    private String address;
    private Date timestamp = new Date();
    private String gearProvider;
    private RunnerMovementType runnerMovementType = RunnerMovementType.STOPPED;
    private String serviceType;

    public Location() {

    }

    @JsonCreator
    public Location(@JsonProperty("runningId")String runningId) {
        this.unitInfo = new UnitInfo(runningId);
    }
    public Location(UnitInfo unitInfo) {
        this.unitInfo = unitInfo;

    }

    public String getRunnintId() {
        return this.unitInfo == null ? null: this.unitInfo.getRunningId();

    }
}
