import javax.swing.*;
import java.awt.*;

public class TimeDisplay extends DisplayDecorator{
    Display displayComponent;
    JPanel panel;
    LabelPanel labelPanel;
    TimeDisplay(Display display, int width, int height) {
        super(display, width, height);
        displayComponent=display;
    }




    @Override
    public JPanel create() {
        // 레이블을 담을 패널 생성
        panel = displayComponent.create();
        // 레이블 또는 다른 패널이 추가될 때 세로 방향으로 나열되도록 레이아웃 설정
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setMinimumSize(new Dimension(getWidth(), getHeight()));
        panel.setPreferredSize(new Dimension(getWidth(), getHeight()));
        // 문자열을 보일 레이블 생성
        labelPanel = new LabelPanel();
        // 패널에 레이블을 붙임.
        //panel.add(displayComponent.create());
        panel.add(labelPanel.createPanel(getWidth(), getHeight()));
        return panel;
    }

    @Override
    public void show() {
        displayComponent.show();
        System.out.println(java.time.LocalDateTime.now().toString());
        labelPanel.updateText(java.time.LocalDateTime.now().toString());
    }
}
