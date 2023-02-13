/**
 * @since 12/02/2023
 * @author Victor Silva
 */
public class MainArt {
    public static void main(String[] args) {
        Art my_art = new Art(6);

        my_art.ocultarBackground();
        my_art.construirEmCima();

        my_art.mostrarBackground();
        my_art.construirEmCima();
        // my_art.construirEmBaixo();
    }
}