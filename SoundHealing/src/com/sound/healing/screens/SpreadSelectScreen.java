package com.sound.healing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.sound.healing.AssetLoader;
import com.sound.healing.custom.TopImage;

public class SpreadSelectScreen extends BaseScreen implements Screen {
	private Stage stage;
	private Table table;
	private ScrollPane scroll;
	private Table container;
	private Label label;
	private LabelStyle labelstyle;
	private Skin skin;
	private FreeTypeFontParameter font;
	private TopImage topImage;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		stage.act();
		batch.setProjectionMatrix(camera.combined);
		
	    batch.begin();
    		topImage.draw(batch, 1);
    	batch.end();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		AssetLoader.getInstance().loadSpreadSelect();
		stage = new Stage(WIDTH,HEIGHT);
		stage.clear();
	    Gdx.input.setInputProcessor(stage);

	    
	    buildTopImage();
	   // buildScrollPane();
	    
	    
	    
	}

	private void buildTopImage() {
		topImage = new TopImage("CHOOSE YOUR SPREAD", null, AssetLoader.getInstance().texture_SpreadSelect_Title, 60);
	}

	private void buildScrollPane() {
		table = new Table();
		container = new Table();
		Skin skin = new Skin();
		labelstyle = new LabelStyle();
		label = new Label("CHOOSE YOUR SPREAD", labelstyle);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
