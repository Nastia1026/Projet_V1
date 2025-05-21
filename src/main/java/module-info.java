module miniprojet.projet_v1.model {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens miniprojet.projet_v1.model to javafx.fxml;
    exports miniprojet.projet_v1.model;

}