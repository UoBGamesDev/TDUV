import java.awt.Point;
import java.awt.Rectangle;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Main extends BasicGame {

    private EntityManager entityManager = EntityManager.getEntityManager();

    public Main() {
	super("Hello World");
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
	Player c = new Player();

	entityManager.addEntity(c);

	TiledMap t = new TiledMap("contents/uniTest.tmx");

	entityManager.addEntity(new Map(t));

	entityManager.addEntity(new CollisionEntity());
	
	Camera.setCurrentCamera(new FollowCamera(c, new Rectangle(0, 0, gc
		.getWidth(), gc.getHeight()), new Rectangle(t.getWidth()
		* t.getTileWidth(), t.getHeight() * t.getTileHeight())));
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
	entityManager.update(gc, delta);
    }

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