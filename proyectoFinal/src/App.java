

import db.repository.GeneroRepository;
import models.Genero;

public class App {
    public static void main(String[] args) throws Exception {
        GeneroRepository generoRepository = new GeneroRepository();
        Genero g = generoRepository.recuperarId(1L);
        System.out.println(g.getNombre());
        

    }
}
