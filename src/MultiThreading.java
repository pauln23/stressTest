/*
 * Multi-Threading application
 *
 * Nick Paul
 */
import java.util.Random;
import java.util.Scanner;

public class MultiThreading extends Thread
{

    private int id; // thread number

    private static float[] shareddata; // shared data array

    private static int numberOfThreads;

    public MultiThreading(int i, int n)
    {
        id = i;
        numberOfThreads = n;
    }

    /* run method of the thread */
    public void run()
    {

        System.out.println("Thread " + id + " running");
        long t = System.currentTimeMillis()/1000;
        calculate(id, t);
        System.out.println("Thread " + id + " took " + (System.currentTimeMillis()/1000 - t) + " seconds");

    }


    private static void calculate(int id, long t){

        int a;
        Random generator = new Random();

        if (numberOfThreads == 1){

            for (a=0; a < (100000000); a++)
            {
                shareddata[a]=(float)Math.cos(a+Math.sqrt(a*generator.nextDouble()));
            }
        }

        else if (numberOfThreads == 2) {


            if (id==1)
            {

                for (a=0; a < (100000000/2); a++)
                {
                    shareddata[a]=(float)Math.cos(a+Math.sqrt(a*generator.nextDouble()));
                }
            }

            if (id==2)
            {
                for (a=(100000000/2); a < 100000000; a++)
                {
                    shareddata[a]=(float)Math.cos(a+Math.sqrt(a*generator.nextDouble()));
                }

            }

        }

        else if (numberOfThreads == 4) {
            if (id==1)
            {

                for (a=0; a < (100000000/4); a++)
                {
                    shareddata[a]=(float)Math.cos(a+Math.sqrt(a*generator.nextDouble()));
                }
            }

            if (id==2)
            {
                for (a=(100000000/4); a < 50000000; a++)
                {
                    shareddata[a]=(float)Math.cos(a+Math.sqrt(a*generator.nextDouble()));
                }
            }

            if (id==3)
            {
                for (a=(50000000); a < 75000000; a++)
                {
                    shareddata[a]=(float)Math.cos(a+Math.sqrt(a*generator.nextDouble()));
                }
            }

            if (id==4)
            {
                for (a=(75000000); a < 100000000; a++)
                {
                    shareddata[a]=(float)Math.cos(a+Math.sqrt(a*generator.nextDouble()));
                }
            }
        }

    }


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of threads: ");
        final int N = input.nextInt();

        shareddata = new float[100000000];

        System.out.println("Starting Multi-threading...");

        MultiThreading[] thread = new MultiThreading[N];

        for (int i = 0; i < N; i++)
        {
            /* initialise each thread */
            thread[i] = new MultiThreading(i+1,N);
            /* start each thread */
            thread[i].start();
        }
    }
}