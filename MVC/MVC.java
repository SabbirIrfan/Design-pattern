

class students{
    private String rollno;
    private String name;

    public String getrollno()
    {
        return rollno;

    }
    public void setrollno(String rollno){
        this.rollno = rollno;
    }
    public String getname(){
        return this.name;
    }
    public void setname(String name)
    {
        this.name = name;

    }

}

class StudentsView{
    public void display_student_detail(String name, String rollno)
    {
        System.out.println("Student: ");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollno);
    }

}

class student_controller{
    private  students model;
    private StudentsView studentsView;

    student_controller(students stu, StudentsView stuview){
        this.model = stu;
        this.studentsView = stuview;
    }

    public void setstudentname(String name)
    {
        model.setname(name);
    }
    public void setstudentroll(String roll){
        model.setrollno(roll);
    }
    public String getstudentname(){
        return model.getname();

    }
    public String getstudentroll(){
        return model.getrollno();
    }

    public void display_student_detail(){
        studentsView.display_student_detail(model.getname(),model.getrollno());

    }
}


class MVC {
    public static void main(String[] args) {
        
        students student = new students();
        StudentsView view_stu = new StudentsView();
        student_controller controller = new student_controller(student, view_stu);

        controller.setstudentname("sabbir");
        controller.display_student_detail();
        controller.setstudentroll("2017331089");
        controller.display_student_detail();

    }


}