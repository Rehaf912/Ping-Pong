package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Ball;
import my_project.model.House;
import my_project.model.Paddle;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern.
 * Hinweise:
 * - Der Konstruktor sollte nicht geändert werden.
 * - Sowohl die startProgram()- als auch die updateProgram(...)-Methoden müssen vorhanden sein und ihre Signatur sollte
 *   nicht geändert werden
 * - Zusätzliche Methoden sind natürlich gar kein Problem
 */
public class ProgramController {
    //Attribute


    // Referenzen
    private final ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Paddle paddle;
    private Ball ball;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     *
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController) {
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen. Hier sollte also alles geregelt werden,
     * was zu diesem Zeipunkt passieren muss.
     */
    public void startProgram() {
        // Erstelle ein Objekt der Klasse House und initialisiere damit die Referenz house1
        paddle = new Paddle(10, 350);
        ball = new Ball(350, 350);
        // Teile dem ViewController-Objekt mit, dass das House-Objekt gezeichnet werden soll
        viewController.draw(paddle);
        viewController.register(paddle);
        viewController.draw(ball);
        viewController.register(ball);

    }

    /**
     * Diese Methode wird vom ViewController-Objekt automatisch mit jedem Frame aufgerufen (ca. 60mal pro Sekunde)
     *
     * @param dt Zeit seit letztem Frame in Sekunden
     */
    public void updateProgram(double dt) {
        if (paddle != null) paddle.update(dt);
        if (ball != null) ball.update(dt);
        if(ball.getX() - ball.getRadius() <= paddle.getX() + paddle.getWidth()){
            if(ball.getY() >= paddle.getY() && ball.getY() <= paddle.getY() + paddle.getHeight()){
                ball.setVx(-ball.getVx());
            }
        }
    }
}
