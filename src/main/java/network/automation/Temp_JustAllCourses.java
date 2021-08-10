package network.automation;

public class Temp_JustAllCourses {
    private String year;
    private String semester;
    private String code;
    private String name;
    private double score;
    private String lecturer;

    public Temp_JustAllCourses(String c, String n, double m){
        this.code = c;
        this.name = n;
        this.score = m;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String printDetails(){
        return this.getCode()+", "+this.getName()+", "+this.getLecturer()+", "+this.getScore()+", "+this.getYear()+", "+this.getSemester();
    }
}
