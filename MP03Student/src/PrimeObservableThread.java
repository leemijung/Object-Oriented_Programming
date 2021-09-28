import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PrimeObservableThread implements Runnable, Subject {
    private static final int SLEEPTIME = 500;


    private int primeNumber;
    private int numCount;
    private boolean first = true;
    private boolean stopRunning = false;

    public ArrayList<Observer> observers;
//    private JPanel JPanel;

    public PrimeObservableThread() {
        observers = new ArrayList<>();
    }

//    public JPanel createPanel(int width, int height) {
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//        JPanel = new JPanel();
//        panel.add(JPanel);
//        panel.setPreferredSize(new Dimension(width, height));
//        return panel;
//    }

    public int getPrimeNumber() {
        return primeNumber;
    }

    public void stopRunning() {
        stopRunning = true;
    }

    public void startRunning() { //Add 버튼 누르면 실행
        stopRunning = false;
        run();
    }

    private void generatePrimeNumber() {
        while (stopRunning == false) {
            if (first) {
                first = false;
                primeNumber = 2;   // 첫 번째 소수는 2
                //System.out.println(primeNumber);
                numCount = 1; // 다음 단계부터는 2를 더해서 홀수만 확인하므로 1로 바꿔서 다음 숫자를 3으로 만들어야 함
            } else {
                numCount += 2; // 2를 제외한 짝수는 소수가 될 수 없음. 따라서 홀수만 검사
                if (isPrimeNumber(numCount)) {
                    primeNumber = numCount;
                    System.out.println(primeNumber);
                    // <이부분에서 옵저버에게 알려줘야함>
                    measurementsChanged();

                }
            }
            try {
                Thread.sleep(SLEEPTIME); // 1초 쉼
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isPrimeNumber(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        generatePrimeNumber();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        System.out.println("registerObserver 들어옴");
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        System.out.println("observers size: " + observers.size());
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(primeNumber);
            System.out.println("noti 들어옴");
        }
    }
}
