package network.automation;

public class Temp_RunningCourse {
    private String code, name, lecturer, venue, day, time;

    public Temp_RunningCourse(String code, String name, String lecturer, String venue){
        this.code = code;
        this.name = name;
        this.lecturer = lecturer;
        this.venue = venue;//temporary
        this.day = "--";//temporary, not scrabed
        this.time = "--";//temporary, not scrabed
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetails(){
        return "["+this.getCode()+", "+this.getName()+", "+this.getLecturer()+", "+this.getVenue()+", "+this.getDay()+"/"+this.getTime()+"]";
    }
}
