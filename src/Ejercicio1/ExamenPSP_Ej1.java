package Ejercicio1;



public class ExamenPSP_Ej1 extends Thread {

   public ExamenPSP_Ej1(String name) {
        super(name);
  }

    @Override
    public void run() {
        for (int i = 1; i <= 25; i++) {
            System.out.println(i + " : " + getName());
            try {
                sleep((long) (Math.random() * 1000 + 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExamenPSP_Ej1 h1 = new ExamenPSP_Ej1("Hilo1");
        ExamenPSP_Ej1 h2 = new ExamenPSP_Ej1("Hilo2");
        ExamenPSP_Ej1 h3 = new ExamenPSP_Ej1("Hilo3");

        h1.start();
        h2.start();
        h3.start();
        
        h1.join();
        h2.join();
        h3.join();
        
        //Para que el hilo no termine usamos join
        System.out.println("Thread main terminated");
    }
}