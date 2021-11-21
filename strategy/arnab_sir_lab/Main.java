import java.util.Calendar;

interface Perform {
    int perform_op(int num1, int num2);
}

class add implements Perform{
    @Override
    public int perform_op(int num1, int num2) {
        // TODO Auto-generated method stub
        return num1+num2;
    }
}
class  sub  implements Perform {
    @Override
    public int perform_op(int num1, int num2) {
        // TODO Auto-generated method stub
        return num1-num2;
    }
}



class calculator {
    Perform op;    

    int perform(int num1, int num2){
        return op.perform_op(num1,num2);
    }

    public void setop(Perform op) {
        this.op = op;
    }

}

class Main {
    public static void main(String[] args) {
        calculator cal = new calculator();

        cal.setop(new add());
        System.out.println( cal.perform(1, 2));
        cal.setop(new sub());
        System.out.println(cal.perform(200, 100));



    }
}