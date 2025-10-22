public class Student {
    private Integer id;
    private String name;
    private Double cgpa;
    private Boolean active;
    private Department dept;

    public Student(Integer id, String name, Double cgpa, Boolean active, Department dept) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
        this.active = active;
        this.dept = dept;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getCgpa() { return cgpa; }
    public void setCgpa(Double cgpa) { this.cgpa = cgpa; }

    public Boolean isActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public Department getDept() { return dept; }
    public void setDept(Department dept) { this.dept = dept; }
}
