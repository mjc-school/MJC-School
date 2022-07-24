1. Start the recording
2. Reactive programming vs reactive systems
    1. We will not discuss reactive systems today
3. Web server concurrency models
    1. Thread per request - default tomcat strategy
    2. Reactive model, based on event loop. Server example is netty
4. Event loop
    1. Some producer pushes jobs that have to be done to some queue
    2. Threads from worker thread pool pull this queue
    3. If the job requires external call (DB / HTTP), thread makes that call and registers callback. Callback is a function that will execute when initial operation finishes
    4. Thread doesn't block, it immediatelly pulls another work
    5. When a call finishes, it executes callback
5. Reactive server
    1. There are few, sometimes 1, server threads. They read requests and push them to the event loop to worker threads
    2. When the job is done, server thread writes response to the client socket
6. Java reactive libraries
    1. RXJava
    2. Project Reactor - integrates with Spring WebFlux
7. Project Reactor internals - 3 main classes
8. Demo
    1. <MainTest class> Go through tests one by one from top to the bottom
    2. <Employee web app> Show Employee class, service and controller. Launch it, make a request to the controller
    3. <ConcurrencyTest class> Run test, it sends 256 requests simultaniously. Requests return after 3 seconds. In tomcat it would take few minutes to execute requests, or you would need 256 threads
9. WebFlux advantages and disadvantages
10. FAQ