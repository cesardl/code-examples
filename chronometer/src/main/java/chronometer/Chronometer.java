package chronometer;

/**
 *
 * @author cesardiaz
 */
public final class Chronometer implements java.awt.event.ActionListener {

    /**
     * Label where the messages will be written.
     */
    private final OnTimerWorksListener callback;

    private int hour, minute, second;
    private Mode mode;

    public Chronometer(FrameChronometer frame) {
        mode = Mode.UP;

        callback = frame;

        init();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        print();

        switch (mode) {
            case UP:
                up();
                break;

            case DOWN:
                down();
                break;
        }
    }

    private void up() {
        second++;
        if (second == 60) {
            minute++;
            second = 0;
        }
        if (minute == 60) {
            hour++;
        }
    }

    private void down() {
        if (hour == 0 && minute == 0 && second == 0) {
            callback.finishTimerDown();
            return;
        }

        if (hour >= 0) {
            if (minute >= 0) {
                if (second >= 0) {
                    second--;
                }
                if (second == -1) {
                    minute--;
                    second = 59;
                }
            }
            if (minute == -1) {
                hour--;
                minute = 59;
            }
        }
    }

    public void init() {
        hour = minute = second = 0;
        print();
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setStart(String start) {
        String[] values = start.split("\\:");

        hour = Integer.parseInt(values[0]);
        minute = Integer.parseInt(values[1]);
        second = Integer.parseInt(values[2]);

        if (hour == 0 && minute == 0 && second == 0) {
            throw new IllegalArgumentException("Can't set zero values for chronometer in down mode");
        }
    }

    private String addZeroIfNeeded(int i) {
        StringBuilder sb = new StringBuilder();

        if (i < 10) {
            sb.append(0);
        }
        sb.append(i);

        return sb.toString();
    }

    private void print() {
        callback.printTime(String.format("%s : %s : %s", addZeroIfNeeded(hour), addZeroIfNeeded(minute), addZeroIfNeeded(second)));
    }

    interface OnTimerWorksListener {

        void finishTimerDown();

        void printTime(String message);

    }

}
