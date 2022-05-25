package com.ias.SemilleroHandyman.technicalRequest.application.models;

public class TechinicalResquestHoursDTO {

    private Integer normal;
    private Integer normalExtras;
    private Integer nocturnal;
    private Integer nightExtras;
    private Integer Sundays;
    private Integer sundayExtras;

    public TechinicalResquestHoursDTO() {
        normal = 0;
        normalExtras = 0;
        nocturnal = 0;
        nightExtras = 0;
        Sundays = 0;
        sundayExtras = 0;
    }

    public Integer getNormal() {
        return normal;
    }

    public void setNormal(Integer normal) {
        this.normal = normal;
    }

    public Integer getNormalExtras() {
        return normalExtras;
    }

    public void setNormalExtras(Integer normalExtras) {
        this.normalExtras = normalExtras;
    }

    public Integer getNocturnal() {
        return nocturnal;
    }

    public void setNocturnal(Integer nocturnal) {
        this.nocturnal = nocturnal;
    }

    public Integer getNightExtras() {
        return nightExtras;
    }

    public void setNightExtras(Integer nightExtras) {
        this.nightExtras = nightExtras;
    }

    public Integer getSundays() {
        return Sundays;
    }

    public void setSundays(Integer sundays) {
        Sundays = sundays;
    }

    public Integer getSundayExtras() {
        return sundayExtras;
    }

    public void setSundayExtras(Integer sundayExtras) {
        this.sundayExtras = sundayExtras;
    }

    @Override
    public String toString() {
        return "\"hoursWorked\" : {" +
                "\"normal\":" + normal +
                ", \"normalExtras\":" + normalExtras +
                ", \"nocturnal\":" + nocturnal +
                ", \"nightExtras\":" + nightExtras +
                ", \"Sundays\":" + Sundays +
                ", \"sundayExtras\":" + sundayExtras +
                "}";
    }
}
