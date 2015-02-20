package com.jorisvanvugt.lolbadge;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class LoLBadge {
	
	private static final int BADGE_WIDTH = 1122;
	private static final int BADGE_HEIGHT = 732;
	private static HashMap<String, BufferedImage> rankLogos = new HashMap<String, BufferedImage>();
	private static BufferedImage LOL_LOGO;
	private static final int RANK_WIDTH = 256;
	private static final int RANK_HEIGHT = 256;
	private static final int LOL_WIDTH = 606;
	private static final int LOL_HEIGHT = 230;
	private static final int LOL_PADDING = 50;
	private static boolean imagesLoaded = false;
	private static final String FONT = "Friz Quadrata";
	
	
	private Participant participant;
	
	public LoLBadge(Participant participant){
		if(!imagesLoaded){
			try {
				LOL_LOGO = ImageIO.read(new File("res\\lolcolour.png"));
				
				rankLogos.put("Unranked", ImageIO.read(new File("res\\UNRANKED.png")));
				rankLogos.put("Bronze", ImageIO.read(new File("res\\BRONZE.png")));
				rankLogos.put("Silver", ImageIO.read(new File("res\\SILVER.png")));
				rankLogos.put("Gold", ImageIO.read(new File("res\\GOLD.png")));
				rankLogos.put("Platinum", ImageIO.read(new File("res\\PLATINUM.png")));
				rankLogos.put("Diamond", ImageIO.read(new File("res\\DIAMOND.png")));
				rankLogos.put("Master", ImageIO.read(new File("res\\MASTER.png")));
				rankLogos.put("Challenger", ImageIO.read(new File("res\\CHALLENGER.png")));
				
				imagesLoaded = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.participant = participant;
	}
	
	public BufferedImage toImage(){
		BufferedImage image = new BufferedImage(BADGE_WIDTH, BADGE_HEIGHT, BufferedImage.TYPE_INT_BGR);
		
		// Clear image to white
		for(int i = 0; i < image.getWidth(); i++)
		{
			for(int j = 0; j < image.getHeight(); j++){
				image.setRGB(i, j, 0xffffff);
			}
		}
		
		Graphics2D g2d = image.createGraphics();
		
		// Quality settings
		RenderingHints qualityHints = new RenderingHints(
             		RenderingHints.KEY_ANTIALIASING,
             		RenderingHints.VALUE_ANTIALIAS_ON);
		qualityHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		qualityHints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		qualityHints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHints(qualityHints);
    		
		g2d.setColor(Color.BLACK);
		
		g2d.setFont(new Font(FONT, Font.PLAIN, 86));
		drawCentered(participant.getSummonerName(), 0, BADGE_HEIGHT / 2, g2d);
		
		g2d.setFont(new Font(FONT, Font.PLAIN, 72));
		drawCentered(participant.getTeamName(), 0, (int) (BADGE_HEIGHT * 0.63), g2d);
		
		g2d.setFont(new Font(FONT, Font.PLAIN, 72));
		int rankX = drawCentered(participant.getRank(), RANK_WIDTH / 2, (int) (BADGE_HEIGHT * 0.87), g2d);
		
		g2d.drawImage(rankLogos.get(participant.getRank().split(" ")[0]), rankX - RANK_WIDTH, BADGE_HEIGHT - RANK_HEIGHT, RANK_WIDTH, RANK_HEIGHT, null);
		g2d.drawImage(LOL_LOGO, BADGE_WIDTH / 2 - LOL_WIDTH / 2, LOL_PADDING, LOL_WIDTH, LOL_HEIGHT, null);
		return image;
	}
	
	private int drawCentered(String s, int xPos, int yPos, Graphics2D g2d){
		int stringLen = (int) g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
	    int start = BADGE_WIDTH / 2 - stringLen / 2;
	    g2d.drawString(s, start + xPos, yPos);
	    return start + xPos;
	}
}
