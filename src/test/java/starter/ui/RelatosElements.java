package starter.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RelatosElements {
    public static Target BUTTON_INICIO = Target.the("Botón inicio de sesión")
            .located(By.xpath("//button[contains(text(), 'Inicio')]"));
    public static Target BUTTON_VER_CARRITO = Target.the("Botón ver carrito de compras")
            .located(By.xpath("//button[contains(text(), 'Mostrar Carrito')]"));
    public static Target BUTTON_VER_DETALLE_LIBRO = Target.the("Botón ver detalle del libro")
            .located(By.xpath("(//button[@id='disponibles'])[5]"));
    public static Target BUTTON_AGREGAR_AL_CARRITO = Target.the("Botón agregar libro al carrito de compras")
            .located(By.cssSelector("#agregar"));
    public static Target TABLE_ROW_CANTIDAD = Target.the("Campo Cantidad en la tabla del carrito")
            .located(By.xpath("//th[contains(text(), 'Cantidad')]"));
}
