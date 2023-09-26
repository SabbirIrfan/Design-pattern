package factory;

public class TraineeFactory implements absfactory{
    public profession getProfession(String proff) {
     if(proff.equals("doctor"))   return new trainedoc();
     else return new traineeEng();
    }
}
