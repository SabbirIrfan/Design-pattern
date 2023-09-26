package factory;

public class abstractFactoryproducer{

    public absfactory getFact(boolean isTrainee){
        if(isTrainee) return new TraineeFactory();
        else return new factory();

    }
}
