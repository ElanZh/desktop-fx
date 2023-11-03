package elan.test.fx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @FXML
    private Button button;

    @FXML
    private void handleButtonClick() {
        System.out.println("Button clicked!");
    }
}
