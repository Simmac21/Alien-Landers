import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;

import java.util.Random;

/**
 * The Class creates the graphic structure of the Game environment
 *
 * @author Simran Macwan, 000820719
 *
 */

public class GraphicEngine {
    /**
     * object spacing
     */
    private int spacing = 5;
    /**
     * With of the display window
     */
    private double width;

    /**
     * height of the window
     */
    private double height;

    /**
     * RGB color maximum value
     */
    private final int maxVal = 255;

    /**
     * Generated random numbers
     */
    private Random random = new Random(System.currentTimeMillis());

    /**
     * Constructs the graphic of the game environment
     *
     * @param context javafx Graphic context
     * @param width   of display window
     * @param height  of display window
     */
    public GraphicEngine(GraphicsContext context, double width, double height) {
        this.width = width;
        this.height = height;
        //the method creates the sky
        colorGraphicContext(context);
        /**
         * the method creates the mountain
         */
        mountainGenerator(context);
        /**
         * the method creates the alienShip
         */
        double[] seed = new double[]{50, 100, 200, 150, 250};
        for (double d: seed) {
            alienShipAdd(context, d);
        }

    }

    /**
     * Adds the cloud color
     *
     * @param context is javaFX GraphicsContext
     */
    private void colorGraphicContext(GraphicsContext context) {

        context.setFill(Paint.valueOf("#000034"));

        context.fillRect(0, 0, width, height);


        context.setFill(Paint.valueOf("#fff"));
        context.fillPolygon(
                new double[]{10, 40, 40, 10, 10, 20, 10, 25, 40, 30},
                new double[]{10, 10, 40, 40, 10, 40, 50, 40, 50, 40},
                10
        );
    }

    /**
     * Creates the mountain
     *
     * @param context is javaFX GraphicsContext
     */
    private void mountainGenerator(GraphicsContext context) {

        int quaterHeightScene = (int) (height * 0.9);

        context.setFill(Color.rgb(random.nextInt(maxVal), random.nextInt(maxVal), random.nextInt(maxVal), 1));


        context.fillPolygon(
                new double[]{0, width * 0.15, width * 0.3, width * 0.45, width * 0.6, width * 7.5, width * 90, width * 90, 0},
                new double[]{height - 10, height - 175, height - 150,
                        height - 175, height - 50, height - 170, height - 180, height - 120, height},
                9
        );
    }

    /**
     * Creates the alien Ships
     *
     * @param graph is javaFX GraphicsContext
     */
    private void alienShipAdd(GraphicsContext graph, double s) {

        for (int k = 0; k <= 50; k++) {
            int i = random.nextInt(10);
            //double i =Math.random()*-10;
            graph.translate(17+i, 1);
            graph.setFill(Color.rgb(random.nextInt(255), random.nextInt(255),
                    random.nextInt(255), 0.9));
            graph.fillPolygon(
                    new double[]{10, 40, 40, 10, 10, 20, 10, 25, 40, 30},
                    new double[]{10+s*i, 10+s*i, 40+s*i, 40+s*i, 10+s*i, 40+s*i, 50+s*i, 40+s*i, 50+s*i, 40+s*i}, 10
            );

        }
    }

    /**
     * The method help design the name of the mountain
     *
     * @param name is the name of the mountain
     * @return JavaFX Text object containing mountain name
     */
    public Text mountainNameTxt(String name) {
        Text text2 = new Text(200,
                650, name);
        text2.setFont(Font.font("Serif", FontWeight.EXTRA_BOLD,
                FontPosture.REGULAR, 30));
        text2.setFill(Color.RED);
        text2.setFontSmoothingType(FontSmoothingType.LCD);
        DropShadow shadow = new DropShadow();
        shadow.setOffsetX(2.0f);
        shadow.setOffsetY(2.0f);
        shadow.setColor(Color.BLACK);
        shadow.setRadius(7);
        text2.setEffect(shadow);
        text2.setStroke(Color.DARKRED);

        return text2;
    }
}
