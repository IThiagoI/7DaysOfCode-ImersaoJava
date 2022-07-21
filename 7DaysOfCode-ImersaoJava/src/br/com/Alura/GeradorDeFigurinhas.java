package br.com.Alura;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
	
	public void criaFiguras(InputStream arquivo, String titulo) {
		
		
		try {
			BufferedImage imagemOriginal = ImageIO.read(arquivo);
			int largura = imagemOriginal.getWidth();
			int altura = imagemOriginal.getHeight();
			int novaAltura = altura;
			BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
			
			Graphics2D graficos = (Graphics2D)novaImagem.getGraphics();
			graficos.drawImage(imagemOriginal, 0, 0, null);
			
			//Font fonte = new Font(Font.SERIF, Font.BOLD, largura / 15);
			//graficos.setFont(fonte);
			//graficos.setColor(Color.RED);
			//String formatador = String.format("By: Thiago Campos");
			//graficos.drawString(formatador, (largura / 12), novaAltura - 50);
			
			ImageIO.write(novaImagem, "png", new File("figurinhas/" + titulo));
		} catch (IOException e) {
			e.getStackTrace();
		}
	}
}
