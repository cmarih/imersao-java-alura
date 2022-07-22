import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class gerarstickers {

    public void cria() throws IOException {

        //leitura de uma imagem

        BufferedImage imgOriginal = ImageIO.read(new File("images/movie1.jpg"));

        //criar uma nova imagem em memoria, com transparencia e novo tamanho
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT); //Cria uma nova imagem com fundo transparente

        //copiar imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        //ajuste de tamanho e estilo de fonte
        var fonte = new Font("Comic Sans", Font.BOLD, 100 );
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 90, novaAltura - 100);

        //Criando o diretorio para adicionar imagem criada (caso não exista)
        String path = "./images/saida/";
        Files.createDirectories(Paths.get(path));

        //escrever a nova imaaem em um arquivo
        ImageIO.write(novaImagem, "png", new File(path + "movie.png"));

    }

    public static void main(String[] args) throws IOException {
        var geradora = new gerarstickers();
        geradora.cria();
    }
}
