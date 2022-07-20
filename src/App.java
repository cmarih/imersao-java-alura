import java.io.PrintStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // Fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://api.mocki.io/v2/549a5d8b";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        //System.out.println(body);

        //Extrair dados: Titulo, post e classificação - Utilizando expressão regular na classe JsonParser

        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        //Retorno da lista de filmes
        /*System.out.println(listaDeFilmes.size());
        System.out.println(listaDeFilmes.get(0));*/

        //Exibir e manipular os dados na aplicação

        for (Map<String,String> filme : listaDeFilmes) {
            var titulo = filme.get("title");
            var nota = filme.get("imDbRating");
            var imagem = filme.get("image");

            System.out.println(" \u001b[5m\u001b[30m\u001b[43m" + " Titulo: " + titulo + " \u001b[m ");
            System.out.println(" \u001b[1m" + " Poster: " + imagem + "\u001b[m");
            System.out.println(" \u001b[38;5;226m\u001b[48;5;53m Classificação: " + nota + " \u001b[m ");

            var rating = Double.parseDouble(nota);
            //System.out.println(nota);
                    if(rating >= 9) {

                       int numeroEstrelas = 1 ;

                       while(numeroEstrelas <= 5){
                           System.out.print(" \u001b[5m\u001b[33m\u2b50 ");
                            numeroEstrelas ++;
                       }
                        System.out.println();
                   } else {
                        int numeroEstrelas = 1 ;

                        while(numeroEstrelas <= 4){
                            System.out.print(" \u001b[5m\u001b[33m\u2b50\u001b[m ");
                            numeroEstrelas ++;
                        }
                        System.out.println();
                    }

            System.out.println();

        }
    }
}
