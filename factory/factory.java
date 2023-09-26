package factory;

public class factory implements absfactory{

    public profession getProfession(String proff){
        if(proff.equals("doctor")){
            return new doctor();
        }
        else return new Eng();
    }
}
