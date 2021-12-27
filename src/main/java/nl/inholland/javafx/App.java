package nl.inholland.javafx;

        import javafx.application.Application;
        import javafx.stage.Stage;
        import nl.inholland.javafx.ui.LoginScreen;
        import nl.inholland.javafx.ui.MainWindow;

public class App  extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // rendering the text more crisply
        System.setProperty("prism.lcdtext", "false");

        // open login window
        //LoginScreen login = new LoginScreen();
        //login.getStage().show();

        // open the main window
        MainWindow mw = new MainWindow();
        mw.getStage().show();
    }
}