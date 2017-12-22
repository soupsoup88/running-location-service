package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicalInfo {
    private int bfr;
    private int fmi;

    public MedicalInfo() {

    }

    public MedicalInfo(int brf, int fmi) {
        this.bfr = bfr;
        this.fmi = fmi;
    }
}
