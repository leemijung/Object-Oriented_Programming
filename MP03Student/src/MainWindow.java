import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends FrameWindow implements ActionListener {
    private static final String MAIN_TITLE = "Main Window";
    private static final String TEXTFIELD_WINDOW_TITLE = "TextField Window";
    private static final String LABEL_WINDOW_TITLE = "Label Window";
    private static final String TEXTFIELD_OBSERVER_BUTTON_TITLE = "Add TextField Window Observer";
    private static final String LABEL_OBSERVER_BUTTON_TITLE = "Add Label Window Observer";
    private static final String STOP_THREAD_BUTTON_TITLE = "Stop Generating Prime Number";
    private static final int X = 250;
    private static final int Y = 100;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 200;
    private static final int GAP = 50;

    private static final String TEXTFIELD_REMOVE_BUTTON_TITLE = "Remove TextField Window Observer";
    private static final String LABEL_REMOVE_BUTTON_TITLE = "Remove Label Window Observer";

    private JButton stopButton;
    private JButton updateTextFieldObserverButton;
    private JButton updateLabelObserverButton;
    private PrimeObservableThread primeThread;
    private TextFieldWindow textFieldWindow;
    private LabelWindow labelWindow;

    private Observer observer1;
    private Observer observer2;

    private boolean textFieldObserverRemoved=true;
    private boolean labelObserverRemoved=true;


    public MainWindow(String title) {
        super(title, X, Y, WIDTH, HEIGHT);

        observer1 = new TextFieldWindow(TEXTFIELD_WINDOW_TITLE, X, Y + HEIGHT + GAP, WIDTH, HEIGHT);
        observer2 = new LabelWindow(LABEL_WINDOW_TITLE, X, Y + (HEIGHT + GAP) * 2, WIDTH, HEIGHT);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                primeThread.stopRunning();
                observer1.closeWindow();
                observer2.closeWindow();
                System.exit(0);
            }
        });

        primeThread = new PrimeObservableThread();

        primeThread.run();
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(width, height));
        updateTextFieldObserverButton = createButton(TEXTFIELD_OBSERVER_BUTTON_TITLE, this, width, height);
        panel.add(updateTextFieldObserverButton);
        updateLabelObserverButton = createButton(LABEL_OBSERVER_BUTTON_TITLE, this, width, height);
        panel.add(updateLabelObserverButton);
        stopButton = createButton(STOP_THREAD_BUTTON_TITLE, this, width, height);
        panel.add(stopButton);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //옵저버가 추가되어있을 때는 지워주는 로직이 필요
        //옵저버가 제거되어있을 때는 추가해주는 로직이 필요
        if (e.getSource() == updateTextFieldObserverButton) {
            if(textFieldObserverRemoved){
                System.out.println("옵저버가 제거되어있었음"+primeThread.observers.indexOf(observer1));

                textFieldObserverRemoved=false;
                primeThread.registerObserver(observer1);
                //observer1.update(primeThread.getPrimeNumber());
                updateTextFieldObserverButton.setText(TEXTFIELD_REMOVE_BUTTON_TITLE);
            }
            else{
                System.out.println("옵저버가 추가되어있었음"+primeThread.observers.indexOf(observer1));

                textFieldObserverRemoved=true;
                primeThread.removeObserver(observer1);
                updateTextFieldObserverButton.setText(TEXTFIELD_OBSERVER_BUTTON_TITLE);
            }
        }
        else if (e.getSource() == updateLabelObserverButton) {
            if(labelObserverRemoved){
                System.out.println("옵저버가 제거되어있었음"+primeThread.observers.indexOf(observer2));

                labelObserverRemoved=false;
                primeThread.registerObserver(observer2);
                //observer2.update(primeThread.getPrimeNumber());
                updateLabelObserverButton.setText(LABEL_REMOVE_BUTTON_TITLE);
            }
            else{
                System.out.println("옵저버가 추가되어있었음"+primeThread.observers.indexOf(observer2));

                labelObserverRemoved=true;
                primeThread.removeObserver(observer2);
                updateLabelObserverButton.setText(LABEL_OBSERVER_BUTTON_TITLE);
            }
        }

        if (e.getSource() == stopButton) {
            primeThread.stopRunning();
        }
    }

    private JButton createButton(String text, ActionListener listener, int width, int height) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        Dimension buttonDimension = new Dimension(width, height / 3);
        button.setMaximumSize(buttonDimension);
        button.setMinimumSize(buttonDimension);
        button.setPreferredSize(buttonDimension);
        return button;
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow(MainWindow.MAIN_TITLE);
    }
}
