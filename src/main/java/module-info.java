module org.mdolgushev.neomorphism {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.mdolgushev.neomorphism to javafx.fxml;
    exports org.mdolgushev.neomorphism;
}