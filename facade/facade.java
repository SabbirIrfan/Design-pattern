import java.util.ArrayList;


class light {
    String name;
    light(String name){
        this.name = name;
    }
    
    void on(){
        System.out.println("light is onn ");
    }
    void off()
    {
        System.out.println("light is off");
    }
}

class fan {
    String name;
    fan(String name){
        this.name = name;
    }
    void start(){
        System.out.println("fan is onn ");
    }
    void stop()
    {
        System.out.println("fan is off");
    }
}

class projector {
    String name;
    projector(String name){
        this.name = name;
    }
    void up(){
        System.out.println("projector is upp");
    }
    void down()
    {
        System.out.println("projector  is down");
    }
}

class facadetest {
    ArrayList<light> lights = new ArrayList<>();
    ArrayList<fan> fans = new ArrayList<>();
    ArrayList<projector> projectors;
    void add_light(light lt){
        lights.add(lt);
    }
    void add_fan(fan fn){
        fans.add(fn);
    }
    void start_class(){
        for(light lt:  lights){
            lt.on();
        }
        for(fan ft:  fans){
            ft.start();
        }

    }
    void stop_class(){
        for(light lt: lights){
            lt.off();
        }
        for(fan ft:  fans){
            ft.stop();
        }
    }
}

class facade {
    public static void main(String[] args) {
        facadetest fd = new facadetest();
        fd.add_light(new light("light1"));
        fd.add_light(new light("light2"));
        fd.add_fan(new fan("fan2"));
        fd.add_fan(new fan("fan1"));
        fd.start_class();
        fd.stop_class();
    }
}