import java.util.ArrayList;

interface functionality_of_magasine{
    public void add_audience(Audience audience);
    public void remove_audience(Audience audience);
    public void change_something();
    public void notifyaudiences(String s);

}
class true_news implements functionality_of_magasine{

    ArrayList<Audience> audiences_list;


    public  true_news(){
        audiences_list = new ArrayList<Audience>();
    }
    
    public void add_audience(Audience audience) {
        // TODO Auto-generated method stub
        try {
            audiences_list.add(audience);  
             System.out.printf("added audiance from <%s> to <%s> \n",audience,this); 
            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("how are u");
        }
        
    }

    @Override
    public void remove_audience(Audience audience) {
        // TODO Auto-generated method stub
        audiences_list.remove(audience);
        
    }


    @Override
    public void notifyaudiences(String s) {
        for(Audience au: audiences_list)
            {
                // System.out.println("updated the arraylist audience with " + s );
                au.update_info(s);
            }
        
    }

    @Override
    public void change_something() {
        // TODO Auto-generated method stub
        System.out.println("we have done some changes in our magasine");
        notifyaudiences("we have done some changes in our magasine");
    }
}
interface Audience {
    public void update_info(String s);
}
class todays_news implements Audience{
    // true_news tr_news;
    // public todays_news(true_news tr_news)
    // {
    //     this.tr_news = tr_news;
    //     // System.out.println("Kkkkk");
    // }
    @Override
    public void update_info(String s) {

        System.out.println("The data is changed with " + s);
    }


}


class magasine {

    public static void main(String[] args) {
        true_news troo_News = new true_news();
        todays_news sabbirs_server = new todays_news();
        
        todays_news irfans_server = new todays_news();

        troo_News.add_audience(sabbirs_server);
        troo_News.add_audience(irfans_server);
        troo_News.change_something();
        troo_News.notifyaudiences("howdy");

        troo_News.remove_audience(irfans_server);

        

    }
}