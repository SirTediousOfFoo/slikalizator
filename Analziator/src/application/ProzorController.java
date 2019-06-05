package application;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class ProzorController {
	
	BufferedImage bf = null;
	
	@FXML
	TextField imagePath;
	@FXML
	Button button;
	@FXML
	ImageView slika;
	@FXML
	ImageView slikaR;
	@FXML
	ImageView slikaG;
	@FXML
	ImageView slikaB;
	@FXML
	ImageView adjustedSlikaR;
	@FXML
	ImageView adjustedSlikaG;
	@FXML
	ImageView adjustedSlikaB;
	@FXML
	Slider sliderR;
	@FXML
	Slider sliderG;
	@FXML
	Slider sliderB;
	
//	/home/pero/Pictures/ker.jpg

	public void initialize()
	{
		sliderR.valueProperty().addListener((observable, oldValue, newValue) -> {

            onMoveSliderR(newValue.intValue());
		});
		sliderG.valueProperty().addListener((observable, oldValue, newValue) -> {

            onMoveSliderG(newValue.intValue());
		});
		sliderB.valueProperty().addListener((observable, oldValue, newValue) -> {

            onMoveSliderB(newValue.intValue());
		});
	}
	
	public void onMoveSliderR(int sliderValue)
	{
		WritableImage wr = null;
		if (bf != null) {
				wr = new WritableImage(bf.getWidth(), bf.getHeight());
				PixelWriter pw = wr.getPixelWriter();
				for (int x = 0; x < bf.getWidth(); x++) {
					for (int y = 0; y < bf.getHeight(); y++) {
						
						Color awtColor = new Color(bf.getRGB(x, y));
						int r = awtColor.getRed();
												
						if(r < sliderValue) 
							pw.setColor(x, y, javafx.scene.paint.Color.BLACK);	
						else 
							pw.setColor(x, y, javafx.scene.paint.Color.WHITE);							
					}
				}
			}
			adjustedSlikaR.setImage(wr);
	}
	public void onMoveSliderG(int sliderValue)
	{
		WritableImage wr = null;
		if (bf != null) {
				wr = new WritableImage(bf.getWidth(), bf.getHeight());
				PixelWriter pw = wr.getPixelWriter();
				for (int x = 0; x < bf.getWidth(); x++) {
					for (int y = 0; y < bf.getHeight(); y++) {
						
						Color awtColor = new Color(bf.getRGB(x, y));
						int r = awtColor.getGreen();
						
						if(r < sliderValue) 
							pw.setColor(x, y, javafx.scene.paint.Color.BLACK);	
						else 
							pw.setColor(x, y, javafx.scene.paint.Color.WHITE);							
					}
				}
			}
			adjustedSlikaG.setImage(wr);
	}
	public void onMoveSliderB(int sliderValue)
	{
		WritableImage wr = null;
		if (bf != null) {
				wr = new WritableImage(bf.getWidth(), bf.getHeight());
				PixelWriter pw = wr.getPixelWriter();
				for (int x = 0; x < bf.getWidth(); x++) {
					for (int y = 0; y < bf.getHeight(); y++) {
						
						Color awtColor = new Color(bf.getRGB(x, y));
						int r = awtColor.getBlue();

						if(r < sliderValue) 
							pw.setColor(x, y, javafx.scene.paint.Color.BLACK);	
						else 
							pw.setColor(x, y, javafx.scene.paint.Color.WHITE);							
					}
				}
			}
			adjustedSlikaB.setImage(wr);
	}
	
	public void onClickBtn() {

		bf = null;
		try {
			bf = ImageIO.read(new File(imagePath.getText()));
		} catch (IOException ex) {
			System.out.println("Image failed to load.");
		}

		WritableImage wr = null;
		if (bf != null) {
			wr = new WritableImage(bf.getWidth(), bf.getHeight());
			PixelWriter pw = wr.getPixelWriter();
			for (int x = 0; x < bf.getWidth(); x++) {
				for (int y = 0; y < bf.getHeight(); y++) {
					pw.setArgb(x, y, bf.getRGB(x, y));
				}
			}
		}

		slika.setImage(wr);

		if (bf != null) {
			wr = new WritableImage(bf.getWidth(), bf.getHeight());
			PixelWriter pw = wr.getPixelWriter();
			for (int x = 0; x < bf.getWidth(); x++) {
				for (int y = 0; y < bf.getHeight(); y++) {
					
					Color c = new Color(bf.getRGB(x, y));
					int r = c.getRed();
					
					pw.setArgb(x, y, new Color(r,r,r,r).getRGB());
					
				}
			}
		}
		slikaR.setImage(wr);
		
		if (bf != null) {
			wr = new WritableImage(bf.getWidth(), bf.getHeight());
			PixelWriter pw = wr.getPixelWriter();
			for (int x = 0; x < bf.getWidth(); x++) {
				for (int y = 0; y < bf.getHeight(); y++) {
					
					Color c = new Color(bf.getRGB(x, y));
					int r = c.getGreen();
					
					pw.setArgb(x, y, new Color(r,r,r,r).getRGB());
				}
			}
		}

		slikaG.setImage(wr);
		if (bf != null) {
			wr = new WritableImage(bf.getWidth(), bf.getHeight());
			PixelWriter pw = wr.getPixelWriter();
			for (int x = 0; x < bf.getWidth(); x++) {
				for (int y = 0; y < bf.getHeight(); y++) {
					Color c = new Color(bf.getRGB(x, y));
					int r = c.getBlue();
					
					pw.setArgb(x, y, new Color(r,r,r,r).getRGB());
				}
			}
		}

		slikaB.setImage(wr);
	}
}
