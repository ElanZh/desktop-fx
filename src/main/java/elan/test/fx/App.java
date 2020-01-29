package elan.test.fx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author 张一然
 * @date 2020/1/29 上午10:50
 */
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Text text = new Text("Hello JavaFX11");
        text.setFont(Font.font("Microsoft YaHei Mono", FontWeight.BOLD, 40));

        HBox hBox = new HBox();
        hBox.setPrefHeight(400);
        hBox.setPrefWidth(400);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(text);

        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.show();
    }
}
