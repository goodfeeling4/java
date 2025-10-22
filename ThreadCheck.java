public class ThreadCheck {
        // Print total thread count
        
        // Get all threads and print their names
        Thread.getAllStackTraces().keySet().forEach(thread -> {
            System.out.println("Thread name: " + thread.getName() + " | State: " + thread.getState());
        });
        System.out.println("Active thread count: " + Thread.activeCount());
    }

public class InnerThreadCheck extends ThreadCheck {
    public static void main(String[] args) {
        ThreadCheck.main(args);
    }

    
}