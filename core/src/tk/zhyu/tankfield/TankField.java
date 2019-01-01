package tk.zhyu.tankfield;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;

import java.util.ArrayList;

import tk.zhyu.tankfield.transition.FadeOutTransitionEffect;
import tk.zhyu.tankfield.transition.TransitionEffect;
import tk.zhyu.tankfield.transition.TransitionScreen;

public class TankField extends Game {

    public AssetManager manager;
    MenuScreen sc;

    @Override
    public void create() {
        manager = new AssetManager();
        Audio.loadAudio();
        Tank.loadAtlas();
        Joystick.initStyle();
        new Buttons().loadAtlas();
        sc = new MenuScreen(this);
        setScreen(sc);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
    }

    @Override
    public void dispose() {
        sc.dispose();
    }

    public void goToScreen(Screen s) {
        ArrayList<TransitionEffect> transitionEffects = new ArrayList<TransitionEffect>();
        transitionEffects.add(new FadeOutTransitionEffect(0.5f));
        TransitionScreen trans = new TransitionScreen(this, getScreen(), s, transitionEffects);
        setScreen(trans);
    }
}
