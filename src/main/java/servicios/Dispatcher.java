package servicios;

import entidades.Director;
import entidades.Empleado;
import entidades.Operador;
import entidades.Supervisor;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Dispatcher extends Thread{

    final int numthreads=10;
    Operador o=new Operador(true);
    Supervisor s=new Supervisor(true);
    Director d=new Director(true);
    Random r = new Random();
    int randomNumber = r.ints(1, 5000, 10000).findFirst().getAsInt();



    public synchronized boolean finalThreads() throws InterruptedException {
        boolean runThreads=false;

            if(o.isLibre()){
                System.out.println(dispatchCall(o));
                o.setLibre(false);
                s.setLibre(true);

            }
            else{

                if(s.isLibre()){
                    System.out.println(dispatchCall(s));
                    s.setLibre(false);
                    d.setLibre(true);

                }
                else{
                    if(d.isLibre()){
                        System.out.println(dispatchCall(d));
                        d.setLibre(false);
                        o.setLibre(true);

                    }
                }
            }



            runThreads=true;


        return runThreads;
    }

    @Override
    public void run(){
        try {
            ejecucion();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void ejecucion() throws InterruptedException{

                finalThreads();
                sleep(500);
                synchronized(this){
                this.notifyAll();

        }
    }



    public String dispatchCall(Empleado empleado) throws InterruptedException {

        if (empleado instanceof Operador && empleado.isLibre()){

            boolean t = empleado.atenderLlamada();

            if(t){

                return "Operador atendió";}


        }else
            if (empleado instanceof Supervisor && empleado.isLibre()){

                boolean t=empleado.atenderLlamada();
                if(t){

                    return "Supervisor atendió";}

            }
            else
            if (empleado instanceof Director && empleado.isLibre()){

                boolean t=empleado.atenderLlamada();
                if(t){

                    return "Director atendió";}

            }
            return "Ninguno atendio";
    }



}
