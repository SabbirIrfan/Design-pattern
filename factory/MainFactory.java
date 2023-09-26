package factory;

public class MainFactory {

    public static void main(String[] args) {
        // factory fact = new factory();
        // profession proff = fact.getProfession("doctor");

        // proff.print_();

        abstractFactoryproducer absfactproducer = new abstractFactoryproducer();
        
        absfactory fact = absfactproducer.getFact(true);

        profession proff = fact.getProfession("doctor");
        proff.print_();


    }
    
}
