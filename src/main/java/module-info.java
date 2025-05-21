module miniprojet.projet_v1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens miniprojet.projet_v1 to javafx.fxml;
    exports miniprojet.projet_v1;
}