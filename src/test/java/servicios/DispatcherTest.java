package servicios;

import entidades.Director;
import entidades.Empleado;
import entidades.Operador;
import entidades.Supervisor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DispatcherTest {


    @Test
    public void testDispatchCall() throws InterruptedException {

        Dispatcher dispatcher = new Dispatcher();
        Operador operador = new Operador(true);
        String res=dispatcher.dispatchCall(operador);
        assert(res=="Operador atendió");
    }

    @Test
    public void testDispatchSupervisor() throws InterruptedException {

        Dispatcher dispatcher = new Dispatcher();
        Supervisor s = new Supervisor(true);
        String res=dispatcher.dispatchCall(s);
        assert(res=="Supervisor atendió");
    }

    @Test
    public void testDispatchDirector() throws InterruptedException {

        Dispatcher dispatcher = new Dispatcher();
        Director d = new Director(true);
        String res=dispatcher.dispatchCall(d);
        assert(res=="Director atendió");
    }
    ExecutorService executor = Executors.newFixedThreadPool(10);
    @Test
    public void testMultiples() throws InterruptedException {

        Dispatcher d=new Dispatcher();

        int numthreads=10;
        Runnable worker = new Dispatcher();
        for(int i = 0; i < numthreads; i++ ) {
            executor.execute(worker);
        }
        executor.shutdown();
        // Wait until all threads are finish
        while (!executor.isTerminated()) {

        }
        System.out.println("\nFinished all threads");

    }





}
