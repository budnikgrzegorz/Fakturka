package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.stage = primaryStage;

//        SessionFactory sessionFactory = SessionFactoryManager.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();

        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Index.fxml"));
            Scene scene = new Scene(root, 400, 400);
            primaryStage.setTitle("Faktura");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return stage;
    }




}
