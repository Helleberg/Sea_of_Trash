module sdu.seaoftrash.seaoftrash {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens sdu.seaoftrash.seaoftrash to javafx.fxml;
    exports sdu.seaoftrash.seaoftrash;
    exports sdu.seaoftrash.seaoftrash.controller;
    opens sdu.seaoftrash.seaoftrash.controller to javafx.fxml;
}