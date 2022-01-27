import com.car.parking.worker.ProcessWorker;

public class Application {
    public static void main(String[] args) {
        ProcessWorker worker = new ProcessWorker();
        try {
            worker.doStart();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
