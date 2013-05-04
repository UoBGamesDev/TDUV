import java.awt.Rectangle;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;

public class Main extends BasicGame {

	private EntityManager entityManager = new EntityManager();
	
	public Main() {
		super("Hello World");
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		entityManager.addEntity(new Character());
		Camera.setCurrentCamera(new StaticCamera(new Rectangle(0, 0, 0, 0)));
		i = new Image("contents/circle.png");
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		entityManager.update(gc, delta);
	}

	private static Image i;
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		Display.sync(30);
		Renderer.flushRenderCache();
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Main());

		app.setDisplayMode(800, 600, false);
		app.start();
	}
}