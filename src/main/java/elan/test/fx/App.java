package elan.test.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class App extends Application {
    private ConfigurableApplicationContext context;


    @Override
    public void init() throws Exception {
        context = new SpringApplicationBuilder(App.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        fxmlLoader.setControllerFactory(context::getBean); // 使用Spring的BeanFactory作为控制器的工厂
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("JavaFX with Spring Boot");
        stage.show();
        context.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop() throws Exception {
        context.close();
        Platform.exit();
    }
    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }
    }
    @Bean
    @Primary
    public FXMLLoader defaultFXMLLoader() {
        return new FXMLLoader();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
