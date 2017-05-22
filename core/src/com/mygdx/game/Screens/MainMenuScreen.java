package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Controllers.MenuController;
import com.mygdx.game.Controllers.Dash;
import com.mygdx.game.Screens.MenuSkins.MainMenuSkins;
import com.mygdx.game.Utils.CONSTANTS;
import com.mygdx.game.libgdx.libgdx_world;


/**
 * Created by Erik on 16/05/2017.
 */
public class MainMenuScreen implements Screen {

    private Viewport viewPort;
    private Stage stage;
    private libgdx_world gameWorld;
    private Dash game;
    private MainMenuSkins menuSkins;

    public MainMenuScreen(Dash game, libgdx_world gameWorld) {
        this.game = game;
        this.gameWorld = gameWorld;

        viewPort = new FitViewport(CONSTANTS.WIDTH, CONSTANTS.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewPort, game.batch);

        menuSkins = new MainMenuSkins();

    }

    @Override
    public void show() {


        TextButton newGameButton = new TextButton("New game", menuSkins.getSkins());
        newGameButton.setPosition(CONSTANTS.WIDTH / 2 - CONSTANTS.WIDTH / 8, CONSTANTS.HEIGHT / 2);

        TextButton quitGameButton = new TextButton("Quit game", menuSkins.getSkins());
        quitGameButton.setPosition(CONSTANTS.WIDTH / 2 - CONSTANTS.WIDTH / 8, CONSTANTS.HEIGHT / 2 - CONSTANTS.HEIGHT / 10);

        stage.addActor(newGameButton);
        stage.addActor(quitGameButton);

    }

    public void update(float delta) {
        game.getMC().handleInput(delta);
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    public Stage getStage() {
        return this.stage;
    }
    public libgdx_world GetWorld(){
        return this.gameWorld;
    }
    public Dash getGame(){
        return this.game;
    }
}
