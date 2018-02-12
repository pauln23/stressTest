# stressTest
A simple stress test. The aim of multi- threading is to share and distribute the processing over several CPU cores in 
order to reduce the overall processing time.

This program splits calculations up and allows you to enter number of threads to split the processing up. 

4 threads = 4 cores. Any more will impact speed negitively as only one thread per core is allowed.

Example is shown below.

Data capture 

Threads      
1             
2              
4             

Time To Complete (sec)
46

24

14

Analysis 

The efficiency is significantly improved when processing the data in parallel.With each additional thread added 
that works to populate the array with the data calculations, the time is about halved. 
From one thread to two threads, it falls almost exactly half the time, and this makes sense as you are dividing the processing
power up evenly between cores. The same can be said from two threads to four threads. The work is divided up in half 
between another two cores, and it is almost halved as well. Since a single thread can be running on each core, the time 
will decrease up to four cores, in which it will start to pick back up as you create more threads than the CPU is handling 
at once. The potential limits for parallel processing are that you cannot increase the speed tasks will complete with a set
number of parallel processes with the same processor. Amdahl’s law states that the more processing power you have the faster 
the tasks will complete. However, you cannot decrease the power and somehow increase the speed. 
