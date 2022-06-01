## Monitoring Java Apps

* Why monitoring is needed
    * Monitoring is the systematic process of collecting, analyzing and using information
    * Understanding what happens inside your app lets you to optimize your code and understand the root causes of the bugs
* Different types of monitoring tools
    * Local monitoring - UI tools. There are a lot of them, we'll take a look at 3 most common
    * Server-side monitoring - often don't have any graphical output, support only command line
* Sample apps overview
    * Deadlock 
    * GC spammer
    * Memory leak
* UI tools
    * VisualVM
        * <GCSpammer> connect to an app on the left
        * Monitor tab
            * CPU & GC graph, GC is considered normal when on average it's about 2%
        * Threads tab
        * Sampler
            * CPU 
            * Memory
        * <MemoryLeak> Heap dump (on Monitor)
        * <Deadlock> Thread dump - what each thread is doing right now
        * Plugins
    * JMC
        * <GCSpammer> Flight recorder example
    * JMX intro
        * It's a standard API for management and monitoring of resources (applications, devices, JVM)
        * JMX agent consists of server and a collection of MBeans. MBeans register on a server, which allows external tools to access their properties
        * There are different types of MBeans, we'll not dig into them. In short, they are simple Java classes with readable and/or updatable properties
        * JDK has it's own default set of MBeans, but you can create your own
    * JConsole & JMC
        * <GCSpammer> JMX
            * Runtime - read-only properties
            * GarbageCollector/G1 Young gen - properties update over time
            * MemoryPool/G1 Eden space - updatable property, operation
        * JConsole - all tabs, shortly
* <GCSpammer> CLI tools
    * `jps` - to see Process ID (unique process identifier in your OS)
    * `jmap`
        * `-histo | select -first 20 <pid>`
        * `-dump:live,format=b,file=filename.hprof <pid>`
    * `jstack <pid>` - same format as in VisualVM
    * `jstat -gcnew <pid> <interval> <sample count>`
    * `jcmd`
        * `32812 GC.class_histogram | select -first 10`
        * `32812 JFR.start`, `32812 JFR.dump filename=someFileName.jfr`
