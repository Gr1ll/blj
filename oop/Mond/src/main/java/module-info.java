module xyz.devgrill.mond {
    requires javafx.controls;
    requires javafx.fxml;


    opens xyz.devgrill.mond to javafx.fxml;
    exports xyz.devgrill.mond;
}