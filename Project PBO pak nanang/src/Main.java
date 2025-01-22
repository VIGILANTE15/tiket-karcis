import javax.swing.*;

import view.ParkingView;
import controllers.ParkingController;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ParkingView view = new ParkingView();
            new ParkingController(view);
            view.setVisible(true);
        });
    }
}
