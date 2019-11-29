package Ejercicio3;




public class ExamenPSP_Ej1 extends Thread {
    static int cont=2;
    ExamenPSP_Ej1 hilo;

    public ExamenPSP_Ej1(String name) {
        super(name);
    }

    @Override
    public void run() {
        if (cont<=3){
            hilo= new ExamenPSP_Ej1("Hilo"+cont);
            hilo.start();
            cont++;
        }

        for (int i = 1; i <= 25; i++) {
            System.out.println(i + " : " + getName());
            try {
                sleep((long) Math.random() * 1000 + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            yield();
            
            
            
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ExamenPSP_Ej1 h1 = new ExamenPSP_Ej1("Hilo1");
        h1.start();
        h1.join();
        System.out.println("Terminated Thread main");
    }
}