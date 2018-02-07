package ot.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppContext.class);

        primaryStage.setTitle("Strategijŏ realnegŏ czasu");
        primaryStage.setResizable(false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("game.fxml"));
        Controller controller = appContext.getBean("controllerService", Controller.class);
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();

        primaryStage.setScene(new Scene(root, 830, 550));
        primaryStage.setOnCloseRequest(e -> controller.onWindowClose());

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
