module xyz.devgrill.snake.register {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires SqlAPI;
    requires java.sql;
    requires font.awesome;
    opens xyz.devgrill.snake to javafx.fxml;
    exports xyz.devgrill.snake.register;
}
