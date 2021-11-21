import java.util.ArrayList;

interface command{
    public void execute();
}


class Light{
    String name;
    boolean status;
    public Light (String name){
        this.name = name;
        status = false;
    }
    void on()
    {
        System.out.println("light is on");
        status = true;
    }
    void off ()
    {
        System.out.println("light is off");
        status = false;
    }
    void set_voltage(String voltge){
        System.out.println("voltage of the light is set to " + voltge);
    }
   
}

class light_command implements command{

    Light light;
    public light_command(Light light)
    {
        this.light = light;
    }

    @Override
    public void execute() {
        if(light.status){
            light.off();
        }
        else{
            light.on();
        }
    }
}


class NullCommand implements command{
    @Override
    public void execute() {
        System.out.println("it is a null command");
    }
}
class remoteController {
    ArrayList<command> button = new ArrayList<>();
    remoteController(int size)
    {
        for (int i=0; i<size; i++)
        {
            button.add(new NullCommand());
        }
    }

    void setcommand(int indx, command cmnd){
        button.set(indx, cmnd);
    }
    void button_pressed(int indx){
        button.get(indx).execute();
    }
   
}
class command_pat{
    public static void main(String[] args) {
        remoteController remote = new remoteController(10);
        Light light1 = new Light("light1");
        Light light2 = new Light("light2");
        command  Light1 = new light_command(light1);
        command Light2 = new light_command(light2);
        remote.setcommand(1, Light1);
        remote.setcommand(2, Light2);
        
        remote.button_pressed(1);
        remote.button_pressed(1);


    }
}
