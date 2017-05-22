package com.mygdx.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Screens.MainMenuScreen;
import com.mygdx.game.Screens.PlayScreen;
import com.mygdx.game.libgdx.libgdx_world;

/**
 * Created by Erik on 16/05/2017.
 */
public class MenuController {

    private MainMenuScreen menu;

    public MenuController(Dash game, libgdx_world world){
        this.menu = new MainMenuScreen(game, world);
        game.setScreen(menu);



    }
    public void handleInput(float dt){
        Gdx.input.setInputProcessor(menu.getStage());
        menu.getStage().getActors().get(0).addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((Dash) Gdx.app.getApplicationListener()).setScreen(new PlayScreen(menu.getGame(), menu.GetWorld()));
            }
        });
        menu.getStage().getActors().get(1).addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });


    }



}
