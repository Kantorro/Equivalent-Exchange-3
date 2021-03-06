package com.pahimar.ee3.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

import org.lwjgl.opengl.GL11;

import com.pahimar.ee3.lib.Sprites;
import com.pahimar.ee3.tileentity.TileAludel;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Equivalent-Exchange-3
 * 
 * ModelAludel
 * 
 * @author pahimar
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
@SideOnly(Side.CLIENT)
public class ModelAludel extends ModelBase {

    private static final int TEXTURE_HEIGHT = 128;
    private static final int TEXTURE_WIDTH = 128;

    private float scale;

    private ModelRenderer baseStand, northStand, southStand, eastStand, westStand;
    private ModelRenderer bottomBulb, topBulb;
    private ModelRenderer chute;

    public ModelAludel(float scale) {

        this.scale = scale;
        textureHeight = TEXTURE_HEIGHT;
        textureWidth = TEXTURE_WIDTH;

        baseStand = new ModelRenderer(this, 0, 36);
        baseStand.setRotationPoint(8F, 1F, 8F);
        northStand = new ModelRenderer(this, 0, 36);
        northStand.addBox(-3.5F, -1F, -1F, 7, 2, 2);
        northStand.setRotationPoint(4.5F, 0F, 0F);
        southStand = new ModelRenderer(this, 0, 36);
        southStand.addBox(-3.5F, -1F, -1F, 7, 2, 2);
        southStand.setRotationPoint(-4.5F, 0F, 0F);
        eastStand = new ModelRenderer(this, 0, 36);
        eastStand.addBox(-1F, -1F, -3.5F, 2, 2, 7);
        eastStand.setRotationPoint(0F, 0F, 4.5F);
        westStand = new ModelRenderer(this, 0, 36);
        westStand.addBox(-1F, -1F, -3.5F, 2, 2, 7);
        westStand.setRotationPoint(0F, 0F, -4.5F);

        baseStand.addChild(northStand);
        baseStand.addChild(southStand);
        baseStand.addChild(eastStand);
        baseStand.addChild(westStand);
        baseStand.rotateAngleY = (float) (Math.PI / 4F);

        bottomBulb = new ModelRenderer(this, 0, 36);
        bottomBulb.addBox(-5F, -3F, -5F, 10, 6, 10);
        bottomBulb.setRotationPoint(8F, 4.5F, 8F);

        chute = new ModelRenderer(this, 0, 36);
        chute.addBox(-2F, -1.5F, -2F, 4, 3, 4);
        chute.setRotationPoint(8F, 9F, 8F);

        topBulb = new ModelRenderer(this, 0, 36);
        topBulb.addBox(-3F, -3F, -3F, 6, 6, 6);
        topBulb.setRotationPoint(8F, 13F, 8F);
    }

    public void render(float scale) {

        baseStand.render(scale);
        bottomBulb.render(scale);
        chute.render(scale);
        topBulb.render(scale);

    }

    public void render(TileAludel aludel, double x, double y, double z) {

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslated(x, y, z);
        FMLClientHandler.instance().getClient().renderEngine.func_98187_b(Sprites.MODEL_ALUDEL);
        this.render(scale);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}
