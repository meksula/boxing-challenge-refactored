package boxingchallenge.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.File;

@SpringBootApplication(scanBasePackages = "boxingchallenge")
@EnableAspectJAutoProxy
public class BoxingChallengeApplication extends Application {

	private ConfigurableApplicationContext springContext;
	private static Logger log = Logger.getLogger(BoxingChallengeApplication.class);

	private Parent root;

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(BoxingChallengeApplication.class);
		springContext.getAutowireCapableBeanFactory().autowireBean(this);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/start.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		root = fxmlLoader.load();
		log4jRun();
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Boxing challenge");
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	@Override
	public void stop() {
		springContext.stop();
	}

	public static void main(String[] args) {
		launch(BoxingChallengeApplication.class, args);
	}

	private void log4jRun() {
		String config = System.getProperty("user.dir") + File.separator + "src" + File.separator +
				"main" + File.separator + "resources" + File.separator + "log4j.properties";
		PropertyConfigurator.configure(config);
		log.debug("Project by Karol Meksuła");
		log.info("2018");
		log.warn("JavaFX, Spring boot");
	}
}
